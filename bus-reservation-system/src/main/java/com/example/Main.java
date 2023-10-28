package com.example;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        BusJourneyManager busJourneyManager = new BusJourneyManagerImpl();
        Operator operator = new Operator("OP_ID_1", "ABC Travels", "91945130458", busJourneyManager);
        Bus bus = new Bus(
                "bus_id_1",
                "ABCD1345",
                new ArrayList<>(List.of(new Seat("A"),
                        new Seat("B"),
                        new Seat("C"),
                        new Seat("D"))),
                false,
                BusType.SEATER
        );
        BusJourney busJourney = new BusJourney(
                "bus_journey_1",
                bus,
                Instant.now(),
                Instant.now().plusSeconds(86400),
                operator
        );
        Route route = new Route(UUID.randomUUID().toString());
        BusStop source = new BusStop("Stop A", "City A", "District A", "State");
        source.changeStopDuration(Duration.ZERO);
        source.updateIfHasRefreshments(false);
        BusStop destination = new BusStop("Stop C", "City C", "District C", "State");
        destination.updateIfHasRefreshments(false);
        destination.changeStopDuration(Duration.ZERO);
        BusStop halvadBusStop = new BusStop("Stop B", "City B", "District A", "State");
        halvadBusStop.updateIfHasRefreshments(true);
        halvadBusStop.changeStopDuration(Duration.of(15, ChronoUnit.MINUTES));
        route.addBusStop(source, 0);
        route.addBusStop(destination, 1);
        route.addBusStop(halvadBusStop, 1);
        busJourney.updateBusJourneyRoute(route);
        bus.subscribe(busJourney);
        operator.addBusJourney(busJourney);
        TicketBookingManager ticketBookingManager = new TicketBookingManagerImpl();
        Customer customer1 = new Customer("customer_id_1", "abc", "01-01-1973", "1345671456", ticketBookingManager);
        Customer customer2 = new Customer("customer_id_2", "xyz", "01-05-1976", "1345671456", ticketBookingManager);

        List<Seat> availableSeats = bus.getAvailableSeats();
        Ticket ticket1 = bookTicket(customer1, availableSeats.get(0), busJourney);
        Ticket ticket2 = bookTicket(customer2, availableSeats.get(0), busJourney);

        System.out.println("Ticket1 booked: " + ticket1);
        System.out.println("Ticket2: " + ticket2);

        System.out.println("Bus status: " + bus.getBusStatus());
        System.out.println("Next bus stop: " + busJourney.getNextBusStop());
        try{
            bus.move();
        }
        catch (Exception e){
            System.out.println("Failed to move the bus... Raising exception " + e);
        }
        System.out.println("Bus status: " + bus.getBusStatus());
        System.out.println("Next bus stop: " + busJourney.getNextBusStop());
        System.out.println("Bus will wait for duration: " + busJourney.getNextBusStop().getStopDuration());

    }

    public static Ticket bookTicket(Customer customer, Seat seat, BusJourney busJourney){
        try{
            Ticket ticket = customer.bookSeatForBusJourney(seat, busJourney);
            return ticket;
        }
        catch (Exception e){
            System.out.println("Failed to book ticket for customer with exception " + e);
        }
        return null;
    }
}