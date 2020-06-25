package devices;

import creatures.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Car extends Device{
    public Integer numberOfDoors;
    public Float maxSpeed;
    public List<CarTransaction> transactionList = new ArrayList<>();



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
                    buyer.addCar(this, new CarTransaction(buyer, seller, price, java.time.LocalDate.now()));
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

    public void addTransaction(CarTransaction transaction){
        this.transactionList.add(transaction);
    }

    public Human lastOwner(){
        return this.transactionList.get(this.transactionList.size() - 1).buyer;
    }

    public Boolean wasOwner(Human questionedHuman){
        return this.transactionList.stream().map(CarTransaction::getBuyer).anyMatch(questionedHuman::equals);
    }

     public Boolean hasSold(Human A, Human B){
         for (CarTransaction transaction : this.transactionList) {
             try{
                 if(transaction.seller == A & transaction.buyer == B){
                     return true;
                 }
             } catch (NullPointerException e){
                 continue;
             }
         }
         return false;
       }

    public Integer numberOfOwnerChanges(){
        ListIterator<CarTransaction> listIterator = this.transactionList.listIterator();
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
