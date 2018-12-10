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
public class GraficoVendasDia {
    public CategoryDataset createDataset(ArrayList<VendaDia> graficoVendaDia) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < graficoVendaDia.size(); i++) {
       
            dataset.addValue(graficoVendaDia.get(i).getNi(), String.valueOf(graficoVendaDia.get(i).getXi()), "");
        }

        
        return dataset;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart grafico = ChartFactory.createBarChart("Quantidade de Vendas por Dia", "Vendaspor Dia(xi)","Quantidade(ni)", dataSet, PlotOrientation.VERTICAL,true,false,false);
        //JFreeChart histograma = ChartFactory.createHistogram("Valores das Vendas por Dia", "xi", "ni", null ,dataset, PlotOrientation.VERTICAL, true, true, true);
        //JFreeChart histograma = ChartFactory.create
        return grafico;
        
    }
    
    public ChartPanel criarGrafico(ArrayList<VendaDia> valordia){
        CategoryDataset dataset = this.createDataset(valordia);
        
        JFreeChart grafiuco = this.createBarChart(dataset);
        ChartPanel painelDoGrafico = new ChartPanel(grafiuco);
        painelDoGrafico.setPreferredSize(new Dimension(576, 453));
        return painelDoGrafico;
        
    }
    
}
