package com.solvd.airport.classes.exceptions;

public class AirplaneOverWeightException extends  Exception{
    private String message = "Error: The plane is overweight";

    public AirplaneOverWeightException(){}

    public AirplaneOverWeightException(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}

