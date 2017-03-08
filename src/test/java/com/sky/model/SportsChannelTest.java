package com.sky.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class SportsChannelTest {



    @Test
    public void checkSportsChannelsIgnoreCase(){
        SportsChannel sportsChannel = new SportsChannel("ArsenalTV", new Location("London"));
        SportsChannel sportsChannelLowerCase = new SportsChannel("arsenalTv", new Location("london"));
        assertThat(sportsChannel.equals(sportsChannelLowerCase), is(true));
    }

    @Test
    public void checkSportsChannelsDefaultProperty(){
        SportsChannel sportsChannel = new SportsChannel("ArsenalTV", new Location("London"));
        assertThat(sportsChannel.isDefaultChannel(), is(false));
    }


}