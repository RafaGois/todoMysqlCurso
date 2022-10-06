package com.example.todomysqlcurso.helper;

import com.example.todomysqlcurso.adapter.TarefaAdapter;
import com.example.todomysqlcurso.model.Tarefa;

import java.util.List;

public interface ITarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar (Tarefa tarefa);
    public boolean deletar (Tarefa tarefa);

    public List<Tarefa> listar ();
}
