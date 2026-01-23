package br.com.leonardo.gestao_vagas.job.UseCase;

import br.com.leonardo.gestao_vagas.job.Entity.JobEntity;
import br.com.leonardo.gestao_vagas.job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter){
    return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
