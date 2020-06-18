package com.company;

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
    }
}
