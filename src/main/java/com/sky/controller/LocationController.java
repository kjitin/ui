package com.sky.controller;

import com.sky.exceptions.LocationNotFoundException;
import com.sky.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class LocationController {


    @Autowired
    private ChannelConfig channelConfig;
    protected Logger logger = Logger.getLogger(LocationController.class.getName());

    @RequestMapping("/customer/{customerId}")
    public Location getCustomerLocation(@PathVariable("customerId") String customerId){
        logger.info("inside LocationController "+customerId);
       Location location = new Location(channelConfig.getCustomer().get(customerId));
       logger.info("Location returned from "+location);
       if (location == null){
           throw new LocationNotFoundException(customerId);
       }else {
           return location;
       }

    }
}
