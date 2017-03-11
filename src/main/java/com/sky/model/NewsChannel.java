package com.sky.model;

/**
 * Created by Jitin on 08/03/2017.
 */
public class NewsChannel extends Channel{


    public NewsChannel(){}

    public NewsChannel(String channelName){
        this.channelName = channelName;
        this.location = new Location("default");
    }

    @Override
    public String getChannelName() {
        return channelName;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "{channel:"+ getChannelName()+",location: "+location+" }";
    }
}
