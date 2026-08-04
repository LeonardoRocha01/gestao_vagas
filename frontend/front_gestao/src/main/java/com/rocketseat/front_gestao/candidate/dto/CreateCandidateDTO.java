package com.rocketseat.front_gestao.candidate.dto;

import lombok.Data;

@Data
public class CreateCandidateDTO {

    private String username;
    private String password;
    private String name;
    private String email;
    private String description;
}
