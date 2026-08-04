package com.rocketseat.front_gestao.company.dto;

import lombok.Data;

@Data
public class CreateCompanyDTO {

    private String username;
    private String website;
    private String email;
    private String name;
    private String description;
    private String password;

}
