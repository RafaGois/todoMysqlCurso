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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        editTarefa = findViewById(R.id.inputTarefa);
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

                String nomeTarefa = editTarefa.getText().toString();

                if (!nomeTarefa.isEmpty()) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    tarefaDAO.salvar(tarefa);
                    finish();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}