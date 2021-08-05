package com.solvd.airport.classes.airplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Airline {
    private String name;

    //random constructor
    ArrayList<String> airlines = new ArrayList<String>(List.of("Aerolineas Argentinas","Belavia","British Airways","Iberia","American Airlines","Emirates","Turkish Airlines"));
    public Airline(){
        Random random = new Random();
        int listSizeAirlines = airlines.size();
        int randomIndexAirlines = random.nextInt(listSizeAirlines);
        this.name = airlines.get(randomIndexAirlines);
    }
    public Airline(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name " + name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        Airline airline = (Airline) o;
        return getName().equals(airline.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
