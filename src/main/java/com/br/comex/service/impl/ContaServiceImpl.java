package com.br.comex.service.impl;

import com.br.comex.model.Conta;
import com.br.comex.repository.ContaRepository;
import com.br.comex.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

/**
 * @author Izaura Silva
 *
 */
@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    public void setContaRepository(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Conta findByContaContabil(Long contaContabil) {
        Conta conta = contaRepository.findByContaContabil(contaContabil);
        if(isNull(conta)) {
            throw new RuntimeException("Conta contábil não encontrada!");
        }
        return conta;
    }


}
