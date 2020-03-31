package com.company;

import com.company.devices.Device;

import java.io.File;

public class Animal implements Ediable, Saleable {
    final String species;
    String name;
    private Double weight;
    File pic;
    private final static Double DEFAULT_WEIGHT_DOG = 4.0;
    private final static Double DEFAULT_WEIGHT_LION = 150.0;
    private final static Double DEFAULT_WEIGHT_PENGUIN = 13.0;
    private Boolean isAlive = true;
    private String deathScream = "Your dog is too dead to do that, you dog murderer!";

    public Animal(String species) {

        this.species = species;
        if(this.species == "dog")
            this.weight = DEFAULT_WEIGHT_DOG;
        else if(this.species == "lion")
            this.weight = DEFAULT_WEIGHT_LION;
        else if(this.species == "penguin")
            this.weight = DEFAULT_WEIGHT_PENGUIN;
    }
    void checkIfAlive(){
        if(weight > 3*DEFAULT_WEIGHT_DOG)
        {
            System.out.println("Oh, shit! Diabetes");
            isAlive = false;
        }
        else if(weight < 0.80 * DEFAULT_WEIGHT_DOG)
        {
            System.out.println("Your dog just died of starvation. Congratulations!");
            isAlive = false;
        }
    }

    void feed(){
        if (isAlive == true) {
            System.out.println("Omnomnom");
            weight++;
            checkIfAlive();
            System.out.println(weight);
        }
        else
            System.out.println(deathScream);
    }
    void takeForWalk()
    {
        if (isAlive)
        {
            System.out.println("Who lets the dogs out?");
            weight--;
            checkIfAlive();
            System.out.println(weight);
        }
        else
            System.out.println(deathScream);
    }

    public String toString(){
        return this.name + " Is alive? " + this.isAlive;
    }

    @Override
    public void beEaten() {
        this.isAlive = false;
    }

    @Override
    public void sell(Human who, Human whom, float price) throws Exception {
        if(this instanceof Human){
            throw new Exception("Slavery is forbidden in this parts, hombre");
        }
        else{
            if(whom.cash >= price)
            {
                whom.cash -= price;
                who.cash += price;
                whom.pet = who.pet;
                who.pet = null;
            }
            else
            {
                System.out.println(whom.name + "has not enough money to buy this" + who.species);
            }

            System.out.println("This " + whom.pet.species +" has been sold to the highest bidder");
        }
    }
}