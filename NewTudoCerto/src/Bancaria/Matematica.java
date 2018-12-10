/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancaria;

import classesMatematica.RelatorioClientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Eduardo
 */
public class Matematica {
    
        public static ArrayList<Integer> PegarRol(java.util.Date datainico, java.util.Date datafim) throws Exception{           
           
        
         
            
        ArrayList<Integer> resultado = new ArrayList<>();  
        
            try (Connection con = Conexao.getConnection();){
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicio = df.format(datainico);
                String dataFim = df.format(datafim);
                
                System.out.println(dataInicio);
                
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select count(data_venda), data_venda from venda WHERE data_venda BETWEEN '" + dataInicio + "' AND '"+ dataFim +"' group by data_venda having count(data_venda)>=1 order by 1	");
                while(rs.next()){
                    int p = rs.getInt("count");
    
                    System.out.println("issso é " +p);
                    resultado.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Matematica.class.getName()).log(Level.SEVERE, null, ex);
                throw new erros("Erro ao incluir :\n" + ex.getMessage());
            }
            return resultado;
        }
        
        public static ArrayList<Double> PegardadosPclasse(java.util.Date datainico, java.util.Date datafim) throws Exception{           
    
        ArrayList<Double> resultado = new ArrayList<>();  
        
            try (Connection con = Conexao.getConnection();){
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicio = df.format(datainico);
                String dataFim = df.format(datafim);               
                             
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUM(valor_total_venda) , data_venda FROM venda WHERE data_venda BETWEEN '" + dataInicio + "' AND '"+ dataFim +"' GROUP BY data_venda order by 1");
                while(rs.next()){
                    double p = rs.getDouble("sum");
                    resultado.add(p);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Matematica.class.getName()).log(Level.SEVERE, null, ex);
                throw new erros("Erro ao incluir :\n" + ex.getMessage());
            }
            return resultado;
        }
        
        
                public static ArrayList<Integer> PegarFormapagamento() throws Exception{           
    
        ArrayList<Integer> resultado = new ArrayList<>();  
        
            try (Connection con = Conexao.getConnection();){                
                            
                             
                Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select forma_pagamento_venda, count(forma_pagamento_venda) from venda group by forma_pagamento_venda having count(forma_pagamento_venda)>=1 order by 1");
                while(rs.next()){
                    int p = rs.getInt("count");
                    resultado.add(p);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Matematica.class.getName()).log(Level.SEVERE, null, ex);
                throw new erros("Erro ao incluir :\n" + ex.getMessage());
            }
            return resultado;
        }
          
                
        public static ArrayList<RelatorioClientes> InfoClientes(java.util.Date datainico, java.util.Date datafim) throws Exception{           
    
        ArrayList<RelatorioClientes> resultado = new ArrayList<>();  
        
            try (Connection con = Conexao.getConnection();){                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicio = df.format(datainico);
                String dataFim = df.format(datafim);               
                                         
                             
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select cpf_cliente_venda, count(cpf_cliente_venda), sum(valor_total_venda) from venda WHERE data_venda BETWEEN '" + dataInicio + "' AND '"+ dataFim +"' group by cpf_cliente_venda ");
                while(rs.next()){
                        RelatorioClientes c = new RelatorioClientes();
                        c.setCpf_cliente_venda(rs.getString("cpf_cliente_venda"));
                        c.setCount(rs.getInt("count"));
                        c.setSum(rs.getDouble("sum"));
              
                        resultado.add(c);
                }
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select cpf_clientes, nome_clientes from clientes ");
                while(rs1.next()){
                      for (int i = 0; i < resultado.size(); i++) {
                          if (resultado.get(i).getCpf_cliente_venda().equalsIgnoreCase(rs1.getString("cpf_clientes"))) {
                              resultado.get(i).setNome_clientes(rs1.getString("nome_clientes"));
                          }
                    }

                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Matematica.class.getName()).log(Level.SEVERE, null, ex);
                throw new erros("Erro ao incluir :\n" + ex.getMessage());
            }
            return resultado;
        }
                
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
}
