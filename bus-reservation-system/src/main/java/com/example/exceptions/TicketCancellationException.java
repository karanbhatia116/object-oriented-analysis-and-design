package com.example.exceptions;

public class TicketCancellationException extends InvalidStateException{
    public TicketCancellationException(String message) {
        super(message);
    }
}
