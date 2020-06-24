package devices;

import creatures.Human;

public abstract class Car extends Device{
    public Integer numberOfDoors;
    public Float maxSpeed;



    public Car(String model, String producer, Double value, Integer yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.value = value;
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(seller.haveCar(this)){
            if(buyer.havePlaceInGarage()){
                if(buyer.cash >= price){
                    seller.removeCar(this);
                    buyer.addCar(this);
                    buyer.cash -= price;
                    seller.cash += price;
                    System.out.println("Tranzakcja zakończona sukcesem");
                } else {
                    throw new Exception("Kupujący nie ma wystarczająco dużo pieniędzy");
                }
            } else {
                throw new Exception("Kupujący nie ma miejsca w garażu");
            }
        } else {
            throw new Exception("Sprzedający nie ma tego samochodu");
        }
    }

    @Override
    public void turnOn(){
        System.out.println("Car has been turned on");
    }

    public abstract void refuel();

    public String toString(){
        return model + " " + producer + " " + value + " rok produkcji " + yearOfProduction;
    }
}
