package com.company;

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
        myCar.value = 50000.0f;
        myCar.seats = 5;
        myCar.colour = "black";
        myCar.yearOfProduction = 2012;
        myCar.setPlate("AEZ-4KM1");

        me.setOfWheels = myCar;
        System.out.println(me.setOfWheels.getPlate());


    }
}
