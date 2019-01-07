package com.br.comex.endpoint;

import com.br.comex.model.Conta;
import com.br.comex.repository.ContaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContaEndpointTest {

    //URL base para onde as requests serão feitas
    final String BASE_PATH = "http://localhost:8080/contaContabil";

    //Injetamos o repositório para acesso ao Banco de dados
    @Autowired
    private ContaRepository contaRepository;

    //Definimos o restTemplate
    private RestTemplate restTemplate;

    //Definimos o JacksonMapper responsável por converter
    //JSON para Objeto e vice versa
    private ObjectMapper MAPPER = new ObjectMapper();

    //Definimos o que será feito antes da execução do teste
    @Before
    public void setUp() throws Exception {

        //Deletamos todos os registros do banco
        contaRepository.deleteAll();

        //Inserimos alguma pessoas no banco
        contaRepository.save(new Conta(100001L, "teste 1"));
        contaRepository.save(new Conta(100012L, "teste 2"));
        contaRepository.save(new Conta(100012L, "teste 3"));

        //Inicializamos o objeto restTemplate
        restTemplate = new RestTemplate();
    }


    @Test
    @Ignore
    public void testCreatePerson() throws JsonProcessingException {

        //Criamos uma nova pessoa
        Conta conta = new Conta(100004L, "teste 4");
        contaRepository.save(conta);

        //Fazemos um HTTP request do tipo POST passando a pessoa como parâmetro
        Conta response = restTemplate.postForObject(BASE_PATH, conta, Conta.class);

        //Verificamos se o resultado da requisição é igual ao esperado
        //Se sim significa que tudo correu bem
        Assert.assertEquals("teste 4", response.getDescricao());
    }
}
