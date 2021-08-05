package com.solvd.airport.classes.exceptions;

public class WrongDestinationException extends Exception{

    private String message = "Error: Invalid destination";

    public WrongDestinationException(){}

    public WrongDestinationException(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
