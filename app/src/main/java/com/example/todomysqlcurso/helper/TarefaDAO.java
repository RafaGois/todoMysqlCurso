package com.example.todomysqlcurso.helper;

import com.example.todomysqlcurso.model.Tarefa;

import java.util.List;

public class TarefaDAO implements ITarefaDAO{


    @Override
    public boolean salvar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> tarefas() {
        return null;
    }
}
