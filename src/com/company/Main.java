package com.company;

import com.company.devices.Car;

public class Main {

    public static void main(String[] args) throws Exception {
        Animal dog = new Animal("dog");
        dog.name = "Albert";

        System.out.println(dog.name + dog.species);
        dog.feed();


        Human me = new Human();
        me.firstName = "Captan";
        me.lastName = "Peppers";
        me.pet = dog;

        System.out.println(me.pet.species);
        System.out.println(me.pet.name);
        me.pet.feed();
        me.pet.takeForWalk();
        me.pet.takeForWalk();
        me.pet.takeForWalk();
        me.pet.takeForWalk();

        Car myCar = new Car("Mazda");
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
        System.out.println(myWife.getCar().getPlate());

        System.out.println(me.getCar());
        System.out.println(myWife.getCar());

        System.out.println(me);
        System.out.println(myWife);
        System.out.println(me.pet);


        Human bigMe = new Human();
        bigMe.pet = myWife;




    }
}
