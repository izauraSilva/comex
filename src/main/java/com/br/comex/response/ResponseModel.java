package com.br.comex.response;

/**
 * @author Izaura Silva
 *
 */
public class ResponseModel {

    private Long id;
    private String mensagem;

    public ResponseModel() {
    }

    public ResponseModel(Long id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
