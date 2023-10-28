package com.example;

import com.example.exceptions.SeatOccupiedException;
import com.example.exceptions.TicketCancellationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class TicketBookingManagerImpl implements TicketBookingManager{
    private Map<String, Customer> ticketBuyerMapping = new HashMap<>(0);

    @Override
    public Ticket bookTicketForCustomer(Customer customer, Seat seat, BusJourney busJourney) throws SeatOccupiedException {
        seat.occupy();
        Ticket ticket = new Ticket(
                UUID.randomUUID().toString(),
                customer,
                seat,
                busJourney
        );
        ticket.updateTicketStatus(TicketStatus.BOOKED);
        ticketBuyerMapping.put(ticket.getId(), customer);
        return ticket;
    }

    @Override
    public void cancelTicketForCustomer(Customer customer, Ticket ticket) throws TicketCancellationException {
        if(ticket.checkTicketStatus() == TicketStatus.CANCELLED)
            throw new TicketCancellationException("Cannot cancel an already cancelled ticket! TicketID: " + ticket.getId());

        if(!Objects.equals(ticket.getBuyer(), this))
            throw new TicketCancellationException("Cannot cancel ticket " + ticket.getId() + " since buyer info doesn't match!");

        ticket.getSelectedSeat().unOccupy();
        ticket.updateTicketStatus(TicketStatus.CANCELLED);
    }
}
