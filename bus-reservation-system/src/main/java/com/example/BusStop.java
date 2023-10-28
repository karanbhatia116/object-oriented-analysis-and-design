package com.example;

import java.time.Duration;

public class BusStop {
    private final String name;
    private final String city;
    private final String district;
    private final String state;
    private Duration stopDuration;
    private Boolean hasRefreshments;

    public BusStop(String name, String city, String district, String state) {
        this.name = name;
        this.city = city;
        this.district = district;
        this.state = state;
    }

    public void changeStopDuration(Duration duration){
        this.stopDuration = duration;
    }

    public void updateIfHasRefreshments(Boolean hasRefreshments){
        this.hasRefreshments = hasRefreshments;
    }

    public Duration getStopDuration(){
        return this.stopDuration;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", stopDuration=" + stopDuration +
                ", hasRefreshments=" + hasRefreshments +
                '}';
    }
}
