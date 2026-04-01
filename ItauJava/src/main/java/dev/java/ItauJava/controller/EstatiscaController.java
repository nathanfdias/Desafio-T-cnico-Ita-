package dev.java.ItauJava.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java.ItauJava.Properties.EstatisticaProperties;
import dev.java.ItauJava.Repository.TransacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/estatistica")
public class EstatiscaController {
    
    @Autowired
    private EstatisticaProperties estatisticaProperties;
    
    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("path")
    public ResponseEntity<?> estatistica() {
        
        final var horaInicial = OffsetDateTime.now()
            .minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok().build();
    }
    
}
