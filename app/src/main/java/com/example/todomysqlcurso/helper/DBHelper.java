package com.example.todomysqlcurso.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //ao atualizar o app muda aq, ira ativar o metodo onupgrade
    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";

    public static String TABELA_TAREFAS = "tarefas";

    public DBHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    //quando o user instalar o app
    @Override
    public void onCreate(SQLiteDatabase db) {

        //todo ao instalar o app já criar a tabela e adicionar os valores das tabuas passados como exemplo

        String query = "CREATE TABLE IF NOT EXISTS "+ TABELA_TAREFAS +" (id INTEGER PRIMARY KEY ) ";
    }

    //quando o usuário atualizar o app
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
