package com.example.todomysqlcurso.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todomysqlcurso.R;
import com.example.todomysqlcurso.helper.TarefaDAO;
import com.example.todomysqlcurso.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AddTarefaActivity extends AppCompatActivity {

    private EditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        editTarefa = findViewById(R.id.inputTarefa);

        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("nomeTarefa");

        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_tarefa,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSalvar:

                TarefaDAO tarefaDAO = new TarefaDAO( getApplicationContext() );

                if (tarefaAtual != null) {

                    String nomeTarefa = editTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        if (tarefaDAO.atualizar(tarefa)) {
                            Toast.makeText(this, "SUCESSO AO ATUALIZAR", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "ERRO AO ATUALIZAR", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {


                    String nomeTarefa = editTarefa.getText().toString();

                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if (tarefaDAO.salvar(tarefa)) {
                            Toast.makeText(this, "Sucesso ao salvar Tarefa", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}