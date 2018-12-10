/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesMatematica;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Carlos Eduardo
 */
public class GraficoFormaPagamento {
    String[] formadepagamento = {"Boleto", "Cartão Credito", "Cartão Debito", "Dinheiro"};
    
    
    public CategoryDataset createDataset(ArrayList<Integer> numFormaPagamento) {
        System.out.println("ainda n achei");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.println("sou besta");
        for (int i = 0; i < numFormaPagamento.size(); i++) {
            System.out.println("é aqui?");
            dataset.addValue(numFormaPagamento.get(i), formadepagamento[i], "");
        }

            
            
        
        
        return dataset;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart grafico = ChartFactory.createBarChart("Valores das Vendas por Dia", "xi", "ni", dataSet, PlotOrientation.VERTICAL,true,false,false);
       // JFreeChart histograma = ChartFactory.createHistogram("Valores das Vendas por Dia", "xi", "ni", dataSet, PlotOrientation.VERTICAL, true, true, true);
        //JFreeChart histograma = ChartFactory.create
        return grafico;
        
    }
    
    public ChartPanel criarGrafico(ArrayList<Integer> numforma){
        
        
        
        System.out.println("me explica?");
        CategoryDataset dataset = this.createDataset(numforma);
        
        System.out.println("é aqui?");
        JFreeChart grafiuco = this.createBarChart(dataset);
        ChartPanel painelDoGrafico = new ChartPanel(grafiuco);
        painelDoGrafico.setPreferredSize(new Dimension(637, 521));
        return painelDoGrafico;
        
    }
    
}
