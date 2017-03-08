package com.sky.model;

/**
 * Created by Jitin on 06/03/2017.
 */
public class Location {


    private String locationId;



    public Location(String locationId){
        this.locationId = locationId;
    }


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        return locationId.equalsIgnoreCase(location.locationId);
    }

    @Override
    public int hashCode() {
        return locationId.hashCode();
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                '}';
    }
}
