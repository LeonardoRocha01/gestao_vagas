package com.rocketseat.front_gestao.candidate.service;

import com.rocketseat.front_gestao.candidate.dto.CreateCandidateDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCandidateService {

    @Value("${host.api.gestao.vagas}")
    private String hostApiGestaoVagas;

    public void execute(CreateCandidateDTO createCandidateDTO) {

            RestTemplate rT = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CreateCandidateDTO> request = new HttpEntity<>(createCandidateDTO, headers);

            var url = hostApiGestaoVagas.concat("/candidate/");

            var result = rT.postForObject(url, request, String.class);

            System.out.println(result);

    }
}
