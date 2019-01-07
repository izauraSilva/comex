package com.br.comex.service.impl;

import com.br.comex.model.Conta;
import com.br.comex.model.Lancamento;
import com.br.comex.repository.ContaRepository;
import com.br.comex.repository.LancamentoRepository;
import com.br.comex.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

/**
 * @author Izaura Silva
 *
 */
@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    LancamentoRepository lancamentoRepository;

    @Autowired
    ContaRepository contaRepository;

    public void setLancamentoRepository(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public List<Lancamento> findEstatisticasLancamento(Long contaContabil) {
        return (contaContabil == null) ? this.findAll() : lancamentoRepository.findByContaContabil(contaContabil);
    }

   @Override
    public Lancamento saveLancamento(Lancamento lancamento) {

       Conta conta = contaRepository.findByContaContabil(lancamento.getContaContabil());

       if(isNull(conta)) {
           throw new RuntimeException("Conta contábil não encontrada!");
       }

       return  lancamentoRepository.save(lancamento);
    }

    @Override
    public Optional<Lancamento> findById(Integer idLancamento) {
        Optional<Lancamento>  lancamento = lancamentoRepository.findById(idLancamento);
        if(lancamento.isPresent()){
            return lancamento;
        } else{
            throw new RuntimeException("Lançamento não encontrada!");
        }
    }

    @Override
    public List<Lancamento> findLancamentoByContaContabil(Long contaContabil) {

        List<Lancamento> lancamentos = lancamentoRepository.findByContaContabil(contaContabil);

        if(isNull(lancamentos)) {
            throw new RuntimeException("Lançamentos não encontrada!");
        }

        return lancamentos;
    }

    @Override
    public List<Lancamento> findAll() {
        return this.lancamentoRepository.findAll();
    }
}
