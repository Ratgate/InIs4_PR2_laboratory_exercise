package devices;

import creatures.Human;

public class Car extends Device{
    public Integer numberOfDoors;
    public Float maxSpeed;
    public Double value;


    public Car(String model, String producer, Double value) {
        this.model = model;
        this.producer = producer;
        this.value = value;
    }


    @Override
    public void sell(Human seller, Human buyer, Double price) {
        try {
            if (seller.getCar().equals(this)) {
                if (buyer.cash >= price) {
                    buyer.cash -= price;
                    seller.cash += price;
                    buyer.setCar(this);
                    seller.setCar(null);
                    System.out.println(buyer.firstName + " " + buyer.lastName + " kupił " + this.model + " od " + seller.firstName + " " + seller.lastName + " za " + price);
                } else {
                    System.out.println(buyer.firstName + " " + buyer.lastName + " nie stać by zapłacić " + price);
                }
            } else {
                System.out.println(seller.firstName + " " + seller.lastName + "nie ma wskazanego " + this.model);
            }
        } catch (NullPointerException e) {
            System.out.println(seller.firstName + " " + seller.lastName + " nie ma oczekiwanego samochodu o modelu " + this.model);
        }
    }

    @Override
    public void turnOn(){
        System.out.println("Car has been turned on");
    }

    public String toString(){
        return model + " " + producer + " " + numberOfDoors + " " + maxSpeed + " " + value;
    }
}
