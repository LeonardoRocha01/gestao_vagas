package br.com.leonardo.gestao_vagas.candidate.UseCase;

import br.com.leonardo.gestao_vagas.candidate.Entity.ApplyJobEntity;
import br.com.leonardo.gestao_vagas.candidate.Repository.ApplyJobRepository;
import br.com.leonardo.gestao_vagas.candidate.Repository.CandidateRepository;
import br.com.leonardo.gestao_vagas.candidate.exceptions.UserNotFoundException;
import br.com.leonardo.gestao_vagas.job.Exceptions.JobNotFoundException;
import br.com.leonardo.gestao_vagas.job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate).orElseThrow(()
                -> {
            throw new UserNotFoundException();
        });
        this.jobRepository.findById(idJob).orElseThrow(()
                -> {
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

       applyJob = applyJobRepository.save(applyJob);
       return applyJob;

    }
}
