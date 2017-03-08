package com.sky.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jitin on 06/03/2017.
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
public class CatalogServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name","catalog-server");
        SpringApplication.run(CatalogServer.class,args);
    }
}
