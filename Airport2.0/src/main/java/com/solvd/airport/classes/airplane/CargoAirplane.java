package com.solvd.airport.classes.airplane;

import com.solvd.airport.enums.Manufacturer;

import java.util.Objects;
import java.util.Stack;

public class CargoAirplane<K> extends Airplane  {
    private int maxWeight;
    private Stack<K> containers;


    public CargoAirplane (int maxWeight, Manufacturer manufacturer, int numberModel, Airline airline){
        this.maxWeight = maxWeight;
        this.numberModel = numberModel;
        this.manufacturer = manufacturer;
        this.airline = airline;
        this.containers= new Stack<K>();
    }
    //random constructor
    public CargoAirplane(){
        this.maxWeight = (int) Math.floor(Math.random()*(2500-1500+1)+1500);
        this.numberModel = (long) Math.floor(Math.random()*(800-300+1)+300);
        this.manufacturer = Manufacturer.randomManufacturer();
        this.airline = new Airline();
        this.containers= new Stack<K>();
    }

    public void setMaxWeight (int maxWeight) {
        this.maxWeight = maxWeight;
    }
    public long getMaxWeight() {
        return this.maxWeight;
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

    public Stack<K> getContainers() {
        return containers;
    }
    public void setContainers(Stack<K> containers) {
        this.containers = containers;
    }

    @Override
    public String toString() {
        return "CargoAirplane{" +
                "manufacturer=" + manufacturer +
                ", numberModel=" + numberModel +
                ", airline=" + airline +
                ", maxWeight=" + maxWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoAirplane)) return false;
        CargoAirplane that = (CargoAirplane) o;
        return getMaxWeight() == that.getMaxWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxWeight());
    }
}
