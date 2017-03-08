package com.sky.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {

    public static final String LOCATION_SERVICE ="http://LOCATION-SERVICE";
    public static final String CATALOG_SERVICE ="http://CATALOG-SERVICE";

    public static void main(String[] args) {
        System.setProperty("spring.config.name","web-server");
        SpringApplication.run(WebServer.class,args);
    }


    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebLocationService webLocationService(){
        return new WebLocationService(LOCATION_SERVICE);
    }

    @Bean
    public WebLocationController webLocationController(){
        return new WebLocationController(webLocationService());
    }
}
