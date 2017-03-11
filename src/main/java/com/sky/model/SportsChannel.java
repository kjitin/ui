package com.sky.model;

/**
 * Created by Jitin on 08/03/2017.
 */
public class SportsChannel extends Channel {


    public SportsChannel(){}
    public SportsChannel(String channelName, Location location){
        this.channelName = channelName;
        this.location = location;
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
    public boolean isDefaultChannel(){
        return false;
    }

    @Override
    public String toString() {
        return "{channel:"+ getChannelName()+",location: "+location+" }";
    }
}
