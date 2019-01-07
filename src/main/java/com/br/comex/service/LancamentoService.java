package com.br.comex.service;

import com.br.comex.model.Lancamento;

import java.util.List;
import java.util.Optional;

/**
 * @author Izaura Silva
 *
 */
public interface LancamentoService {

    /**
     * persisti lançamento
     *
     * @param lancamento
     * @return
     */
    Lancamento saveLancamento(Lancamento lancamento);

    /**
     * busca lancamento por id
     *
     * @param idLancamento
     * @return Optional<Lancamento>
     */
    Optional<Lancamento> findById(Integer idLancamento);

    /**
     * busca lançamento por conta contabil
     *
     * @param contaContabil
     * @return List<Lancamento>
     */
    List<Lancamento> findLancamentoByContaContabil(Long contaContabil);

    /**
     * lista todos os lançamentos
     *
     * @return List<Lancamento>
     */
    List<Lancamento> findAll();

    /**
     * busca estatistica lançamento
     *
     * @param contaContabil
     * @return List<Lancamento>
     */
    List<Lancamento> findEstatisticasLancamento(Long contaContabil);

}
