package com.br.comex.service;

import com.br.comex.model.Conta;
import com.br.comex.repository.ContaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Izaura Silva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ContaServiceTest {

    @MockBean
    private ContaRepository contaRepository;

    @Autowired
    private  ContaService contaService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.contaRepository.findByContaContabil(Mockito.anyLong())).willReturn(new Conta());
        BDDMockito.given(this.contaRepository.save((Mockito.any(Conta.class)))).willReturn(new Conta());
    }

    @Test
    public  void testCriarConta(){
        Conta conta = this.contaService.saveConta(new Conta());
        assertNotNull(conta);
    }

    @Test
    public  void testBuscarContaInexistente(){
        Conta conta = this.contaService.findByContaContabil(1111004L);
        assertNotNull(conta);
    }
}
