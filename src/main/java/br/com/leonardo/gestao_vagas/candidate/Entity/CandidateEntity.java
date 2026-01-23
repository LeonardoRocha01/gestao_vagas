package br.com.leonardo.gestao_vagas.candidate.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Leonardo Rocha")
    private String nome;
    @NotBlank()
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
    @Schema(example = "leo")
    private String username;
    @Schema(example = "rochavieira@gmail")
    private String email;

    @Email(message = "O campo (email) deve conter um e-mail válido")
    @Length(min = 5, max = 100)
    @Schema(example = "123456878", minLength =  5, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(example = "Desenvolvedor Java")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
