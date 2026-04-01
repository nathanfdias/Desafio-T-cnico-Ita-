package dev.java.ItauJava.Repository;

import java.util.ArrayList;
import java.util.List;

import dev.java.ItauJava.DTO.TransacaoRequestDTO;

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
} 