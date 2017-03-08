package com.sky.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jitin on 06/03/2017.
 */
public class BroadCaster extends TvChannels {



    public void addCustomerChannels(Channel customerChannel){

        getCustomerChannels().add(customerChannel);

    }

    public List<Channel> getChannelsForLocation(final Location location){


        return getCustomerChannels().stream()
                .filter(x->x.getLocation().equals(location) || x.isDefaultChannel())
                .collect(Collectors.toList());
    }
}
