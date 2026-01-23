package br.com.leonardo.gestao_vagas.candidate.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMensageDTO {
    private String message;
    private String field;
}
