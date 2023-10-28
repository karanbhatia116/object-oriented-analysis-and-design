package com.example;

public interface BusJourneyManager {
    public void addBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeAdded);
    public void removeBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeRemoved);
    public void editBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeUpdated);
}
