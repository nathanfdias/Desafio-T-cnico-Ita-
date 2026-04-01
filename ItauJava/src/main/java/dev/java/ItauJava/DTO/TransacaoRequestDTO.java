package dev.java.ItauJava.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequestDTO {
      private BigDecimal valor;
    private OffsetDateTime dataHora;
}
