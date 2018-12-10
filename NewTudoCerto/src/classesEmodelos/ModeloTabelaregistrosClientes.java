/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import static Bancaria.Matematica.InfoClientes;
import classesMatematica.RelatorioClientes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Eduardo
 */
public class ModeloTabelaregistrosClientes extends AbstractTableModel{
    ArrayList<RelatorioClientes> vendas;
    private String[] colunas = {"Nome do Cliente", "CPF do Cliente", "Número de Compras","Valor Total(Compras)"};

    public ModeloTabelaregistrosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
			return vendas.get(linha).getNome_clientes();
		case 1:
			return vendas.get(linha).getCpf_cliente_venda();	
		case 2:
			return vendas.get(linha).getCount();
                case 3:
			return vendas.get(linha).getSum();
		}
		return null;
                
	
    }

    public ModeloTabelaregistrosClientes(java.util.Date datainico, java.util.Date datafim) throws Exception {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicio = df.format(datainico);
                String dataFim = df.format(datafim); 
        vendas = InfoClientes(datainico, datafim);
    }
    
    
}
