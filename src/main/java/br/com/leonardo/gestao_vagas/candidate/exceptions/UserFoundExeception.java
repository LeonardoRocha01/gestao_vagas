package br.com.leonardo.gestao_vagas.candidate.exceptions;

public class UserFoundExeception extends RuntimeException {
    public UserFoundExeception() {
        super("Usuario já existente");
    }
}
