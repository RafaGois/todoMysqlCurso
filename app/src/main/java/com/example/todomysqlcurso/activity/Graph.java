package com.example.todomysqlcurso.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.todomysqlcurso.R;
import com.example.todomysqlcurso.helper.DBHelper;
import com.example.todomysqlcurso.helper.TarefaDAO;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        agrega();
    }

    private void agrega () {

        BarChart barChart = findViewById(R.id.graficoBarras);


        TarefaDAO tarefaDAO = new TarefaDAO(this);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i < tarefaDAO.listar().size(); i++) {

            BarEntry barEntry = new BarEntry(i,tarefaDAO.listar().get(i).getId());

            PieEntry pieEntry = new PieEntry(i,tarefaDAO.listar().get(i).getId());

            barEntries.add(barEntry);

            pieEntries.add(pieEntry);

        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"Employee");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        //barDataSet.setDrawValues(false);//olhar iso
        barChart.setData(new BarData(barDataSet));

        barChart.animateY(6000);

        barChart.getDescription().setText("Descricao");
        barChart.getDescription().setTextColor(Color.BLUE);

        PieChart pieChart = findViewById(R.id.graficoPizza);

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"Slaaa");
        pieDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        //pieDataSet.setDrawValues(false);//olhar iso
        pieChart.setData(new PieData(pieDataSet));

        barChart.animateY(6000);

        barChart.getDescription().setText("Descricao");
        barChart.getDescription().setTextColor(Color.GREEN);
    }
}