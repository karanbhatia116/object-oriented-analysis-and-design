package com.example;

import com.example.exceptions.BusMovementException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bus implements Subject{
    private final String id;
    private final String licensePlateNo;
    private final List<Seat> seats;
    private final Boolean isAcBus;
    private final BusType busType;
    private List<Observer> busObservers = new ArrayList<>(0);
    private BusStatus busStatus = BusStatus.AT_HALT;

    public Bus(String id, String licensePlateNo, List<Seat> seats, Boolean isAcBus, BusType busType) {
        this.id = id;
        this.licensePlateNo = licensePlateNo;
        this.seats = seats;
        this.isAcBus = isAcBus;
        this.busType = busType;
    }

    public void move() throws BusMovementException {
        if(this.busStatus == BusStatus.MOVING)
            throw new BusMovementException("Bus " + this.id + " is already moving. Cannot perform operation!");
        this.busStatus = BusStatus.MOVING;
        this.notifyAllSubscribers();
    }
    public void stop() throws BusMovementException{
        if(this.busStatus == BusStatus.AT_HALT)
            throw new BusMovementException("Bus " + this.id + " is already at halt. Cannot perform operation!");
        this.busStatus = BusStatus.AT_HALT;
        this.notifyAllSubscribers();
    }

    public BusStatus getBusStatus() {
        return busStatus;
    }

    public String getId() {
        return id;
    }

    @Override
    public void subscribe(Observer observer) {
        busObservers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        busObservers.remove(observer);
    }

    @Override
    public void notifyAllSubscribers() {
        for(Observer observer: busObservers){
            observer.updateOnNotification();
        }
    }

    public List<Seat> getAvailableSeats(){
        return seats.stream().filter(it -> !it.getIsTaken())
                .collect(Collectors.toList());
    }
}
