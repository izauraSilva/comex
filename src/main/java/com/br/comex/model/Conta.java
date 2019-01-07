package com.br.comex.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Izaura Silva
 *
 */
@Entity
@Table(name="CONTA_CONTABIL")
public class Conta {

    private Long contaContabil;
    private String descricao;

    //private List<Lancamento> lancamentos;

    public Conta() {
    }

    public Conta(Long contaContabil, String descricao) {
        this.contaContabil = contaContabil;
        this.descricao = descricao;
    }

    @Id
    @Column(name = "numero", nullable = false)
    public Long getContaContabil() {
        return contaContabil;
    }

    /*@OneToMany(mappedBy = "conta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }*/

    @Column(name = "descricao", nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   /* public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }*/

    public void setContaContabil(Long contaContabil) {
        this.contaContabil = contaContabil;
    }

}

