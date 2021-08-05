package com.solvd.airport.classes.exceptions;

public class AmountPilotsException extends Exception {
    private String message = "Error: Invalid amount of pilots for this flight";

    public AmountPilotsException(){}

    public AmountPilotsException(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
