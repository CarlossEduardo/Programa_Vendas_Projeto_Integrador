/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Dados {
    
    public static ArrayList<Clientes> listaClientes = new ArrayList<>();
    public static ArrayList<Produtos> listaProdutos = new ArrayList<>();
    public static ArrayList<Vendas> listaVendas = new ArrayList<>();

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public ArrayList<Vendas> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(ArrayList<Vendas> listaVendas) {
        this.listaVendas = listaVendas;
    }
    
    
    
        public static void lerArquivo() throws Exception {
		String linha;
		String[] vet;
		Clientes c;
                String darCertologo = "D:\\CSV.txt";
                
            
            FileReader arq = new FileReader(darCertologo);
	    BufferedReader lerArq = new BufferedReader(arq);
		
	    while (lerArq.ready()) {
			linha = lerArq.readLine();
			
			if (linha.charAt(0) != '#' && linha.charAt(0) != 'P' && linha.charAt(0) == 'C') {
				
				vet = linha.split(";");
                             //   c = new Clientes(linha, linha, linha, linha, WIDTH, linha, linha, linha, linha, linha);

			//	c = new Clientes(vet[1], vet[2], vet[3], vet[4], Integer.parseInt(vet[5]), vet[6], vet[7], vet[8], vet[9], vet[10]);
                               // System.out.println(c.getCEP());
				//System.out.println("add o continente "+ vet[2]);
		//		listaClientes.add(c);
			}
		}
	    lerArq.close();
	    arq	.close();
	}
    
        public static void lerArquivoVenda() throws Exception{
            String linha;
            String[] vet;
            Vendas v;
            String darCertologo = "D:\\CSVVENDA.txt";
            
            FileReader arq1 = new FileReader(darCertologo);
	    BufferedReader lerArq1 = new BufferedReader(arq1);
            
            while (lerArq1.ready()) {
			linha = lerArq1.readLine();
			
			if (linha.charAt(0) != '#' && linha.charAt(0) != 'P' && linha.charAt(0) == 'V') {
				
				vet = linha.split(";");
                             //   c = new Clientes(linha, linha, linha, linha, WIDTH, linha, linha, linha, linha, linha);

				//v = new Vendas(Integer.parseInt(vet[1]), vet[2], vet[3], vet[4], vet[5], vet[6]);
                               // listaVendas.add(v);
                               // listaVendas.get(0).setProdutoVenda();  vou colocar um array dentro
                                //System.out.println(c.getCEP());
				//System.out.println("add o continente "+ vet[2]);
				//listaClientes.add(c);
			}
		}
	    lerArq1.close();
	    arq1.close();
            
            
        }
        public static void lerArquivoProduto() throws Exception{
            String linha;
            String[] vet;
            Produtos p;
            String darCertologo = "D:\\CSVPRODUTO.txt";

            FileReader arq2 = new FileReader(darCertologo);
	    BufferedReader lerArq2 = new BufferedReader(arq2);
            
            while (lerArq2.ready()) {
			linha = lerArq2.readLine();
			             System.out.println("sera");
			if (linha.charAt(0) != '#' && linha.charAt(0) == 'P') {
				                      
				vet = linha.split(";");
                             //   c = new Clientes(linha, linha, linha, linha, WIDTH, linha, linha, linha, linha, linha);

				p = new Produtos(Integer.parseInt(vet[1]), vet[2], Double.parseDouble(vet[3]), vet[4]);
                                listaProdutos.add(p);
                                int i = 0;
                                System.out.println("Add produto"+ listaProdutos.get(i).getDescricao());
                                

			}
		}
	    lerArq2.close();
	    arq2.close();
            
        }
        
}
