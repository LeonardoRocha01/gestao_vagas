package br.com.leonardo.gestao_vagas.candidate.Repository;

import br.com.leonardo.gestao_vagas.candidate.Entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
