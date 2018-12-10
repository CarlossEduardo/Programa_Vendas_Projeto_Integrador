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
public class Produtos {
    private Integer codigo;
    private String descricao;
    private double precoUnitario;
    private String unidadeMedida;

    public Produtos(Integer codigo, String descricao, double precoUnitario, String unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.unidadeMedida = unidadeMedida;
    }

    public Produtos() {
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    
    //Esse metodo não deveira estar aqui , mas fazer oque
    public static void listaprodutos(){
        ArrayList<ProdutosTabela> resultado = new ArrayList();
       // ProdutosTabela p1 = new ProdutosTabela(campoCodigoVenda.getText(), labelProdutoVenda.getText(), campoQuantidadeVenda.getText(), labelValorUniVenda.getText(), labelValorVenda.getText());
        
    }
    
    
}
