package com.sky.controller;

import com.sky.model.BroadCaster;
import com.sky.model.Channel;
import com.sky.model.Location;
import com.sky.model.SportsChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jitin on 06/03/2017.
 */

@RestController
public class CatalogController {


    @RequestMapping(value = "/channel/{locationId}")
    @ResponseBody
    public List<Channel> getLocationSpecificChannels(@PathVariable("locationId") String locationId){

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
