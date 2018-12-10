/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import static Bancaria.Matematica.PegarFormapagamento;
import classesMatematica.VendaDia;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class ModeloTabelaFormaPagamento extends AbstractTableModel{
    
    ArrayList<Integer> vendas;
    ArrayList<String> porcentagem;

    String[] formas = {"Boleto", "Cartão Credito", "Cartão Debito", "Dinheiro"};
    
    String[] colunas = {"Forma de Pagamento(xi)", "ni", "Porcentagem"};

    @Override
    public int getRowCount() {
       return vendas.size();
    }
        @Override
    public String getColumnName(int colunaa) {	
    	return colunas[colunaa];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
     public Object getValueAt(int linha, int coluna) {


            switch (coluna) {
		case 0:
			return formas[linha];
		case 1:
			return vendas.get(linha);
                case 2: 
                        return porcentagem.get(linha);
		}
            
		return null;
    }

    public ModeloTabelaFormaPagamento() throws Exception {
        vendas = PegarFormapagamento();
        porcentagem = new ArrayList<String>();
        int soma = 0;
        for (int i = 0; i < vendas.size(); i++) {
            soma = soma + vendas.get(i);
        }
        for (int i = 0; i < vendas.size(); i++) {
            Double porce = ((double)vendas.get(i) / (double)soma) *100;
            DecimalFormat df = new DecimalFormat("0.00");
            String percent = df.format(porce);
            percent = percent.replaceAll(",", ".");
            percent = percent + " %";
            porcentagem.add(percent);
            
            System.out.println(porcentagem.get(i));
        }
     
    
    
    }
}