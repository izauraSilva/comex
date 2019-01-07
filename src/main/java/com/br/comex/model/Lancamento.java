package com.br.comex.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Izaura Silva
 *
 */
@Entity
@Table(name="LANCAMENTO_CONTABIL")
public class Lancamento implements Serializable {

    private Integer id;
    private Date data;
    private Double valor;
    @Column
    private Long contaContabil;
    //private Conta conta;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Column(name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    @Column(name = "valor", nullable = false)
    public Double getValor() {
        return valor;
    }

    @Column(name = "contaContabil", nullable = false)
    public Long getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(Long contaContabil) {
        this.contaContabil = contaContabil;
    }

    /*@ManyToOne(fetch = FetchType.EAGER)
    public Conta getConta() {
        return conta;
    }*/

    @PreUpdate
    public void preUpdate(){
        data = new Date();
    }

    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        data = atual;
    }

   /* public void setConta(Conta conta) {
        this.conta = conta;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                ", contaContabil=" + contaContabil +
                '}';
    }
}
