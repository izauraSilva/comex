package com.br.comex.repository;

import com.br.comex.model.Conta;
import com.br.comex.model.Lancamento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Izaura Silva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

    private static final Long CONTA = 1111001L;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Before
    public void setUp() throws Exception {
        Conta conta = new Conta();
        conta.setContaContabil(1111001L);
        conta.setDescricao("teste");
        this.contaRepository.save(conta);

        Lancamento lancamento = new Lancamento();
        lancamento.setContaContabil(1111001L);
        lancamento.setData(new Date());
        lancamento.setValor(10.0);
        this.lancamentoRepository.save(lancamento);

        Conta conta2 = new Conta();
        conta2.setContaContabil(1111002L);
        conta2.setDescricao("teste");
        this.contaRepository.save(conta2);

    }

    @After
    public void tearDown() throws Exception {
        this.lancamentoRepository.deleteAll();
    }

    @Test
    public void testCriarLancamento(){

        Lancamento lancamento = lancamentoRepository.save(obterDadosLancamento());

        List<Lancamento> list = this.lancamentoRepository.findByContaContabil(1111001L);
        assertEquals(1, list.size());
    }

    @Test
    public void testBuscarLancamentosPorConta(){
        List<Lancamento> list = this.lancamentoRepository.findByContaContabil(1111001L);
        assertEquals(1, list.size());
    }

    private Lancamento obterDadosLancamento(){
        Lancamento lancamento = new Lancamento();
        lancamento.setContaContabil(1111002L);
        lancamento.setData(new Date());
        lancamento.setValor(10.0);
        return lancamento;
    }
}
