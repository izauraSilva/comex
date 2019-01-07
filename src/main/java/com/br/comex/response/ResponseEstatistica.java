package com.br.comex.response;

/**
 * @author Izaura Silva
 *
 */
public class ResponseEstatistica {

    private int qtd;
    private Double media;
    private Double minimo;
    private Double maximo;

    public ResponseEstatistica(int qtd, Double media, Double minimo, Double maximo) {
        this.qtd = qtd;
        this.media = media;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getMinimo() {
        return minimo;
    }

    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    public Double getMaximo() {
        return maximo;
    }

    public void setMaximo(Double maximo) {
        this.maximo = maximo;
    }

}
