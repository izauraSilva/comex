package com.br.comex.controller;

import com.br.comex.model.Lancamento;
import com.br.comex.response.ResponseEstatistica;
import com.br.comex.response.ResponseModel;
import com.br.comex.service.LancamentoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Izaura Silva
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class LancamentoController {

    @Autowired
    LancamentoService lancamentoService;

    public void setLancamentoService(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @ApiOperation(
            value="Buscar estatisticas lançamento",
            response= ResponseModel.class,
            notes="Essa operação busca estatisticas.")
    @RequestMapping(value="/lancamentos-contabeis/_stats/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEstatistica buscarEstatisticasLancamento(@RequestParam(value="contaContabil", required=false) Long contaContabil){

        List<Lancamento> lancamentos = this.lancamentoService.findEstatisticasLancamento(contaContabil);

        return new ResponseEstatistica(lancamentos.size()
                ,lancamentos.stream().
                mapToDouble(p -> p.getValor()).
                average().
                getAsDouble()
                ,lancamentos.stream().
                mapToDouble(p -> p.getValor()).
                min().
                getAsDouble()
                ,lancamentos.stream().
                mapToDouble(p -> p.getValor()).
                max().
                getAsDouble());
    }

    @ApiOperation(
            value="Cadastrar novo lançamento",
            response= ResponseModel.class,
            notes="Essa operação salva um novo lançamento.")
    @RequestMapping(value="/lancamentos-contabeis", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> salvarLancamento(@RequestBody Lancamento lancamento){

        try {
            Lancamento saveLancamento = lancamentoService.saveLancamento(lancamento);
            return new ResponseEntity<ResponseModel>(new ResponseModel(lancamento.getId().longValue(),"Registro salvo com sucesso!"), HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<ResponseModel>(new ResponseModel(0L,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(
            value="Buscar lançamento por id",
            response= ResponseModel.class,
            notes="Essa operação busca lançamento por id.")
    @RequestMapping(value="/lancamentos-contabeis/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Optional<Lancamento> buscarLancamentoPorId(@PathVariable("id") Integer id){
        return this.lancamentoService.findById(id);
    }

    @ApiOperation(
            value="Listar todos os lançamentos",
            response= ResponseModel.class,
            notes="Essa operação lista todos os lançamentos.")
    @RequestMapping(value="/lancamentos-contabeis", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Lancamento> findAllLancamentos() {
        return this.lancamentoService.findAll();
    }

    @ApiOperation(
            value="Buscar lançamento por conta",
            response= ResponseModel.class,
            notes="Essa operação busca lançamento por conta.")
    @RequestMapping(value="/lancamentos-contabeis/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Lancamento> buscarLancamentoPorContaContabil(@RequestParam("contaContabil") Long contaContabil){
        return this.lancamentoService.findLancamentoByContaContabil(contaContabil);
    }

}
