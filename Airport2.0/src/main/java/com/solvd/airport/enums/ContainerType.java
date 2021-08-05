package com.solvd.airport.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ContainerType {

    VEGETABLES("Fruits&Vegetables"),ELECTRONIC("Electronic Devices"),VEHICLE("Auto Parts"),CLHOTHES("Clothes"), FRAGILE("Fragile");
    private String name;

    ContainerType(String name){
        this.name= name;
    }

    public String getType() {
        return name;
    }

    private static final List<ContainerType> CONTAINERS  = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = CONTAINERS.size();
    private static final Random RANDOM = new Random();

    public static ContainerType randomManufacturer() {
        return CONTAINERS.get(RANDOM.nextInt(SIZE));
    }

}
