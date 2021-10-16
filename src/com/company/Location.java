package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private int locationID;
    private String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        exits=new HashMap<>();
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Integer> getExits() {

        return new HashMap<>(exits);
    }

    public void addExit(String direction, int location){
        this.exits.put(direction,location);
    }
}
