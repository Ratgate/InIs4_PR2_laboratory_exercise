package com.company.devices;

public class ElectricCar extends Car {
    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    void refuel() {
        System.out.println("Yours cars battery is fully recharged");
    }

    public String toString(){
        return new String(super.toString() + " Samochód elektryczny");
    }
}
