package com.sky.services;

import com.sky.controller.ControllerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Created by Jitin on 06/03/2017.
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ControllerConfig.class)
public class CatalogServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name","catalog-server");
        SpringApplication.run(CatalogServer.class,args);
    }
}
