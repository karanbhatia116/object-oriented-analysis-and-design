package com.example;

import com.example.exceptions.SeatOccupiedException;
import com.example.exceptions.TicketCancellationException;

public interface TicketBookingManager {
    public Ticket bookTicketForCustomer(Customer customer, Seat seat, BusJourney busJourney) throws SeatOccupiedException;
    public void cancelTicketForCustomer(Customer customer, Ticket ticket) throws TicketCancellationException;
}
