package com.example;

import java.time.Instant;
import java.util.stream.IntStream;

public class BusJourney implements Observer{
    private final String id;
    private final Bus bus;
    private final Instant startTimestamp;
    private final Instant endTimestamp;
    private final Operator journeyProvider;

    private Route route;
    private BusStop nextBusStop;


    public BusJourney(String id, Bus bus, Instant startTimestamp, Instant endTimestamp, Operator journeyProvider) {
        this.id = id;
        this.bus = bus;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.journeyProvider = journeyProvider;
    }

    public Bus getBus() {
        return bus;
    }

    public BusStop getNextBusStop() {
        return nextBusStop;
    }

    public String getId() {
        return id;
    }

    @Override
    public void updateOnNotification() {
        Integer index = IntStream.range(0, route.getBusStops().size())
                .filter(busStopInd -> route.getBusStops().get(busStopInd).equals(nextBusStop))
                .findFirst()
                .getAsInt();
        if(index != route.getBusStops().size() - 1 && bus.getBusStatus() == BusStatus.MOVING){
            this.nextBusStop = route.getBusStops().get(index + 1);
        }
    }

    public void updateBusJourneyRoute(Route route){
        this.route = route;
        this.nextBusStop = route.getBusStops().get(0);
    }

    @Override
    public String toString() {
        return "BusJourney{" +
                "id='" + id + '\'' +
                ", bus=" + bus +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", route=" + route +
                ", nextBusStop=" + nextBusStop +
                '}';
    }
}

