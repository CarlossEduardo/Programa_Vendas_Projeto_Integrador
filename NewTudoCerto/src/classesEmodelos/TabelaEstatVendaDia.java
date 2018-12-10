/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import classesMatematica.VendaDia;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Eduardo
 */
public class TabelaEstatVendaDia extends AbstractTableModel{
    
    ArrayList<VendaDia> vendas;
    private String[] colunas = {"Vendaspor Dia(xi)", "Quantidade(ni)", "xi.ni","Porcentagem", "(x-X)².ni"};
    
    
    @Override
    public String getColumnName(int colunaa) {	
    	return colunas[colunaa];
    }    
    
    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return  colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int colunas) {
        	switch (colunas) {
		case 0:
			return vendas.get(linha).getXi();
		case 1:
			return vendas.get(linha).getNi();	
		case 2:
			return vendas.get(linha).getNixi();
                case 3:
			return vendas.get(linha).getPorcentagem();
                case 4:
			return vendas.get(linha).getConta();

		}
		return null;
                
	
    }
    
    public TabelaEstatVendaDia(ArrayList<VendaDia> venda){
        vendas = venda; 
        
        
    }
    
}
