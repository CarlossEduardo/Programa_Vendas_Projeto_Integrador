/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import Bancaria.ClienteBanco;
import static Bancaria.ClienteBanco.listar;

import static classesEmodelos.Dados.listaClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Eduardo
 */
public class ModeloTabelaCliente extends AbstractTableModel {
    

    public static ArrayList<Clientes> clientes;
    
    

    public ModeloTabelaCliente() throws Exception {
   
       clientes = listar();
        System.out.println("oi");
    }

    private String[] colunas = {"CPF", "Nome", "Telefone","Tipo", "Cep","Bairro","Rua","Complemento","Estado","Cidade"};
 
    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public String getColumnName(int colunaa) {	
    	return colunas[colunaa];
    }    
  
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return  colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       // ArrayList<Clientes> clientes = ClienteBanco.listar();
        // ModeloTabelaCliente.addRow(new Object[]{clientes.getCpfCliente(), clientes.getNomeCliente(),clientes.getTelefoneCliente(), clientes.getTipoTelefone(), clientes.getCepCliente(), clientes.getBairro(), clientes.getRua(), clientes.getComplemento(), clientes.getUF(), clientes.getCidade()});
    //}
        
        		switch (coluna) {
		case 0:
			return clientes.get(linha).getCpfCliente();
		case 1:
			return clientes.get(linha).getNomeCliente();	
		case 2:
			return clientes.get(linha).getTelefoneCliente();
                case 3:
			return clientes.get(linha).getTipoTelefone();
                case 4:
			return clientes.get(linha).getCepCliente();
                case 5:
			return clientes.get(linha).getBairro();
                case 6:
			return clientes.get(linha).getRua();
                
                case 7:
			return clientes.get(linha).getComplemento();
                case 8:
			return clientes.get(linha).getUF();
                case 9:
			return clientes.get(linha).getCidade();
		}
		return null;
	
    }
    


    
    
}
