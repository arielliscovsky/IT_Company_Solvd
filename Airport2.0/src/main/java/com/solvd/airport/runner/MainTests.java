package com.solvd.airport.runner;

import com.solvd.airport.classes.Flight;
import com.solvd.airport.classes.airplane.PassengerAirplane;
import com.solvd.airport.classes.collections.MyLinkedList;
import com.solvd.airport.classes.exceptions.AgeOverLimitException;
import com.solvd.airport.classes.exceptions.AirplaneOverWeightException;
import com.solvd.airport.classes.exceptions.AmountPilotsException;
import com.solvd.airport.classes.exceptions.WrongDestinationException;
import com.solvd.airport.classes.places.Airport;
import com.solvd.airport.classes.places.Country;
import com.solvd.airport.classes.users.Passenger;
import com.solvd.airport.classes.users.Pilot;
import com.solvd.airport.enums.City;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTests {

    private static final Logger LOGGER = Logger.getLogger(MainTests.class);

    public static void main(String[] ags) throws WrongDestinationException, AgeOverLimitException, AmountPilotsException, AirplaneOverWeightException {


        Airport airport = new Airport("Ezeiza Airport", City.BUENOSARIES);
        Airport airport1 = new Airport("Minsk Intl Airport", City.MINSK);
        Airport airport2 = new Airport("Barajas Madrid Airport", City.MADRID);
        Airport airport3 = new Airport("El Prat Airport", City.BARCELONA);
        Airport airport4 = new Airport("LAX", City.LOSANGELES);
        Airport airport5 = new Airport("Heathrow Airport", City.LONDON);
        Airport airport6 = new Airport("Gatwick Airport", City.LONDON);

        ArrayList<Airport> airports = new ArrayList<Airport>(List.of(airport1, airport2, airport3, airport4, airport5, airport6, airport));


        //AmountPilotsException Test
        Flight flight1 = new Flight(airport, airport1);
        Pilot pilot = new Pilot();
        try {
            flight1.addPilot(pilot);
        } catch (AmountPilotsException e) {
            //JOptionPane.showMessageDialog(null,"Third pilot not allowed");
            //e.printStackTrace();
            LOGGER.error(e);
        }

        //WrongDestinationException Test
        try {
            Flight flight2 = new Flight(airport, airport);
        } catch (WrongDestinationException e) {
            //JOptionPane.showMessageDialog(null,"Arrival destination can not be the same as departure destination");
            //e.printStackTrace();
            LOGGER.error(e);

        }

        //AgeOverLimitException test
        Flight flight3 = new Flight(airport2, airport5);
        flight3.getPilots().remove(0);
        try {
            Pilot pilot1 = new Pilot();
            pilot1.setAge(67);
            flight3.addPilot(pilot1);
        } catch (AgeOverLimitException e) {
            LOGGER.error(e);
        }

        //LinkedList test
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(25);


        LOGGER.debug(myLinkedList.toString());
        myLinkedList.addMiddle(15);
        LOGGER.debug(myLinkedList.toString());
        LOGGER.debug(myLinkedList.reverse(myLinkedList.getFirst()).toString());

        //HashSet test
        Country country = new Country("Argentina");
        country.getCities().add(City.BUENOSARIES);
        country.getCities().add(City.BARCELONA);
        country.getCities().add(City.BUENOSARIES);
        LOGGER.debug(country.getCities());

        //Lambda test
        PassengerAirplane passengerAirplane = new PassengerAirplane();
        Flight flight4 = new Flight(1,airport,airport1,passengerAirplane);
        flight4.goOnBoard();
        Map.Entry<String, Passenger> passengerSearched = passengerAirplane.search((seats,criteria)->{
             return seats
                    .entrySet()
                    .stream()
                    .filter(e -> !e.getValue().equals(null))
                    .filter(c -> criteria.equals(c.getValue().getName()))
                    .findFirst().orElse(null);
                },"Harry Cook");

        /*Map.Entry<String, Passenger> passengerSearched = passengerAirplane.search((seats,criteria)->{
            for (Map.Entry<String,Passenger> entry: seats.entrySet()) {
                if(entry.getValue() != null){
                    if (criteria.equals(entry.getValue().getName())){
                        LOGGER.debug(entry);
                        return entry;
                    }
                }
            }
            return null;
        },"Harry Cook");*/

        passengerSearched.getValue().isAdult((passengerAge,adultAge)-> passengerAge>adultAge,18);
        LOGGER.debug(passengerSearched.getValue().isAdult((passengerAge,adultAge)-> passengerAge>adultAge,18));



















        /*map.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(null))
                .map(e -> map.replace(e.getKey(),passenger));
        */




        /*Map.Entry<String,Passenger> passengerWanted = passengerAirplane.pf1((seats) -> {
                for (Map.Entry<String,Passenger> entry: seats  {
                    if(entry.getValue() != null){
                        if (property.equals(entry.getValue().getName())){
                            return entry;
                        }}
                }
                return null;
        },"Harry");*//*

        Map.Entry<String,Passenger> passengerWanted = passengerAirplane.pf1((a,b,c) -> b

        BiFunction<Map<String, Passenger>, String, Map.Entry<String,Passenger>> passengerFinder = (a, b) -> {
            for (Map.Entry<String,Passenger> entry: a.entrySet()) {
                if(entry.getValue() != null){
                    if (b.equals(entry.getValue().getName())){
                        return entry;
                    }}
            }
            return null;
        };

        public Map.Entry<String,Passenger> pf1(BiFunction<Map<String,K>,String,Map.Entry<String,Passenger>> finder){
            return  finder.apply(seats,"Alex");
        }

        //LOGGER.debug(passengerAirplane.passengerFinder.apply(passengerAirplane.getSeats(),"Harry Cook"));
        */


        

    }


}