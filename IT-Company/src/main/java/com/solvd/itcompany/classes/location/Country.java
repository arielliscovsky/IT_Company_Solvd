package com.solvd.itcompany.classes.location;

public class Country {
    private long id;
    private String name;
    private int areaCode;

    public Country(){}

    public Country(long id, String name, int areaCode) {
        this.id = id;
        this.name = name;
        this.areaCode = areaCode;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", areaCode=" + areaCode +
                '}';
    }
}
