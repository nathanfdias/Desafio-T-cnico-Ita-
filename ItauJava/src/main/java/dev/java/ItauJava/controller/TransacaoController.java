package dev.java.ItauJava.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java.ItauJava.DTO.TransacaoRequestDTO;
import dev.java.ItauJava.Repository.TransacaoRepository;
import dev.java.ItauJava.service.TransacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody TransacaoRequestDTO transacao) {
        
        try {
            transacaoService.validarTransacao(transacao);
            transacaoRepository.salvarDados(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();          
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletar(){
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
