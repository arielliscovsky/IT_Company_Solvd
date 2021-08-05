package com.solvd.airport.runner;

import com.solvd.airport.classes.Flight;
import com.solvd.airport.classes.exceptions.AgeOverLimitException;
import com.solvd.airport.classes.exceptions.AirplaneOverWeightException;
import com.solvd.airport.classes.exceptions.AmountPilotsException;
import com.solvd.airport.classes.exceptions.WrongDestinationException;
import com.solvd.airport.classes.places.Airport;
import com.solvd.airport.enums.City;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainSimulation {


    private static final Logger LOGGER = Logger.getLogger(MainSimulation.class);

    public static void main(String[] ags) throws WrongDestinationException, AgeOverLimitException, AmountPilotsException, AirplaneOverWeightException {



        Airport airport = new Airport("Ezeiza Airport", City.BUENOSARIES);
        Airport airport1 = new Airport("Minsk Intl Airport", City.MINSK);
        Airport airport2 = new Airport("Barajas Madrid Airport", City.MADRID);
        Airport airport3 = new Airport("El Prat Airport", City.BARCELONA);
        Airport airport4 = new Airport("LAX", City.LOSANGELES);
        Airport airport5 = new Airport("Heathrow Airport", City.LONDON);
        Airport airport6 = new Airport("Gatwick Airport", City.LONDON);

        ArrayList<Airport> airports = new ArrayList<Airport>(List.of(airport1, airport2, airport3, airport4, airport5, airport6, airport));


        //Random automatic flights simulation
        Scanner sc = new Scanner(System.in);
        LOGGER.debug("How many flights do you want to simulate?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int listSizeAirports = airports.size();
            int randomIndexAirport1 = random.nextInt(listSizeAirports);
            int randomIndexAirport2 = random.nextInt(listSizeAirports);
            Airport airp1 = airports.get(randomIndexAirport1);
            Airport airp2 = airports.get(randomIndexAirport2);
            try {
                Flight flight = new Flight(airp1, airp2);
                LOGGER.debug(flight.toString());
                flight.goOnBoard();
                if (flight.takeOff()) {
                    flight.land();
                }
            } catch (WrongDestinationException e) {
                LOGGER.error(e);
            }
        }
    }
}