package br.com.leonardo.gestao_vagas.candidate.Repository;

import br.com.leonardo.gestao_vagas.candidate.Entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional <CandidateEntity> findByUsernameOrEmail(String username, String email);
    Optional <CandidateEntity> findByUsername(String username);
}
