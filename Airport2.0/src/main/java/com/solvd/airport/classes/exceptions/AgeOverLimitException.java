package com.solvd.airport.classes.exceptions;

public class AgeOverLimitException extends Exception {
    private String message = "Error: Pilot's age is over the limit allowed";

    public AgeOverLimitException(){}

    public AgeOverLimitException(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
