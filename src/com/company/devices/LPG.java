package com.company.devices;

public class LPG extends Car {

    public LPG(String brand) {
        super(brand);
    }

    @Override
    public void refuel() {
        System.out.println("Your car has been successfully reLPGed");
    }
}
