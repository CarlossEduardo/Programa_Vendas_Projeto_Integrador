/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

import java.util.ArrayList;





/**
 *
 * @author Carlos Eduardo
 */
public class Vendas {
    int nota_fiscal_venda ;
    String cpfClienteVenda;
    Double desconto_venda ;
    String forma_pagamento_venda ;
    Double valor_total_venda;
    String data_venda;
   // ArrayList<String> lista_produtos_venda;
   // ArrayList<String> quantidade_produtos_venda;

    public Vendas(int nota_fiscal_venda, String cpfClienteVenda, Double desconto_venda, String forma_pagamento_venda, Double valor_total_venda, String data_venda) {
        this.nota_fiscal_venda = nota_fiscal_venda;
        this.cpfClienteVenda = cpfClienteVenda;
        this.desconto_venda = desconto_venda;
        this.forma_pagamento_venda = forma_pagamento_venda;
        this.valor_total_venda = valor_total_venda;
        this.data_venda = data_venda;
    }

    public Vendas(String cpfClienteVenda, Double desconto_venda, String forma_pagamento_venda, Double valor_total_venda) {
        this.cpfClienteVenda = cpfClienteVenda;
        this.desconto_venda = desconto_venda;
        this.forma_pagamento_venda = forma_pagamento_venda;
        this.valor_total_venda = valor_total_venda;
    }



    public Vendas() {
    }

    public int getNota_fiscal_venda() {
        return nota_fiscal_venda;
    }

    public void setNota_fiscal_venda(int nota_fiscal_venda) {
        this.nota_fiscal_venda = nota_fiscal_venda;
    }

    public String getCpfClienteVenda() {
        return cpfClienteVenda;
    }

    public void setCpfClienteVenda(String cpfClienteVenda) {
        this.cpfClienteVenda = cpfClienteVenda;
    }

    public Double getDesconto_venda() {
        return desconto_venda;
    }

    public void setDesconto_venda(Double desconto_venda) {
        this.desconto_venda = desconto_venda;
    }

    public String getForma_pagamento_venda() {
        return forma_pagamento_venda;
    }

    public void setForma_pagamento_venda(String forma_pagamento_venda) {
        this.forma_pagamento_venda = forma_pagamento_venda;
    }

    public Double getValor_total_venda() {
        return valor_total_venda;
    }

    public void setValor_total_venda(Double valor_total_venda) {
        this.valor_total_venda = valor_total_venda;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }
    
}