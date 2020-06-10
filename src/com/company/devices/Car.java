package com.company.devices;

import com.company.creatures.Human;

public abstract class Car extends Device {
    String brand;
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

    public void sell(Human seller, Human buyer, double price) throws Exception {
        Boolean sellerOwnsCar = false;
        for(Integer i = 0; i < seller.garage.length; i++){
            if(this == seller.garage[i]){
                sellerOwnsCar = true;
                break;
            }
            if(!sellerOwnsCar){
                throw new Exception("Sprzedawca nie ma tego samochodu na sprzedaż");
            }


        }





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
