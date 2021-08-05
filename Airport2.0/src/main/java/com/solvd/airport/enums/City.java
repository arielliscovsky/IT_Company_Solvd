package com.solvd.airport.enums;

import java.time.ZoneId;
import java.time.ZoneOffset;

public enum City {

    BUENOSARIES("Buenos Aires"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    },
    MINSK("Minsk"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    },
    LONDON("London"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    },
    BARCELONA("Barcelona"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    },
    MADRID("Madrid"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    },
    LOSANGELES("Los Angeles"){
        @Override
        public int getLocalHour(){
            return 0;
        }
    };



    private String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    abstract int getLocalHour();
}
