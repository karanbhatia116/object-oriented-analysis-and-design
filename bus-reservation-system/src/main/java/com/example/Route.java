package com.example;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final String id;
    private List<BusStop> busStops = new ArrayList<>(0);

    public Route(String id) {
        this.id = id;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public void addBusStop(BusStop busStop, int position){
        busStops.add(position, busStop);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", busStops=" + busStops +
                '}';
    }
}
