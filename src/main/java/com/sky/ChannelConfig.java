package com.sky;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@ConfigurationProperties
public class ChannelConfig {

    private Map<String,String> customer = new HashMap<>();


    public Map<String,String> getCustomer(){
        return customer;
    }




}
