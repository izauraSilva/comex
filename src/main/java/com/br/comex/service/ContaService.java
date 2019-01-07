package com.br.comex.service;

import com.br.comex.model.Conta;

/**
 * @author Izaura Silva
 *
 */
public interface ContaService {

    /**
     * persisti conta
     *
     * @param conta
     * @return
     */
    Conta saveConta(Conta conta);

    /**
     * pesquisa conta
     *
     * @param contaContabil
     * @return Conta
     */
    Conta findByContaContabil(Long contaContabil);
}
