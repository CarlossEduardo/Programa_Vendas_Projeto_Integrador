/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesMatematica;

/**
 *
 * @author Carlos Eduardo
 */
public class RelatorioClientes {
    String cpf_cliente_venda;
    String nome_clientes;
    int count;
    double sum;

    public RelatorioClientes() {
    }

    public RelatorioClientes(String cpf_cliente_venda, String nome_clientes, int count, double sum) {
        this.cpf_cliente_venda = cpf_cliente_venda;
        this.nome_clientes = nome_clientes;
        this.count = count;
        this.sum = sum;
    }

    public String getCpf_cliente_venda() {
        return cpf_cliente_venda;
    }

    public void setCpf_cliente_venda(String cpf_cliente_venda) {
        this.cpf_cliente_venda = cpf_cliente_venda;
    }

    public String getNome_clientes() {
        return nome_clientes;
    }

    public void setNome_clientes(String nome_clientes) {
        this.nome_clientes = nome_clientes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    
    
    
}
