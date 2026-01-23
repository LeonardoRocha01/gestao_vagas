package br.com.leonardo.gestao_vagas.candidate.DTO;

import br.com.leonardo.gestao_vagas.company.dto.CompanyNotFoundExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompanyNotFoundExcepetion.class)
    public ResponseEntity<String> handleCompanyNotFound(CompanyNotFoundExcepetion ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}

