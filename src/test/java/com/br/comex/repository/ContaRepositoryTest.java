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
public class ContaRepositoryTest {

    private static final Long CONTA = 1111001L;
    private static final Long CONTA2 = 1111002L;

    @Autowired
    private ContaRepository contaRepository;

    @Before
    public void setUp() throws Exception {
        Conta conta = new Conta();
        conta.setContaContabil(1111001L);
        conta.setDescricao("teste");
        this.contaRepository.save(conta);
    }

    @After
    public void tearDown() throws Exception {
        this.contaRepository.deleteAll();
    }

    @Test
    public void testBuscarConta(){
        Conta conta = this.contaRepository.findByContaContabil(1111001L);
        assertEquals(CONTA, conta.getContaContabil());
    }

    @Test
    public void testCriarConta(){

        Conta conta = contaRepository.save(obterDadosConta());

        Conta contaContabil = this.contaRepository.findByContaContabil(1111002L);
        assertEquals(CONTA2, contaContabil.getContaContabil());
    }

    private Conta obterDadosConta(){
        Conta conta = new Conta();
        conta.setContaContabil(1111002L);
        conta.setDescricao("teste");
        return conta;
    }

}
