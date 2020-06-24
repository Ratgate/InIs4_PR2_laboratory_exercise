package devices;

import creatures.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Car extends Device{
    public Integer numberOfDoors;
    public Float maxSpeed;
    public List<Human> ownerList = new ArrayList<>();



    public Car(String model, String producer, Double value, Integer yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.value = value;
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(seller.haveCar(this) & this.lastOwner() == seller){
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

    public void addOwner(Human newOwner){
        this.ownerList.add(newOwner);
    }

    public Human lastOwner(){
        return this.ownerList.get(this.ownerList.size() - 1);
    }

    public Boolean wasOwner(Human questionedOwner){
        return this.ownerList.contains(questionedOwner);
    }

    public Boolean hasSold(Human A, Human B){
        ListIterator<Human> listIterator = this.ownerList.listIterator();
        try{
            while (listIterator.hasNext()){
                if(listIterator.next() == A){
                    if(this.ownerList.get(listIterator.nextIndex()) == B){
                        return true;
                    }
                }
            }
        } catch (NullPointerException | IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }

    public Integer numberOfOwnerChanges(){
        ListIterator<Human> listIterator = this.ownerList.listIterator();
        Integer numberOfTransactions = 0;
        try{
            listIterator.next();
            while (listIterator.hasNext()){
                listIterator.next();
                numberOfTransactions++;
                    }
        } catch (NullPointerException | IndexOutOfBoundsException e){
            return numberOfTransactions;
        }
        return numberOfTransactions;
    }

    public String toString(){
        return model + " " + producer + " " + value + " rok produkcji " + yearOfProduction;
    }
}
