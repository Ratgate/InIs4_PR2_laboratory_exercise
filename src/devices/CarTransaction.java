package devices;

import creatures.Human;

import java.time.LocalDate;

public class CarTransaction {
    public Human buyer;
    public Human seller;
    public Double price;
    public LocalDate date;


    public CarTransaction(Human buyer, Human seller, Double price, LocalDate date) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.date = date;
    }

    public Human getBuyer() {
        return buyer;
    }
}
