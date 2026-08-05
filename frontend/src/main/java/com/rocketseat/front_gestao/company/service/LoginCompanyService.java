package com.rocketseat.front_gestao.company.service;

import com.rocketseat.front_gestao.candidate.dto.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginCompanyService {

    @Value("${host.api.gestao.vagas}")
    private String hostApiGestaoVagas;

    @Autowired
    private CreateCompanyService createCompanyService;

    public Token execute(String username, String password){
    RestTemplate rt = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String,String> data = new HashMap<>();
        data.put("username",username);
        data.put("password",password);

    HttpEntity<Map<String,String>> request = new HttpEntity<>(data, headers);

    String url = hostApiGestaoVagas.concat("/company/auth");

    var result = rt.postForObject(url, request, Token.class);
       return result;
}
}

