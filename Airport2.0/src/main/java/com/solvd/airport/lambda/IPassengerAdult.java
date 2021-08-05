package com.solvd.airport.lambda;

import com.solvd.airport.classes.users.Passenger;

public interface IPassengerAdult<T> {
    boolean isAdult(Integer a, Integer b);
}
