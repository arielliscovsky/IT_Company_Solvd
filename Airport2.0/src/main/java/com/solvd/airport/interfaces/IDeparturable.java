package com.solvd.airport.interfaces;

import com.solvd.airport.classes.exceptions.AirplaneOverWeightException;

public interface IDeparturable {

    void goOnBoard() throws AirplaneOverWeightException;
    boolean takeOff();
}
