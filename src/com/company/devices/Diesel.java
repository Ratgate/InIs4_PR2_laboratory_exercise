package com.company.devices;

public class Diesel extends Car {


    public Diesel(String brand) {
        super(brand);
    }

    @Override
    public void refuel() {
        System.out.println("Your car has been refuel with black, liquefied gold");
    }

    public String toString(){
        return new String(super.toString() + " Samochód z silnikiem Diesel");
    }
}
