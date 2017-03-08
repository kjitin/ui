package com.sky.services;


import com.sky.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebLocationService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;


    public WebLocationService(String serviceUrl){
        this.serviceUrl =serviceUrl;
    }

    public Location getLocationForCustomer(String customerNo){
        return restTemplate.getForObject(serviceUrl+"/customer/{customerId}",Location.class,customerNo);
    }

}
