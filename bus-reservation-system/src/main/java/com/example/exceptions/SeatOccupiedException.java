package com.example.exceptions;

public class SeatOccupiedException extends InvalidStateException{
    public SeatOccupiedException(String message) {
        super(message);
    }
}
