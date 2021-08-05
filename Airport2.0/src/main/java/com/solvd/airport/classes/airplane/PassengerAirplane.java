package com.solvd.airport.classes.airplane;

import com.solvd.airport.classes.users.Passenger;
import com.solvd.airport.enums.Manufacturer;
import com.solvd.airport.enums.SeatsLetter;
import com.solvd.airport.lambda.ISearcher;


import java.util.*;

public class PassengerAirplane<K, T, V> extends Airplane  {
    private int seatsAmount;
    private Map<String, Passenger> seats;

    public Map.Entry<String, Passenger> search(ISearcher searcher, String name){
        return searcher.search(seats,name);
    }

    public PassengerAirplane (int seatsAmount, Manufacturer manufacturer, int numberModel, Airline airline){
        this.seatsAmount = seatsAmount;
        this.numberModel = numberModel;
        this.manufacturer = manufacturer;
        this.airline = airline;
        this.seats = new HashMap<String, Passenger>();
    }

    public PassengerAirplane(){
        this.numberModel = (long) Math.floor(Math.random()*(800-300+1)+300);
        this.manufacturer = Manufacturer.randomManufacturer();
        this.airline = new Airline();
        this.seats = seatsMapping();
        this.seatsAmount = seatsNumberGenerator().size();
    }


    public ArrayList<String> seatsNumberGenerator (){
        ArrayList<String> seat= new ArrayList<String>();
        long seatsAmount = (long) Math.floor(Math.random()*(30-20+1)+20);
        
        for(int i = 1; i< seatsAmount; i++){
            for (SeatsLetter letter: SeatsLetter.LETTERS){
                seat.add(i + letter.getName());
            }}
        return seat;

    }

    public Map<String,Passenger> seatsMapping(){
        Map<String,Passenger> map = new HashMap<String, Passenger>();
        ArrayList<String> seat = seatsNumberGenerator();
        seat.stream().forEach((s) -> map.put(s,null));
        /*for (String s: seat) {
            map.put(s,null);
        }*/
        return map;
    }

    public void setSeatsAmount(int seatsAmount) {
        this.seatsAmount = seatsAmount;
    }
    public int getSeatsAmount() {
        return this.seatsAmount;
    }


    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }


    public void setNumberModel(long numberModel) {
        this.numberModel = numberModel;
    }

    public long getNumberModel() {
        return this.numberModel;
    }


    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public void setSeats(Map<String, Passenger> seats) {
        this.seats = seats;
    }

    public Map<String,Passenger > getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "PassengerAirplane{" +
                "manufacturer=" + manufacturer +
                ", numberModel=" + numberModel +
                ", airline=" + airline +
                ", seatsAmount=" + seatsAmount +
                '}';
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerAirplane)) return false;
        PassengerAirplane that = (PassengerAirplane) o;
        return getSeatsAmount() == that.getSeatsAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeatsAmount());
    }

    /*public T passengerFinder(BiFunction  property) {
        return property
    }*//*

    public Map.Entry<String,Passenger> pf1(BiFunction<Map<String,K>,String,Map.Entry<String,Passenger>> finder){
        return  finder.apply(seats,"Alex");
    }

    *//*public Map.Entry<K,V> pf (BiFunction<Map<K,V>, T, Map.Entry<K,V>> finder) {
        return finder.apply(seats,}*//*

    public BiFunction<Map<String, Passenger>, String, Map.Entry<String,Passenger>> passengerFinder = (a, b) -> {
        for (Map.Entry<String,Passenger> entry: a.entrySet()) {
            if(entry.getValue() != null){
                if (b.equals(entry.getValue().getName())){
                    return entry;
            }}
        }
        return null;
    };

    public Map passengerFinder(IPassengerFinder pFinder, V property) {
        return pFinder.passengerFinder(seats, property);
    }*/


}
