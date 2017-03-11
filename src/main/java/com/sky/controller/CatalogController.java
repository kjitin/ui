package com.sky.controller;

import com.sky.model.BroadCaster;
import com.sky.model.Channel;
import com.sky.model.Location;
import com.sky.model.SportsChannel;
import com.sky.services.WebLocationController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Jitin on 06/03/2017.
 */

@RestController
public class CatalogController {

    protected Logger logger = Logger.getLogger(CatalogController.class.getName());

    @RequestMapping("/channel/{locationId}")
    public List<Channel> getLocationSpecificChannels(@PathVariable("locationId") String locationId){

        logger.warning("Channel location "+locationId);
        BroadCaster broadCaster = loadChannels();
        return broadCaster.getChannelsForLocation(new Location(locationId));
    }

    private BroadCaster loadChannels() {

        BroadCaster broadCaster = new BroadCaster();
        broadCaster.addCustomerChannels(new SportsChannel("ArsenalTV",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("ChelseaTV",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("LiverPoolTV",new Location("LiverPool")));
        return broadCaster;
    }

}
