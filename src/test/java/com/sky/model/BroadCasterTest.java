package com.sky.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BroadCasterTest {

    private BroadCaster broadCaster;

    @Before
    public void setUp(){
        broadCaster = new BroadCaster();
        broadCaster.addCustomerChannels(new SportsChannel("ArsenalTv",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("ChelseaTv",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("LiverPoolTv",new Location("LiverPool")));

    }

    @Test
    public void addCustomerChannelsAddsDefaultChannels() {

        List<Channel> defaultChannels = broadCaster.getCustomerChannels()
                                                   .stream()
                                                   .filter(x -> x.isDefaultChannel())
                                                   .collect(Collectors.toList());

        assertThat(broadCaster.getCustomerChannels().size(),is(5));
        assertThat(defaultChannels.get(0).getChannelName().equals("Sky News"),is(true));

    }

    @Test
    public void getChannelsForLocationReturnsDefaultAndLocationChannels() {

        List<Channel> londonChannels = broadCaster.getChannelsForLocation(new Location("London"));
        List<Channel> sportChannels = londonChannels.stream()
                                                    .filter(x-> !x.isDefaultChannel())
                                                    .collect(Collectors.toList());
        assertThat(londonChannels.size(),is(4));
        assertThat(sportChannels.get(0).getChannelName().equals("ArsenalTv"),is(true));

    }

}