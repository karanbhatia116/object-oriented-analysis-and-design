package com.example;

import com.example.exceptions.SeatOccupiedException;

import java.math.BigDecimal;

public class Seat {
    private final String id;
    private Boolean isTaken = false;
    private BigDecimal price;

    public Seat(String id) {
        this.id = id;
    }

    public void occupy() throws SeatOccupiedException {
        if(this.isTaken)
            throw new SeatOccupiedException("The seat " + this.id + " is already occupied. Cannot occupy the seat!");
        this.isTaken = true;
    }

    public void unOccupy(){
        this.isTaken = false;
    }

    public BigDecimal seePrice(){
        return this.price;
    }

    public Boolean getIsTaken(){
        return this.isTaken;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", isTaken=" + isTaken +
                ", price=" + price +
                '}';
    }
}
