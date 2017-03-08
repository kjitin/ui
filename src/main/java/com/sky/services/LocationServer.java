package com.sky.services;

import com.sky.ChannelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;


@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ChannelConfig.class)
public class LocationServer {


    public static void main(String[] args) {
        System.setProperty("spring.config.name","location-server");
        SpringApplication.run(LocationServer.class,args);
    }
}
