package com.br.comex.repository;

import com.br.comex.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Izaura Silva
 *
 */
@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Integer> {

    @Transactional(readOnly = true)
    List<Lancamento> findAll();

    @Transactional(readOnly = true)
    List<Lancamento> findByContaContabil(Long contaContabil);
}
