package com.company.devices;

public abstract class Car extends Device {
    String brand;
    public Float value;
    public Integer seats;
    public String colour;
    public Integer yearOfProduction;

    private String plate;


    public Car(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) throws Exception {
        if(plate.length()!=8){
            throw new Exception();
        } else
        {
            this.plate = plate;
        }
    }

    public String toString(){
        return this.brand + " " + this.yearOfProduction;
    }

    @Override
    void turnOn() {
        System.out.println("Started the ignition");
    }

    abstract public void refuel();
}
