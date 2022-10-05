package com.example.todomysqlcurso.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomysqlcurso.R;
import com.example.todomysqlcurso.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder>  {

    List<Tarefa> tarefas;

    public TarefaAdapter(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_tarefa_adapter,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tarefa tarefa = tarefas.get(position);
        holder.nomeTarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeTarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTarefa = itemView.findViewById(R.id.textTarefa);
        }
    }

}
