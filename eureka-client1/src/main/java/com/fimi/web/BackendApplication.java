package com.fimi.web;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BackendApplication.class).web(true).run(args);
    }
}

