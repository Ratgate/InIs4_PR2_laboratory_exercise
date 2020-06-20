package devices;

import com.company.Human;

import java.sql.SQLOutput;

public class Phone extends Device {
    final Float screenSize;
    final String os;


    public Phone(String producer, String model, Float screenSize, String os) {
        this.screenSize = screenSize;
        this.os = os;
    }


    @Override
    public void turnOn(){
        System.out.println("Phone has been turned on");
    }

    void mute(){
        System.out.println("Phone has been muted");
    }

    void installAnApp(){
        System.out.println("App has been installed on the phone");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        try {
            if (seller.getPhone().equals(this)) {
                if (buyer.cash >= price) {
                    buyer.cash -= price;
                    seller.cash += price;
                    buyer.setPhone(this);
                    seller.setPhone(null);
                    System.out.println(buyer.firstName + " " + buyer.lastName + " kupił " + this.model  + " od " + seller.firstName + " " + seller.lastName + " za " + price);
                } else {
                    System.out.println(buyer.firstName + " " + buyer.lastName + " nie stać by zapłacić " + price);
                }
            } else {
                System.out.println(seller.firstName + " " + seller.lastName + "nie ma wskazanego " + this.model);
            }
        } catch (NullPointerException e){
            System.out.println(seller.firstName + " " + seller.lastName + " nie ma oczekiwanego telefonu o modelu " + this.model);
        }
    }

    public String toString(){
        return producer + " " + model + " " + screenSize + " " + os;
    }
}
