package com.example.todomysqlcurso.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomysqlcurso.R;
import com.example.todomysqlcurso.adapter.TarefaAdapter;
import com.example.todomysqlcurso.helper.RecyclerItemClickListener;
import com.example.todomysqlcurso.helper.TarefaDAO;
import com.example.todomysqlcurso.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> tarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerV);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Tarefa tarefaSelecionada = tarefas.get(position);

                                Intent intent = new Intent(MainActivity.this,AddTarefaActivity.class);
                                intent.putExtra("Tarefa",tarefaSelecionada);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                tarefaSelecionada = tarefas.get(position);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir a tarefa :"+ tarefaSelecionada.getId()+" ?");
                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                                        if (tarefaDAO.deletar(tarefaSelecionada)) {
                                            Toast.makeText(MainActivity.this, "TAREFA DELETADA", Toast.LENGTH_SHORT).show();
                                            carregarListaTarefas();
                                        } else {
                                            Toast.makeText(MainActivity.this, "ERRO AO EXCLUIR TAREFA", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.setNegativeButton("Não", null);

                                dialog.create();

                                dialog.show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    //sempre que sair da activity e voltar irá recarregar a listagem
    @Override
    protected void onStart() {
        super.onStart();

        carregarListaTarefas();
    }

    public void adiciona (View view){

        Intent intent = new Intent(getApplicationContext(), AddTarefaActivity.class);
        startActivity(intent);

    }

    public void carregarListaTarefas () {

        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        tarefas = tarefaDAO.listar();

        tarefaAdapter = new TarefaAdapter(tarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);
    }

    public void navegaGrath (View view) {
        Intent intent = new Intent(this,Graph.class);
        startActivity(intent);
    }
}