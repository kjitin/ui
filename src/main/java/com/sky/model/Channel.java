package com.sky.model;

/**
 * Created by Jitin on 06/03/2017.
 */
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

    @Override
    public String toString() {
        return "Channel{" +
                "channelName='" + channelName + '\'' +
                '}';
    }
}
