package com.solvd.airport.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SeatsLetter {

    A("A"),B("B"),C("C"),D("D"),E("E"),F("F");

    private String name;

    private SeatsLetter (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static final  List<SeatsLetter> LETTERS  = Collections.unmodifiableList(Arrays.asList(values()));


}
