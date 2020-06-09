package com.company.devices;

public class Electric extends Car {


    public Electric(String brand) {
        super(brand);
    }

    @Override
    public void refuel() {
        System.out.println("Yours cars battery is fully recharged");
    }

    public String toString(){
        return new String(super.toString() + " Samochód elektryczny");
    }
}
