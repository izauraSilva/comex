package com.br.comex.repository;

import com.br.comex.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Izaura Silva
 *
 */
@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

    @Transactional(readOnly = true)
    Conta findByContaContabil(Long contaContabil);

}
