package com.solvd.airport.classes.airplane;

import com.solvd.airport.enums.Manufacturer;

public abstract class Airplane {
    protected Manufacturer manufacturer;
    protected long numberModel;
    protected Airline airline;




    public abstract void setManufacturer(Manufacturer manufacturer);
    public abstract Manufacturer getManufacturer();

    public abstract void setNumberModel(long numberModel);
    public abstract long getNumberModel();

    public abstract void  setAirline(Airline airline);
    public abstract Airline getAirline();
}
