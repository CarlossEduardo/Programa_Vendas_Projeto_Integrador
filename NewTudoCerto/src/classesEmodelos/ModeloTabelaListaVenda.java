/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;


import static Bancaria.ProdutosBanco.listarProdutos;
import static classesEmodelos.Dados.listaProdutos;
import static classesEmodelos.ModelotabelaProdutos.produtos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloTabelaListaVenda extends AbstractTableModel{
        static ArrayList<ProdutosTabela> produtos = new ArrayList<>();
        public String[] colunas = {"Codigo", "Desrição", "Quantidade", "Preço Unitario", "Total"};

    public ModeloTabelaListaVenda() {
  
    }
        
    
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
			return produtos.get(linha).getCodigoProduto();
		case 1:
			return produtos.get(linha).getDescricao();	
		case 2:
			return produtos.get(linha).getQuantidade();
                case 3: 
                    return produtos.get(linha).getValorUnitario();
                case 4: 
                    return produtos.get(linha).getValorTotal();
		}
            
		return null;
    }
    public static void addprodutos(ProdutosTabela produto){
        produtos.add(produto);
        
        
    }
        public static void limparArrayProdutotabela(){
        produtos.clear();
        
    }
    
    
    
        
        
}
