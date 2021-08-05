package com.solvd.airport.classes.places;

import java.util.HashSet;
import java.util.Set;

public class Country<E> {
    private String name;
    private Set<E> city;

    public Country(){}

    public Country(String name){
        this.name=name;
        this.city= new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<E> getCities() {
        return city;
    }

    public void setCities(Set<E> cities) {
        this.city = cities;
    }
}
