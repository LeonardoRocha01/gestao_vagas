package br.com.leonardo.gestao_vagas.candidate.UseCase;

import br.com.leonardo.gestao_vagas.candidate.Entity.CandidateEntity;
import br.com.leonardo.gestao_vagas.candidate.Repository.CandidateRepository;
import br.com.leonardo.gestao_vagas.candidate.exceptions.UserFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCanditeUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) ->{
            throw new UserFoundExeception();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);

    }
}
