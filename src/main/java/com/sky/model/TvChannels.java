package com.sky.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jitin on 06/03/2017.
 */
public abstract class TvChannels {

    private List<Channel> customerChannels = new ArrayList<>();

    public TvChannels(){
        customerChannels.add(new NewsChannel("Sky News"));
        customerChannels.add(new NewsChannel("Sky Sports News"));
    }

    public List<Channel> getCustomerChannels(){
        return this.customerChannels;
    }



}
