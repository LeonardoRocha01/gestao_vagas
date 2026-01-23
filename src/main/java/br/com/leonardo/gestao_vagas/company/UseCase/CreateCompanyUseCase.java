package br.com.leonardo.gestao_vagas.company.UseCase;

import br.com.leonardo.gestao_vagas.candidate.exceptions.UserFoundExeception;
import br.com.leonardo.gestao_vagas.company.Entity.CompanyEntity;
import br.com.leonardo.gestao_vagas.company.repository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRespository companyRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRespository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
            throw new UserFoundExeception();
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);
        return this.companyRespository.save(companyEntity);
    }
}
