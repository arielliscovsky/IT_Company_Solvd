package com.solvd.airport.lambda;

import com.solvd.airport.classes.users.Passenger;

import java.util.Map;

@FunctionalInterface
public interface ISearcher{

    Map.Entry<String, Passenger> search(Map<String,Passenger> searchMap, String criteria);
}
