package com.company;

import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.Electric;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) throws Exception {
        Pet dog = new Pet ("dog");
        dog.name = "Albert";

        System.out.println(dog.name + dog.species);
        dog.feed();


        Human me = new Human();
        me.firstName = "Captain";
        me.lastName = "Peppers";
        me.pet = dog;
        me.cash = 3000d;

        System.out.println(me.pet.species);
        System.out.println(me.pet.name);
        me.pet.feed();
        me.pet.takeForWalk();
        me.pet.takeForWalk();
        me.pet.takeForWalk();
        me.pet.takeForWalk();

        Electric myCar = new Electric("Mazda");
        myCar.value = 12000.0f;
        myCar.seats = 5;
        myCar.colour = "black";
        myCar.yearOfProduction = 2012;
        myCar.setPlate("AEZ-4KM1");

        me.canAffordThatCar(myCar);
        System.out.println(me.getCar().getPlate());
        System.out.println(me.getSalary());

        Human myWife = new Human();
        myWife.setCar(me.getCar());
        myWife.cash = 2400d;
        System.out.println(myWife.getCar().getPlate());

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        System.out.println(me);
        System.out.println(myWife);
        System.out.println(me.pet);


        Human bigMe = new Human();
        bigMe.pet = myWife;

        me.pet.sell(me, myWife, 1600d);
        me.feed();

        Phone samplePhone = new Phone();
        samplePhone.installAnnApp("BrickMasters", "1.04");


        myWife.getCar().refuel();
    }
}
