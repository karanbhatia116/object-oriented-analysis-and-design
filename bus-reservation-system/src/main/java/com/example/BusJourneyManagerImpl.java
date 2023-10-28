package com.example;

import java.util.HashMap;
import java.util.Map;

public class BusJourneyManagerImpl implements BusJourneyManager{
    private Map<String, Operator> busJourneyOperatorMapping = new HashMap<>(0);

    @Override
    public void addBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeAdded) {
        busJourneyOperatorMapping.put(busJourneyToBeAdded.getId(), operator);
    }

    @Override
    public void removeBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeRemoved) {
        busJourneyOperatorMapping.remove(busJourneyToBeRemoved.getId(), operator);
    }

    @Override
    public void editBusJourneyForOperator(Operator operator, BusJourney busJourneyToBeUpdated) {
        busJourneyOperatorMapping.replace(busJourneyToBeUpdated.getId(), operator);
    }
}
