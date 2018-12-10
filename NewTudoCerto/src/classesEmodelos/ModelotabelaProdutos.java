
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import static Bancaria.ProdutosBanco.listarProdutos;
import static classesEmodelos.Dados.listaProdutos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Carlos Eduardo
 */
public class ModelotabelaProdutos extends AbstractTableModel{
    
    
    static ArrayList<Produtos> produtos;

    public ModelotabelaProdutos() throws Exception {
        produtos = listarProdutos();
    }
    
     public String[] colunas = {"Codigo", "Desrição", "Preço", "Medida"};
    
    @Override
    public String getColumnName(int colunaa) {	
    	return colunas[colunaa];
    }
    
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
            switch (coluna) {
		case 0:
			return produtos.get(linha).getCodigo();
		case 1:
			return produtos.get(linha).getDescricao();	
		case 2:
			return produtos.get(linha).getPrecoUnitario();
                case 3: 
                    return produtos.get(linha).getUnidadeMedida();
		}
		return null;
    }


    
}
