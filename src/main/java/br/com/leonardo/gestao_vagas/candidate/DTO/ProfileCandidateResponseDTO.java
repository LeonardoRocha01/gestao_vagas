package br.com.leonardo.gestao_vagas.candidate.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedor Java")
    private String description;

    @Schema(example = "leo")
    private String username;

    @Schema(example = "rochavieira08@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Leonardo Rocha Vieira")
    private String nome;
}
