package com.company.creatures;
import com.company.Feedable;
import com.company.Saleable;
import com.company.creatures.Human;

import java.io.File;

public abstract class Animal implements Saleable, Feedable {
    final public String species;
    public String name;
    public Boolean isAlive = true;

    private Double weight;
    private File pic;
    private final static Double DEFAULT_WEIGHT_DOG = 4.0;
    private final static Double DEFAULT_WEIGHT_LION = 150.0;
    private final static Double DEFAULT_WEIGHT_PENGUIN = 13.0;
    private String deathScream = "Your dog is too dead to do that, you dog murderer!";


    public Animal(String species) {
        this.species = species;
        switch (this.species) {
            case "dog":
                this.weight = DEFAULT_WEIGHT_DOG;
                break;
            case "lion":
                this.weight = DEFAULT_WEIGHT_LION;
                break;
            case "penguin":
                this.weight = DEFAULT_WEIGHT_PENGUIN;
                break;
        }
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

    public void feed(){

        feed(1.0d);
    }

    public void feed(Double foodWeight)
    {
        if (isAlive) {
            System.out.println("Omnomnom");
            weight += foodWeight;
            checkIfAlive();
            System.out.println(weight);
        }
        else
            System.out.println(deathScream);
    }

    public void takeForWalk()
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
    public void sell(Human seller, Human buyer, double price) throws Exception {
        if(this instanceof Human){
            throw new Exception("Slavery is forbidden in this parts, hombre");
        }
        else{
            if(buyer.cash >= price)
            {
                buyer.cash -= price;
                seller.cash += price;
                buyer.pet = seller.pet;
                seller.pet = null;
                System.out.println("This " + buyer.pet.species +" has been sold to the highest bidder");
            }
            else
            {
                System.out.println(buyer.name + "has not enough money to buy this" + seller.species);
            }
        }
    }
}
