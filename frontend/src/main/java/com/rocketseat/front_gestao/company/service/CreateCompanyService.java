package com.rocketseat.front_gestao.company.service;

import com.rocketseat.front_gestao.candidate.dto.Token;
import com.rocketseat.front_gestao.company.dto.CreateCompanyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreateCompanyService {

    @Value("${host.api.gestao.vagas}")
    private String hostApiGestaoVagas;

    public String execute(CreateCompanyDTO createCompanyDTO) {

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateCompanyDTO> request = new HttpEntity<>(createCompanyDTO, headers);

        var url = hostApiGestaoVagas.concat("/company");

        return rt.postForObject(url, request, String.class);

    }
}