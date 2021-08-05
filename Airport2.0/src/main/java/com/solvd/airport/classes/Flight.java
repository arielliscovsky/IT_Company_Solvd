package com.solvd.airport.classes;

import com.solvd.airport.classes.airplane.Airplane;
import com.solvd.airport.classes.airplane.CargoAirplane;
import com.solvd.airport.classes.airplane.Container;
import com.solvd.airport.classes.airplane.PassengerAirplane;
import com.solvd.airport.classes.exceptions.AgeOverLimitException;
import com.solvd.airport.classes.exceptions.AirplaneOverWeightException;
import com.solvd.airport.classes.exceptions.AmountPilotsException;
import com.solvd.airport.classes.exceptions.WrongDestinationException;
import com.solvd.airport.classes.places.Airport;
import com.solvd.airport.classes.users.Passenger;
import com.solvd.airport.classes.users.Pilot;
import com.solvd.airport.interfaces.IArrivable;
import com.solvd.airport.interfaces.IDeparturable;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Flight implements IArrivable, IDeparturable {
    private int number;
    private Airport departure;
    private Airport arrival;
    private Airplane airplane;
    private List<Pilot> pilots;

    private final static Logger LOGGER = Logger.getLogger(Flight.class);



    public void goOnBoard(){
        if(airplane instanceof PassengerAirplane){
            int seatsAmount=  ((PassengerAirplane)airplane).getSeatsAmount();
            int seatsSold =(int) Math.floor(Math.random()*(seatsAmount)+1);
            int aux = seatsSold;
            Map<String, Passenger> map = ((PassengerAirplane)airplane).getSeats();
            while (aux!= 0){
                Passenger passenger = new Passenger();

                for (Map.Entry<String,Passenger> entry: map.entrySet()) {
                    if(entry.getValue() == null){
                        map.replace(entry.getKey(), passenger);
                        break;
                    }
                }
                aux --;
            }
            ((PassengerAirplane)airplane).setSeats(map);
            LOGGER.debug ("The amount of seats occuped is: " + seatsSold + " of " + seatsAmount + " available");
            LOGGER.debug("Passenger list: "+ map);
        }

        else {
            int weightMax = (int) ((CargoAirplane)airplane).getMaxWeight();
            int sumWeights=0;
            while (sumWeights < weightMax){
                Container container = new Container();
                ((CargoAirplane)airplane).getContainers().push(container);
                sumWeights += container.getWeight();
                if (sumWeights > weightMax){
                    ((CargoAirplane)airplane).getContainers().pop();
                    sumWeights -= container.getWeight();
                    break;
                }
            }
            LOGGER.debug("Container list: " + ((CargoAirplane)airplane).getContainers().toString());
            int porcentage = (int) Math.floor(sumWeights* 100 / weightMax);
            LOGGER.debug("Amount of containers: " + ((CargoAirplane)airplane).getContainers().size());
            LOGGER.debug("Porcentage of weight occupation: "+ porcentage + "%");
        }
    }



    public boolean takeOff() {
        pilots.get(0).setInstruments();
        if (pilots.get(0).takeOffRequest() == true){
            pilots.get(0).setTakeOffPower();
            pilots.get(0).setGearUp();
            LOGGER.debug("            Flight " + this.number + " took off");
            return true;
        }
        else {
            LOGGER.debug("    Take off denied");
            return false;
        }

    }
    public void land(){
        pilots.get(0).landingRequest();
        pilots.get(0).setLandingPower();
        pilots.get(0).setGearDown();
        LOGGER.debug("Flight " + this.number + " is about to land at "+ this.arrival.getName());
    }


    public Flight(int number, Airport departure, Airport arrival, Airplane airplane) throws WrongDestinationException {
        this.number = number;
        this.departure = departure;
        if(this.departure.equals(arrival)){
            throw new WrongDestinationException("Arrival destination is the same as departure destination");
        }
        this.arrival = arrival;
        this.airplane = airplane;
        this.pilots = new ArrayList<Pilot>();
    }

    //Random Flight constructor
    public Flight(Airport departure, Airport arrival)throws  WrongDestinationException{
        this.number = (int) Math.floor(Math.random()*(9999-100+1)+100);
        this.departure = departure;
        if(this.departure.equals(arrival)){
            throw new WrongDestinationException("Arrival destination is the same as departure destination");
        }
        this.arrival = arrival;
        if(this.number % 2 == 0){
            this.airplane = new PassengerAirplane();
        }
        else {this.airplane = new CargoAirplane();}
        this.pilots = new ArrayList<Pilot>();
        Pilot pilot1 = new Pilot();
        Pilot pilot2 = new Pilot();
        this.pilots.add(pilot1);
        this.pilots.add(pilot2);
    }

    public boolean addPilot(Pilot pilot) throws AmountPilotsException, AgeOverLimitException {
        if(this.pilots.size() == 2){
            throw new AmountPilotsException("There are two pilots already");}
        if(pilot.getAge() >64){
            throw new AgeOverLimitException();
        }
        return this.pilots.add(pilot);
    }

    public boolean removePilot (Pilot pilot) {
        if (this.pilots.contains(pilot)) {
            return this.pilots.remove(pilot);
        }
        return false;
    }

    public List<Pilot> getPilots(){ return pilots;}
    public void setPilots(List<Pilot> pilots) {this.pilots = pilots;}

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return this.number;
    }

    public Airport getArrival() {
        return this.arrival;
    }
    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return this.departure;
    }
    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public Airplane getAirplane() {
        return this.airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return number == flight.number && departure.equals(flight.departure) && arrival.equals(flight.arrival) && airplane.equals(flight.airplane) && Objects.equals(pilots, flight.pilots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, departure, arrival, airplane, pilots);
    }


    @Override
    public String toString() {
        return airplane.getAirline().getName() +
                " flight, " +
                "number " + number +
                ", from " + departure.getName() +
                " to " + arrival.getName() +
                ", in a " + airplane.getManufacturer().getName() + " "+ airplane.getNumberModel();
    }
}