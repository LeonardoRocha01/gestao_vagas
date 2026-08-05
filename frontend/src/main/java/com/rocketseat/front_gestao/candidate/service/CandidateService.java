package com.rocketseat.front_gestao.candidate.service;

import com.rocketseat.front_gestao.candidate.dto.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CandidateService {

    @Value("${host.api.gestao.vagas}")
private String hostApiGestaoVagas;

    public Token login(String username, String password){


        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        var url = hostApiGestaoVagas.concat("/candidate/auth");

       var result = rt.postForObject(url, request, Token.class);
       return result;
    }

}
