/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesMatematica;


public class VendaDia {

    int xi;
    int ni;
    int nixi;
    double porcentagem;
    double conta;

    public VendaDia() {
    }

    public VendaDia(int xi, int ni, int nixi, double porcentagem, double conta) {
        this.xi = xi;
        this.ni = ni;
        this.nixi = nixi;
        this.porcentagem = porcentagem;
        this.conta = conta;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getNi() {
        return ni;
    }

    public void setNi(int ni) {
        this.ni = ni;
    }

    public int getNixi() {
        return nixi;
    }

    public void setNixi(int nixi) {
        this.nixi = nixi;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    
}