package com.example.todomysqlcurso.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //ao atualizar o app muda aq, ira ativar o metodo onupgrade
    public static int VERSION = 3;
    public static String NOME_DB = "DB_TAREFAS";

    public static String TABELA_TAREFAS = "tarefas";

    public DBHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    //quando o user instalar o app
    @Override
    public void onCreate(SQLiteDatabase db) {

        //todo ao instalar o app já criar a tabela e adicionar os valores das tabuas passados como exemplo

        String query = "CREATE TABLE IF NOT EXISTS "+ TABELA_TAREFAS +" (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, descricao TEXT);";
        String queryAdd = "INSERT INTO "+TABELA_TAREFAS+" (nome, descricao) VALUES ('TESTE','VALOR ADICONADO AO CRIAR O APP')";

        try {
            db.execSQL(query);

            for (int i = 0; i < 5; i++) {
                db.execSQL(queryAdd);
            }

            Log.i("INFO DB","Sucesso ao criar tabela");

        }catch (Exception e) {
            Log.i("INFO DB","Erro ao criar tabela"+ e.getMessage());
        }

    }

    //quando o usuário atualizar o app
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //DELETA A TABELA AO ATUALIZAR VERSAO
        String query = "DROP TABLE IF EXISTS "+ TABELA_TAREFAS +";";

        try {

            db.execSQL(query);
            //cria a tabela
            onCreate(db);
            Log.i("INFO DB","Sucesso ao atualizar tabela");

        }catch (Exception e) {
            Log.i("INFO DB","Erro ao atualizar tabela"+ e.getMessage());
        }
    }
}
