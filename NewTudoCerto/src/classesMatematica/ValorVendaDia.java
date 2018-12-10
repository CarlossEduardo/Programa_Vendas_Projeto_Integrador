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
public class ValorVendaDia {
    String classes;
    Double xiClasses;
    int niClasses;
    Double xiniClasses;
    Double PorcentagemClasses;
    Double ContaClasses;

    public ValorVendaDia() {
    }

    public ValorVendaDia(String classes, Double xiClasses, int niClasses, Double xiniClasses, Double PorcentagemClasses, Double ContaClasses) {
        this.classes = classes;
        this.xiClasses = xiClasses;
        this.niClasses = niClasses;
        this.xiniClasses = xiniClasses;
        this.PorcentagemClasses = PorcentagemClasses;
        this.ContaClasses = ContaClasses;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Double getXiClasses() {
        return xiClasses;
    }

    public void setXiClasses(Double xiClasses) {
        this.xiClasses = xiClasses;
    }

    public int getNiClasses() {
        return niClasses;
    }

    public void setNiClasses(int niClasses) {
        this.niClasses = niClasses;
    }

    public Double getXiniClasses() {
        return xiniClasses;
    }

    public void setXiniClasses(Double xiniClasses) {
        this.xiniClasses = xiniClasses;
    }

    public Double getPorcentagemClasses() {
        return PorcentagemClasses;
    }

    public void setPorcentagemClasses(Double PorcentagemClasses) {
        this.PorcentagemClasses = PorcentagemClasses;
    }

    public Double getContaClasses() {
        return ContaClasses;
    }

    public void setContaClasses(Double ContaClasses) {
        this.ContaClasses = ContaClasses;
    }
    
    
}
