package com.miage.altea.tp.pokemon_battle_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConf {


    @Value("${trainer.service.username}")
    private String username;

    @Value("${trainer.service.password}")
    private String password;

    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate template= new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new BasicAuthenticationInterceptor(username, password));
        template.setInterceptors(interceptors);
        return template;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
