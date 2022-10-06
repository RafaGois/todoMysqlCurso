package com.example.todomysqlcurso.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todomysqlcurso.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DBHelper db = new DBHelper( context );

        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        try {
            escreve.insert(DBHelper.TABELA_TAREFAS,null,cv);
            Log.i("ATT ","Tarefa salva com sucesso");
        } catch (Exception e) {
            Log.e("Erro",e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        String args [] = { tarefa.getId().toString() };

        //usamos o array pq pode ter mais de uma clausula
        try {
            escreve.update(DBHelper.TABELA_TAREFAS,cv, "id=?", args);
            Log.i("ATT ","Tarefa atualizada com sucesso");
        } catch (Exception e) {
            Log.e("Erro",e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM "+ DBHelper.TABELA_TAREFAS+";";

        Cursor c = le.rawQuery(sql,null);

        c.moveToFirst();
        while (c.moveToNext()) {
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
