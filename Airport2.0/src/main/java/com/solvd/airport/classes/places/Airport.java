package com.solvd.airport.classes.places;

import com.solvd.airport.enums.City;

import java.util.Objects;

public class Airport {

    private String name;
    private City city;

    public Airport(String name, City city){
        this.name = name;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return getName().equals(airport.getName()) && getCity().equals(airport.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCity());
    }
}
