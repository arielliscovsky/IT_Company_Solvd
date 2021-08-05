package com.solvd.airport.classes.users;

import com.solvd.airport.interfaces.IBuyable;
import com.solvd.airport.lambda.IPassengerAdult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passenger extends Person implements IBuyable {


    public boolean isAdult(IPassengerAdult<Integer> adultAge, Integer age ){
        return adultAge.isAdult(this.age,age);
    }

    public void buyTicket(){

    }

    public Passenger(String name, long id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
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

    //random constructor
    private final ArrayList<String> NAME = new ArrayList<String>(List.of("Harry ","Jack ","Oliver ","Charlie ","James ","Henry ","Tyler "));
    private final ArrayList<String> LASTNAME = new ArrayList<String>(List.of("Portter","Archer","Stone","Cook","Wayne","Smith"));

    public Passenger (){
        Random random = new Random();
        int listSizeNames = NAME.size();
        int listSizeLastNames = LASTNAME.size();
        int randomIndexNames = random.nextInt(listSizeNames);
        int randomIndexLastNames = random.nextInt(listSizeLastNames);
        this.name = NAME.get(randomIndexNames) + LASTNAME.get(randomIndexLastNames);
        this.age = (int) Math.floor(Math.random()*(60-2+1)+2);
        this.id = (long) Math.floor(Math.random()*(40000000-30000000+1)+30000000);

    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }




}
