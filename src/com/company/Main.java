package com.company;

import creatures.Animal;
import creatures.Human;
import creatures.Pet;
import devices.Car;
import devices.Phone;

public class Main {


    public static void main(String[] args){
        Human me = new Human();
        me.firstName = "Captain";
        me.lastName = "Peppers";
        me.setPhone(new Phone("Apple", "OPv3",14.0f, "IOS"));
        me.cash = 5000.0d;

        me.pet = new Pet("dog");
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

        me.buyCar(new Car("Cheap", "Wagenmachen", 3200.0d));
        me.buyCar(new Car("Affordable", "Panstraad", 18000.0d));
        me.buyCar(new Car("Ultraspensive", "Warcod", 80000.0d));

        Human myWife = new Human();
        myWife.firstName = "Yatra";
        myWife.lastName = "Aletroch";
        myWife.setSalary(4200.0d);
        myWife.cash = 3000.0d;
        myWife.buyCar(new Car("Affordable", "Panstraad", 18000.0d));

        Car sampleCar = new Car("Sedan", "OverpricedMotorsCompany", 12000.0d);

        if(myWife.getCar().hashCode() == me.getCar().hashCode()){
            System.out.println("Porównanie samochodu me i myWife zwraca " + myWife.getCar().equals(me.getCar()));
        } else {
            System.out.println("Hashcode samochodów me i myWife się nie zgadza");
        }

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        me.buyCar(sampleCar);
        myWife.buyCar(sampleCar);

        if(myWife.getCar().hashCode() == me.getCar().hashCode()){
            System.out.println("Porównanie samochodu me i myWife zwraca " + myWife.getCar().equals(me.getCar()));
        } else {
            System.out.println("Hashcode samochodów me i myWife się nie zgadza");
        }

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        System.out.println(me.toString());
        System.out.println(me.pet.toString());
        System.out.println(me.getPhone().toString());
        System.out.println(me.getCar().toString());

        me.getCar().turnOn();
        me.getPhone().turnOn();


        me.getCar().sell(me,myWife, 2000.0d);
        me.getPhone().sell(me, myWife,500.0d);
        me.pet.sell(myWife, me, 3200.0d);
        me.pet.sell(me, myWife, 8000.0d);
    }
}
