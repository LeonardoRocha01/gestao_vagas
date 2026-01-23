package br.com.leonardo.gestao_vagas.testes;

import br.com.leonardo.gestao_vagas.candidate.Entity.ApplyJobEntity;
import br.com.leonardo.gestao_vagas.candidate.Entity.CandidateEntity;
import br.com.leonardo.gestao_vagas.candidate.Repository.ApplyJobRepository;
import br.com.leonardo.gestao_vagas.candidate.Repository.CandidateRepository;
import br.com.leonardo.gestao_vagas.candidate.UseCase.ApplyJobCandidateUseCase;
import br.com.leonardo.gestao_vagas.candidate.exceptions.UserNotFoundException;
import br.com.leonardo.gestao_vagas.job.Entity.JobEntity;
import br.com.leonardo.gestao_vagas.job.Exceptions.JobNotFoundException;
import br.com.leonardo.gestao_vagas.job.Repository.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository  candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply jobo with candidate not found")
    public void shouldNotBeAbleToApplyJobWithCandidateNotFound(){
        try {
            applyJobCandidateUseCase.execute(null,null);
        }catch (Exception e){
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }
    @Test
    public void ShouldNotBeAbleToApplyJobWithJobNotFound(){
            var idCandidate = UUID.randomUUID();
            var candidate = new CandidateEntity();
        candidate.setId(idCandidate);
    when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate,null);
        }catch (Exception e){
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    private void shouldBeAbleToCreateANewApplyJob(){
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder().candidateId(idCandidate)
                .jobId(idJob).id(UUID.randomUUID()).build();

    var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate,idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
