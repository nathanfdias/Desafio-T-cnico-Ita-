package dev.java.ItauJava.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import dev.java.ItauJava.DTO.TransacaoRequestDTO;

@Service
public class TransacaoService {
    
    public void validarTransacao(TransacaoRequestDTO transacaoRequest) {

        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("Transaçao Inválida");
        }
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro na Data da transação");
        }
        if (transacaoRequest.getValor() == null) {
            throw new NullPointerException("Valor vazio");
        }
        if (transacaoRequest.getDataHora() == null){
            throw new NullPointerException("Data vazia");
        }

    }
}
