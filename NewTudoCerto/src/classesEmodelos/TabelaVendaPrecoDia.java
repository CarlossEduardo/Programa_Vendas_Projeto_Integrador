/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import classesMatematica.ValorVendaDia;
import classesMatematica.VendaDia;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class TabelaVendaPrecoDia extends AbstractTableModel{
    
    ArrayList<ValorVendaDia> vendas;
    private String[] colunas = {"Classes", "XI", "NI", "XI.NI","Porcentagem", "(x-X)².ni"};
    
    
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
			return vendas.get(linha).getClasses();
		case 1:
			return vendas.get(linha).getXiClasses();	
		case 2:
			return vendas.get(linha).getNiClasses();
                case 3:
			return vendas.get(linha).getXiniClasses();
                case 4:
			return vendas.get(linha).getPorcentagemClasses();
                case 5:
			return vendas.get(linha).getContaClasses();                        

		}
		return null;
                
	
    }
    
    public TabelaVendaPrecoDia(ArrayList<ValorVendaDia> vendaDia){
        vendas = vendaDia; 
    }
    
}
