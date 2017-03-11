package com.sky.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test",locations = "classpath:application.properties")
public class ChannelConfig {

    private Map<String,String> customer = new HashMap<>();


    public Map<String,String> getCustomer(){
        return customer;
    }




}
