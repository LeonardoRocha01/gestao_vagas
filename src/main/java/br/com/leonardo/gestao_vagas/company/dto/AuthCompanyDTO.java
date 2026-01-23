package br.com.leonardo.gestao_vagas.company.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthCompanyDTO {
    private  String password;
    private  String username;
}
