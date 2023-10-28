package com.example;

public class Operator {
    private final String id;
    private final String name;
    private final String phoneNo;
    private final BusJourneyManager busJourneyManager;

    public Operator(String id, String name, String phoneNo, BusJourneyManager busJourneyManager) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.busJourneyManager = busJourneyManager;
    }

    public void addBusJourney(BusJourney busJourney) {
        busJourneyManager.addBusJourneyForOperator(this, busJourney);
    }

    public void editBusJourney(BusJourney updatedBusJourney) {
        busJourneyManager.editBusJourneyForOperator(this, updatedBusJourney);

    }
    public void removeBusJourney(BusJourney busJourneyToBeRemoved){
        busJourneyManager.removeBusJourneyForOperator(this, busJourneyToBeRemoved);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
