package com.sky.services;


import com.sky.model.Channel;
import com.sky.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class WebLocationService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String locationServiceUrl;
    protected String catalogServiceUrl;

    protected Logger logger = Logger.getLogger(WebLocationService.class.getName());


    public WebLocationService(String locationServiceUrl,String catalogServiceUrl){
        this.locationServiceUrl =locationServiceUrl;
        this.catalogServiceUrl =catalogServiceUrl;
    }

    public Location getLocationForCustomer(String customerNo){
        Location location=  restTemplate.getForObject(locationServiceUrl+"/customer/{customerId}",Location.class,customerNo);
        logger.warning("Location found "+location);
        return location;
    }

    public List<Channel> getChannelsForLocation(String location){
        Channel[] channelList = restTemplate.getForObject(catalogServiceUrl+"/channel/{locationid}",Channel[].class,location);
        return Arrays.asList(channelList);
    }

}
