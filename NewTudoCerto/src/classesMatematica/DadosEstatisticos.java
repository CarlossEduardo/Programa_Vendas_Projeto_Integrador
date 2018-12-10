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
public class DadosEstatisticos {
    String media;
    String mediana;
    String Moda;
    String variancia;
    String desvioPadrao;

    public DadosEstatisticos(String media, String mediana, String Moda, String variancia, String desvioPadrao) {
        this.media = media;
        this.mediana = mediana;
        this.Moda = Moda;
        this.variancia = variancia;
        this.desvioPadrao = desvioPadrao;
    }

    public DadosEstatisticos() {
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMediana() {
        return mediana;
    }

    public void setMediana(String mediana) {
        this.mediana = mediana;
    }

    public String getModa() {
        return Moda;
    }

    public void setModa(String Moda) {
        this.Moda = Moda;
    }

    public String getVariancia() {
        return variancia;
    }

    public void setVariancia(String variancia) {
        this.variancia = variancia;
    }

    public String getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(String desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }
    
    
}
