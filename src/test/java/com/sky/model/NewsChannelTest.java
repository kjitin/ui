package com.sky.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NewsChannelTest {


    @Test
    public void checkNewsChannelsIgnoreCase(){
        NewsChannel newsChannel = new NewsChannel("SkyNews");
        NewsChannel newsChannelLowerCase = new NewsChannel("skyNews");
        assertThat(newsChannel.equals(newsChannelLowerCase), is(true));
    }

    @Test
    public void checkNewsChannelsDefaultProperty(){
        NewsChannel sportsChannel = new NewsChannel("SkyNews");
        assertThat(sportsChannel.isDefaultChannel(), is(true));
    }
}