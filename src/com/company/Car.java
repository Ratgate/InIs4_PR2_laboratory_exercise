package com.company;

public class Car {
    String brand;
    Float value;
    Integer seats;
    String colour;
    Integer yearOfProduction;
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
}
