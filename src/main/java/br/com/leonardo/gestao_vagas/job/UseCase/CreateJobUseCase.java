package br.com.leonardo.gestao_vagas.job.UseCase;

import br.com.leonardo.gestao_vagas.company.dto.CompanyNotFoundExcepetion;
import br.com.leonardo.gestao_vagas.company.repository.CompanyRespository;
import br.com.leonardo.gestao_vagas.job.Entity.JobEntity;
import br.com.leonardo.gestao_vagas.job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRespository companyRespository;

    public JobEntity execute(JobEntity jobEntity){
        companyRespository.findById(jobEntity.getCompanyId()).orElseThrow(()
                -> {
            throw new CompanyNotFoundExcepetion();
        });
        return this.jobRepository.save(jobEntity);
    }
}
