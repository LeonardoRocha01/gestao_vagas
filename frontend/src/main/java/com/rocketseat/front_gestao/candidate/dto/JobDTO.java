package com.rocketseat.front_gestao.candidate.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private UUID id;
    private String benefits;
    private String description;
    private UUID companyId;
    private Date createdAT;
}
