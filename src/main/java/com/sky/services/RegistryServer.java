package com.sky.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Jitin on 06/03/2017.
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistryServer {


    public static void main(String[] args) {
        System.setProperty("spring.config.name","registration-server");
        SpringApplication.run(RegistryServer.class,args);
    }
}
