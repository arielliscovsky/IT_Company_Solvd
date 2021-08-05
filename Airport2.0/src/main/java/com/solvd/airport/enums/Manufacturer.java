package com.solvd.airport.enums;

import java.util.*;

public enum Manufacturer {


    AIRBUS("Airbus", "A"),
    BOEING("Boeing","B"),
    EMBRAER("Embraer", "EMB");

    private String name;
    private String acronym;

    Manufacturer(String name, String acronym) {
        this.name= name;
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    private static final List<Manufacturer> MANUFACTURERS  = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = MANUFACTURERS.size();
    private static final Random RANDOM = new Random();

    public static Manufacturer randomManufacturer() {
    return MANUFACTURERS.get(RANDOM.nextInt(SIZE));
    }


}
