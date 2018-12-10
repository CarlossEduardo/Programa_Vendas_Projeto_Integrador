/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesEmodelos;

/**
 *
 * @author Carlos Eduardo
 */
public class Clientes {
    
    private String cpfCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String tipoTelefone;
    private String cepCliente;
    private String bairro;
    private String rua;
    private String complemento;
    private String UF;
    private String cidade;

    public Clientes(String CPF, String nome, String Telefone, String tipoTelefone, String CEP, String bairro, String rua, String complemento, String UF, String cidade) {
        this.cpfCliente = CPF;
        this.nomeCliente = nome;
        this.telefoneCliente = Telefone;
        this.tipoTelefone = tipoTelefone;
        this.cepCliente = CEP;
        this.bairro = bairro;
        this.rua = rua;
        this.complemento = complemento;
        this.UF = UF;
        this.cidade = cidade;
    }

    public Clientes() {
        
    }



    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    
}
