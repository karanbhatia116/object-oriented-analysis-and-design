package com.example;

public class Ticket {
    private final String id;
    private final Customer buyer;
    private final Seat selectedSeat;
    private final BusJourney busJourney;

    private TicketStatus ticketStatus;

    public Ticket(String id, Customer buyer, Seat seat, BusJourney busJourney) {
        this.id = id;
        this.buyer = buyer;
        this.selectedSeat = seat;
        this.busJourney = busJourney;
    }

    public TicketStatus checkTicketStatus(){
        return this.ticketStatus;
    }

    public void updateTicketStatus(TicketStatus ticketStatus){
        this.ticketStatus = ticketStatus;
    }

    public String getId() {
        return id;
    }

    public BusJourney getBusJourney() {
        return busJourney;
    }

    public Seat getSelectedSeat() {
        return selectedSeat;
    }

    public Customer getBuyer() {
        return buyer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", buyer=" + buyer +
                ", selectedSeat=" + selectedSeat +
                ", busJourney=" + busJourney +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
