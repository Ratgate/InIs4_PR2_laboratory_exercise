package com.company.devices;

import com.company.creatures.Human;
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
    public void sell(Human seller, Human buyer, double price) {
        if(buyer.cash <= price)
        {
            buyer.cash -= price;
            seller.cash += price;
            System.out.println("Device has been sold, yet transaction lacks product");
        }
        else
        {
            System.out.println("Sorry, no can do");
        }

    }
}
