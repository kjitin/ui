package com.sky.services;


import com.sky.model.Channel;
import com.sky.model.Location;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class WebLocationController {


    @Autowired
    protected WebLocationService webLocationService;

    protected Logger logger = Logger.getLogger(WebLocationController.class.getName());

    public WebLocationController(WebLocationService webLocationService){
        this.webLocationService =webLocationService;
    }


    @RequestMapping("/customer/{customerId}")
    public String getCustomerLocation(Model model, @PathVariable("customerId") String customerId){

        Location location = webLocationService.getLocationForCustomer(customerId);
        logger.warning("Location found "+location);
        model.addAttribute("location",location);
        return "location";

    }

    @RequestMapping("/channel/{locationId}")
    public String getChannelsForLocation(Model model,@PathVariable("locationId") String locationId){
        logger.warning("Channel lcaotion "+locationId);
        List<Channel> channelList = webLocationService.getChannelsForLocation(locationId);
        model.addAttribute("channelList",channelList);
        return "channels";
    }

}
