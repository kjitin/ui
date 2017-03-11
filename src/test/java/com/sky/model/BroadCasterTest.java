package com.sky.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import static org.hamcrest.Matchers.is;


public class BroadCasterTest {

    private BroadCaster broadCaster;

    private JacksonTester<SportsChannel> jacksonSportsTester;

    private JacksonTester<NewsChannel> jacksonNewsTester;

    @Before
    public void setUp(){
        broadCaster = new BroadCaster();
        broadCaster.addCustomerChannels(new SportsChannel("ArsenalTv",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("ChelseaTv",new Location("London")));
        broadCaster.addCustomerChannels(new SportsChannel("LiverPoolTv",new Location("LiverPool")));
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this,objectMapper);


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

    @Test
    public void canDeserializeSportChannel() throws IOException {
        String content = "{\"type\":\"com.sky.model.SportsChannel\",\"channelName\":\"ArsenalTV\" ,\"location\":{\"locationId\":\"London\"}}";
        assertThat(this.jacksonSportsTester.parse(content)).isEqualTo(new SportsChannel("ArsenalTV",new Location("London")));


    }
    @Test
    public void canDeserializeNewsChannel() throws IOException {
        String content = "{\"type\":\"com.sky.model.NewsChannel\",\"channelName\":\"SkyNews\" ,\"location\":{\"locationId\":\"default\"}}";
        assertThat(this.jacksonNewsTester.parse(content)).isEqualTo(new NewsChannel("SkyNews"));


    }

}