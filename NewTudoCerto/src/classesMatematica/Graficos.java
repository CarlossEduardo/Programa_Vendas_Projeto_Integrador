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
public class Graficos {
    
    //dataaset
    public CategoryDataset createDataset(ArrayList<ValorVendaDia> graficoVendaDia) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(ValorVendaDia vendadia : graficoVendaDia){

            dataset.addValue(vendadia.getNiClasses(), String.valueOf(vendadia.getXiClasses()), "");
            
        }
        
        return dataset;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart grafico = ChartFactory.createBarChart("Valores das Vendas por Dia", "Valor da Compra(xi)", "Quantidade(ni)", dataSet, PlotOrientation.VERTICAL,true,false,false);
       // JFreeChart histograma = ChartFactory.createHistogram("Valores das Vendas por Dia", "xi", "ni", dataSet, PlotOrientation.VERTICAL, true, true, true);
        //JFreeChart histograma = ChartFactory.create
        return grafico;
        
    }
    
    public ChartPanel criarGrafico(ArrayList<ValorVendaDia> valordia){
        CategoryDataset dataset = this.createDataset(valordia);
        
        JFreeChart grafiuco = this.createBarChart(dataset);
        ChartPanel painelDoGrafico = new ChartPanel(grafiuco);
        painelDoGrafico.setPreferredSize(new Dimension(550, 507));
        return painelDoGrafico;
        
    }
    
}
