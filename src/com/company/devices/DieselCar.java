package com.company.devices;

public class DieselCar extends Car {
    public DieselCar(String brand) {
        super(brand);
    }

    @Override
    void refuel() {
        System.out.println("Your car has been refuel with black, liquefied gold");
    }

    public String toString(){
        return new String(super.toString() + " Samochód z silnikiem Diesel");
    }
}
