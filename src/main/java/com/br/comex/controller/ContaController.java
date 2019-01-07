package com.br.comex.controller;

import com.br.comex.model.Conta;
import com.br.comex.response.ResponseModel;
import com.br.comex.service.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Izaura Silva
 *
 */
@RestController
@CrossOrigin (origins = "*")
public class ContaController {

    @Autowired
    ContaService contaService;

    public void setContaService(ContaService contaService) {
        this.contaService = contaService;
    }

    @ApiOperation(
            value="Cadastrar nova conta",
            response= ResponseModel.class,
            notes="Essa operação salva um novo registro com as informações da conta.")
    @RequestMapping(value="/contaContabil", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<ResponseModel> saveConta(@RequestBody Conta conta){

        try {
            Conta c = contaService.saveConta(conta);
            return new ResponseEntity<ResponseModel>(new ResponseModel(c.getContaContabil(),"Registro salvo com sucesso!"), HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<ResponseModel>(new ResponseModel(0L,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
