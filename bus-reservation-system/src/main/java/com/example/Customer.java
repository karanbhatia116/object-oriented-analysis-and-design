package com.example;
import com.example.exceptions.NotImplementedException;
import com.example.exceptions.SeatOccupiedException;
import com.example.exceptions.TicketCancellationException;

import java.util.Objects;

public class Customer {
    private final String id;
    private final String name;
    private final String dob;
    private final String phoneNo;
    private final TicketBookingManager ticketBookingManager;

    public Customer(String id, String name, String dob, String phoneNo, TicketBookingManager ticketBookingManager) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.ticketBookingManager = ticketBookingManager;
    }

    public Ticket bookSeatForBusJourney(Seat seat, BusJourney busJourney) throws SeatOccupiedException {
        return ticketBookingManager.bookTicketForCustomer(this, seat, busJourney);
    }

    public void cancelTicket(Ticket ticket) throws TicketCancellationException {
        ticketBookingManager.cancelTicketForCustomer(this, ticket);
    }

    public BusJourney searchBusJourneyBySourceAndDestination(String source, String destination) throws NotImplementedException {
        throw new NotImplementedException("searchBusJourneyBySourceAndDestination is not implemented yet!");
    }

    public BusJourney trackBusJourneyForTicket(Ticket ticket){
        return ticket.getBusJourney();
    }

    public BusStop checkNextBusStop(Ticket ticket) {
        return ticket.getBusJourney().getNextBusStop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name) && Objects.equals(dob, customer.dob) && phoneNo.equals(customer.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNo);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
