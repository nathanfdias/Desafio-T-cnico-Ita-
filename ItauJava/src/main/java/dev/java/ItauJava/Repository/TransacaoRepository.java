package dev.java.ItauJava.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.java.ItauJava.DTO.EstatiscaDTO;
import dev.java.ItauJava.DTO.TransacaoRequestDTO;

@Repository
public class TransacaoRepository {

    List<TransacaoRequestDTO> listaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequestDTO transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    public void limparDados(TransacaoRequestDTO transacaoRequest) {

    }
    
    public void deletarDados() {
        listaDeTransacoes.clear();
    }

    public EstatiscaDTO estatistica(OffsetDateTime horaInicial){
        
        if(listaDeTransacoes.isEmpty()){
            return new EstatiscaDTO(0, 0.0, 0, 0, 0);
        }

        final var summary = listaDeTransacoes.stream()
            .filter(t -> 
                t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
            ).mapToDouble(t -> 
                t.getValor().doubleValue())
                .summaryStatistics();

                return new EstatiscaDTO(summary.getCount(),
                 summary.getAverage(),
                 summary.getMax(),
                 summary.getMin(),
                 summary.getSum());
    }
} 