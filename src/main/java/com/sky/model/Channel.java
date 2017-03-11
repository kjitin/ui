package com.sky.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Jitin on 06/03/2017.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
                     include = JsonTypeInfo.As.PROPERTY,
                 property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = SportsChannel.class),
  @JsonSubTypes.Type(value = NewsChannel.class)
})
public abstract class Channel {

    protected String channelName;
    protected Location location;

    public abstract String getChannelName();

    public abstract Location getLocation();

    public boolean isDefaultChannel(){
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;

        Channel channel = (Channel) o;

        return channelName.equalsIgnoreCase(channel.channelName);
    }

    @Override
    public int hashCode() {
        return channelName.hashCode();
    }

}
