package com.solvd.itcompany.classes.location;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.concurrent.CompletableFuture;

@XmlRootElement(name = "city")
public class City {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    private Double zipCode;
    @XmlElement(name = "country")
    private Country country;

    public City(){}

    public City(long id, String name, Double zipCode, Country country) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.country = country;
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

    public Double getZipCode() {
        return zipCode;
    }

    public void setZipCode(Double zipCode) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zipCode=" + zipCode +
                ", country=" + country +
                '}';
    }
}
