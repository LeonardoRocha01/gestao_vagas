package br.com.leonardo.gestao_vagas.candidate.UseCase;


import br.com.leonardo.gestao_vagas.candidate.Repository.CandidateRepository;
import br.com.leonardo.gestao_vagas.candidate.DTO.AuthCandidateRequestDTO;
import br.com.leonardo.gestao_vagas.candidate.DTO.AuthCandidateResponseDTO;
import br.com.leonardo.gestao_vagas.candidate.exceptions.UserFoundExeception;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO) throws AuthenticationException {
    var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.username())
            .orElseThrow(() ->{
                throw new UsernameNotFoundException("Username/password incorreto");
            });
    var passwordMatcher = this.passwordEncoder
            .matches(authCandidateRequestDTO.password(), candidate.getPassword());

    if (!passwordMatcher) {
        throw new UserFoundExeception();
    }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
    var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
    var token = JWT.create().withIssuer("javagas")
            .withSubject(candidate.getId().toString())
            .withClaim("roles", Arrays.asList("CANDIDATE"))
            .withExpiresAt(expiresIn)
            .sign(algorithm);

       var authCandidateResponse =  AuthCandidateResponseDTO.builder()
                .access_token(token)
               .expires_in(expiresIn.toEpochMilli())
                .build();
       return authCandidateResponse;
    }

}
