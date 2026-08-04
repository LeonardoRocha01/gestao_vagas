package com.rocketseat.front_gestao.candidate.service;

import com.rocketseat.front_gestao.candidate.dto.ProfileUserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Map;

@Service
public class ProfileCandidateService {

    @Value("${host.api.gestao.vagas}")
    private String hostApiGestaoVagas;

    public ProfileUserDTO execute(String token){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

        var url = hostApiGestaoVagas.concat("/candidate/");

        try {
            var result = rt.exchange(url, HttpMethod.GET, request, ProfileUserDTO.class);

            return result.getBody();
        }catch(HttpClientErrorException.Unauthorized ex){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
