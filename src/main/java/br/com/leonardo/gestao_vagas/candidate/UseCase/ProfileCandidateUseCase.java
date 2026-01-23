package br.com.leonardo.gestao_vagas.candidate.UseCase;


import br.com.leonardo.gestao_vagas.candidate.Repository.CandidateRepository;
import br.com.leonardo.gestao_vagas.candidate.DTO.ProfileCandidateResponseDTO;
import br.com.leonardo.gestao_vagas.candidate.exceptions.UserFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute (UUID idCandidate) {
  var candidate = candidateRepository.findById(idCandidate)
            .orElseThrow(() -> {
                throw new UserFoundExeception();
            });

  var candidateDTO = ProfileCandidateResponseDTO.builder()
          .description(candidate.getDescription())
          .username(candidate.getUsername())
          .email(candidate.getEmail())
          .nome(candidate.getNome())
          .id(candidate.getId())
          .build();

    return candidateDTO;

    }
}
