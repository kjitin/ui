package com.sky.controller;

import com.sky.ChannelConfig;
import com.sky.exceptions.LocationNotFoundException;
import com.sky.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {


    @Autowired
    private ChannelConfig channelConfig;

    @RequestMapping("/customer/{customerId}")
    @ResponseBody
    public Location getCustomerLocation(@PathVariable("customerId") String customerId){

       Location location = new Location(channelConfig.getCustomer().get(customerId));
       if (location == null){
           throw new LocationNotFoundException(customerId);
       }else {
           return location;
       }

    }
}
