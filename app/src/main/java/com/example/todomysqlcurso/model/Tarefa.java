package com.example.todomysqlcurso.model;

import java.io.Serializable;

//usa o serializable para passar tarefa para outra tela
public class Tarefa implements Serializable {

    private Long id;
    private String nomeTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
