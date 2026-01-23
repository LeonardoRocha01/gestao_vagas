package br.com.leonardo.gestao_vagas.company.UseCase;

import javax.naming.AuthenticationException;
import br.com.leonardo.gestao_vagas.company.dto.AuthCompanyDTO;
import br.com.leonardo.gestao_vagas.company.dto.AuthCompanyResponseDTO;
import br.com.leonardo.gestao_vagas.company.repository.CompanyRespository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCompanyUseCase {
    @Autowired
    private CompanyRespository companyRespository;

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRespository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
        () ->{
            throw new UsernameNotFoundException("Company not found");
        });

      var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(),company.getPassword());
      if(!passwordMatches){
          throw new AuthenticationException();
      }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

      var expiresIn = Instant.now().plus(Duration.ofHours(2));

      var token = JWT.create().withIssuer("Javagas")
              .withExpiresAt(expiresIn)
              .withSubject(company.getId().toString())
              .withClaim("roles", Arrays.asList("COMPANY"))
                .sign(algorithm);

        var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

        return authCompanyResponseDTO;
    }
}
