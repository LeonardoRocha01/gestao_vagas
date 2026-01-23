package br.com.leonardo.gestao_vagas.company.dto;

public class CompanyNotFoundExcepetion extends RuntimeException {
    public CompanyNotFoundExcepetion() {
        super("Company not found");
    }
}
