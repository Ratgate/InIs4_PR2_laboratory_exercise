package com.company.devices;

import com.company.Human;
import com.company.Saleable;

public abstract class Device implements Saleable {
    public Double maxOperatingTime;
    public Boolean isElectrical;
    public Integer quantityOfMuchWheels;

    public String producer;
    public String model;
    public Integer yearOfProduction;

    public String toString(){
        return this.producer + " " + this.model;
    }

    abstract void turnOn();

    @Override
    public void sell(Human seller, Human buyer, float price) {
        if(buyer.cash <= price)
        {
            System.out.println("Device has been sold, yet not implemented");
        }
        else
        {
            System.out.println("Sorry, no can do");
        }

    }
}
