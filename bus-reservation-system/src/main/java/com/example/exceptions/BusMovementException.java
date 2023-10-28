package com.example.exceptions;

public class BusMovementException extends InvalidStateException{
    public BusMovementException(String message) {
        super(message);
    }
}
