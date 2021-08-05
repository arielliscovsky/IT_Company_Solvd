package com.solvd.airport.classes.users;

import com.solvd.airport.interfaces.IFlyable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Pilot extends Person implements IFlyable {
    private long licenseNumber;
    private long flightHours;

    private static final Logger LOGGER = Logger.getLogger(Pilot.class);



    public Pilot(String name, long id, int age, long licenseNumber, long flightHours) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.licenseNumber = licenseNumber;
        this.flightHours = flightHours;
    }

    ArrayList<String> names = new ArrayList<String>(List.of("Harry","Jack","Oliver","Charlie","James","Henry","Tyler"));
    ArrayList<String> lastNames = new ArrayList<String>(List.of("Portter","Archer","Stone","Cook","Wayne","Smith"));


    public Pilot(){
        Random random = new Random();
        int listSizeNames = names.size();
        int listSizeLastNames = lastNames.size();
        int randomIndexNames = random.nextInt(listSizeNames);
        int randomIndexLastNames = random.nextInt(listSizeLastNames);
        this.name = names.get(randomIndexNames) + " "+ lastNames.get(randomIndexLastNames);
        this.age = (int) Math.floor(Math.random()*(68-30+1)+30);
        this.id = (long) Math.floor(Math.random()*(40000000-30000000+1)+30000000);
        this.licenseNumber = (long) Math.floor(Math.random()*(4000-2000+1)+2000);
        this.flightHours = (long) Math.floor(Math.random()*(3000-1500+1)+1500);

    }

    public void setInstruments(){LOGGER.debug("Instruments set");}

    public boolean takeOffRequest(){
        java.util.Random random = new java.util.Random();
        boolean random_authorization = random.nextBoolean();
        return random_authorization;
    }
    public void setTakeOffPower(){LOGGER.debug("  Take off power set");}

    public void setGearUp(){LOGGER.debug("        Gear up");}

    public void setLandingPower(){LOGGER.debug("      Landing power set");}
    public void setGearDown(){LOGGER.debug("  Gear down");}

    public void landingRequest(){LOGGER.debug("           Landing approved"); }

    public long getFlightHours() {
        return flightHours;
    }
    public void setLicenseNumber (long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    public long getLicenseNumber (){
        return  licenseNumber;
    }
    public void setFlightHours (long flightHours){
        this.flightHours = flightHours;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", licenseNumber=" + licenseNumber +
                ", flightHours=" + flightHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot)) return false;
        Pilot pilot = (Pilot) o;
        return getLicenseNumber() == pilot.getLicenseNumber() && getFlightHours() == pilot.getFlightHours();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLicenseNumber(), getFlightHours());
    }
}