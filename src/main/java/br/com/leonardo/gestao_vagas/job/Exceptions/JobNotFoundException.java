package br.com.leonardo.gestao_vagas.job.Exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException() {
        super("Job not found" );
    }
}
