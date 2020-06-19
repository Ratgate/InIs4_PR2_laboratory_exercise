package com.company;

import devices.Car;
import devices.Phone;

public class Main {

    public static void main(String[] args){
        Human me = new Human();
        me.firstName = "Captain";
        me.lastName = "Peppers";
        me.phone = new Phone("Apple", "OPv3",14.0f, "IOS");

        me.pet = new Animal("dog");
        me.pet.name = "Shaka";

        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.feed();

        me.getSalary();
        me.setSalary(3500.0d);
        me.getSalary();

        me.setCar(new Car("Cheap", "Wagenmachen", 3200.0d));
        me.setCar(new Car("Affordable", "Panstraad", 18000.0d));
        me.setCar(new Car("Ultraspensive", "Warcod", 80000.0d));

        Human myWife = new Human();
        myWife.setSalary(4200.0d);
        myWife.setCar(new Car("Affordable", "Panstraad", 18000.0d));

        Car sampleCar = new Car("Sedan", "OverpricedMotorsCompany", 12000.0d);

        if(myWife.getCar().hashCode() == me.getCar().hashCode()){
            System.out.println("Porównanie samochodu me i myWife zwraca " + myWife.getCar().equals(me.getCar()));
        } else {
            System.out.println("Hashcode samochodów me i myWife się nie zgadza");
        }

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        me.setCar(sampleCar);
        myWife.setCar(sampleCar);

        if(myWife.getCar().hashCode() == me.getCar().hashCode()){
            System.out.println("Porównanie samochodu me i myWife zwraca " + myWife.getCar().equals(me.getCar()));
        } else {
            System.out.println("Hashcode samochodów me i myWife się nie zgadza");
        }

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        System.out.println(me.toString());
        System.out.println(me.pet.toString());
        System.out.println(me.phone.toString());
        System.out.println(me.getCar().toString());
    }
}
