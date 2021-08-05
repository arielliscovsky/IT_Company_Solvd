package com.solvd.airport.classes.airplane;

import com.solvd.airport.enums.ContainerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Container {
    private String type;
    private int weight;

    public Container(){
        this.type = ContainerType.randomManufacturer().getType();
        this.weight = (int) Math.floor(Math.random()*(500-50+1)+50);

    }

    public Container (String type, int weight){
        this.type= type;
        this.weight= weight;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Container{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
