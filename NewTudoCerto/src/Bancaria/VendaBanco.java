/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancaria;

import classesEmodelos.ProdutosTabela;
import classesEmodelos.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Eduardo
 */
public class VendaBanco {
        
    
    
        public static void inserirVend(Vendas vendas) throws Exception{
        
        try (Connection con = Conexao.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("insert into venda (cpf_cliente_venda, desconto_venda, forma_pagamento_venda, valor_total_venda) values (?, ?, ?, ?)");
            pstmt.setString(1, vendas.getCpfClienteVenda());
            pstmt.setDouble(2, vendas.getDesconto_venda());
            pstmt.setString(3, vendas.getForma_pagamento_venda());
            pstmt.setDouble(4, vendas.getValor_total_venda());
            pstmt.executeUpdate();
            System.out.println("Foi  boi?");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        
    }
    
        public static void inserirVenda(Vendas vendas, int i) throws Exception{
        
        try (Connection con = Conexao.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("insert into venda (codigo_venda, cpf_cliente_venda, desconto_venda, forma_pagamento_venda, valor_total_venda) values (?, ?, ?, ?, ?)");
            pstmt.setInt(1, i);
            pstmt.setString(2, vendas.getCpfClienteVenda());
            pstmt.setDouble(3, vendas.getDesconto_venda());
            pstmt.setString(4, vendas.getForma_pagamento_venda());
            pstmt.setDouble(5, vendas.getValor_total_venda());
            pstmt.executeUpdate();
            System.out.println("Foi?");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        
    }
        
        public static ArrayList<Vendas> listarVendas() throws erros{           
            
            ArrayList<Vendas> resultado = new ArrayList<>();           
        try (Connection con = Conexao.getConnection();){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from venda");
            while(rs.next()){
                Vendas p = new Vendas();
                
                p.setNota_fiscal_venda(rs.getInt("codigo_venda"));
                p.setCpfClienteVenda(rs.getString("cpf_clientes"));
                p.setDesconto_venda(rs.getDouble("desconto_venda"));
                p.setForma_pagamento_venda(rs.getString("forma_pagamento_venda"));
                p.setValor_total_venda(rs.getDouble("valor_total_venda"));
                p.setData_venda(rs.getString("data_venda"));
 
                resultado.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        return resultado;
    }
        
        
        
        
        public static Integer PegarCodigoVenda() throws erros{
            int i = 0;
        try (Connection con = Conexao.getConnection();){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(codigo_venda) FROM venda");
             while(rs.next()){
                 
               i = new Integer(Integer.parseInt(rs.getString("max")));

               
             }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        return i;
            
            
        }
        
 
         public static void inserirProdutosVenda(ArrayList<ProdutosTabela> produtos, Integer codigo) throws erros{
             
            try (Connection con = Conexao.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("insert into produtos_venda (codigo_venda, codigo_produto_venda, descricao_produto_venda, valor_unidade_venda, quantidade_produto_venda) values (?, ?, ?, ?, ?)");
            for (int i = 0; i < produtos.size(); i++) {
                
            pstmt.setInt(1, codigo);
            pstmt.setString(2, produtos.get(i).getCodigoProduto());
            pstmt.setString(3, produtos.get(i).getDescricao());
            pstmt.setDouble(4, produtos.get(i).getValorUnitario());
            pstmt.setString(5, String.valueOf(produtos.get(i).getQuantidade()));
           // pstmt.setInt(0, 0);
            //pstmt.setDouble(2, vendas.getDesconto_venda());
            //pstmt.setString(3, vendas.getForma_pagamento_venda());
            //pstmt.setDouble(4, vendas.getValor_total_venda());
            pstmt.executeUpdate();
            }
            System.out.println("Foi?");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
             
             
         }             
}
