package com.company;

import java.io.File;

public class Animal implements salleable{
    final static Double DEFAULT_WEIGHT_DOG = 4.0d;
    final static Double DEFAULT_WEIGHT_LION = 180.0d;
    final static Double DEFAULT_WEIGHT_PENGUIN = 22.0d;
    final static Double DEFAULT_WEIGHT_GAIN = 2.0d;

    final public String species;
    public String name;
    File pic;

    private Double weight;
    private Boolean isAlive = true;


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


    void feed(){
        if (this.isAlive) {
            this.weight += DEFAULT_WEIGHT_GAIN;
            System.out.println(this.species + " " + this.name + " has been fed");
        } else {
            System.out.println("Dead " + this.species + " need no food");
        }
    }

    void takeForAWalk(){
        if (this.isAlive) {
            this.weight -= DEFAULT_WEIGHT_GAIN;
            System.out.println(this.species + " " + this.name + " has been taken for a walk");
            if(weight <= 0){
                this.isAlive = false;
                System.out.println(this.species + " " + this.name + " has died of starvation");
            }
        } else {
            System.out.println(this.species + " " + this. name + " is not to fancy to go out. You wonder why? Because " + this.name + " is dead!");
        }
    }

    void playWith(){
        System.out.println("Animal " + this.name + " has been played with");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price){
        if(!(this.species.equals("human"))){
            try{
                if(seller.pet.equals(this)) {
                    if(buyer.cash >= price) {
                        buyer.cash -= price;
                        seller.cash += price;
                        buyer.pet = this;
                        seller.pet = null;
                        System.out.println(buyer.firstName + " " + buyer.lastName + " kupił " + this.species + " " + this.name + " od " + seller.firstName + " " + seller.lastName + " za " + price);
                    } else {
                        System.out.println(buyer.firstName + " " + buyer.lastName + " nie stać by zapłacić " + price);
                    }
                }
            } catch (NullPointerException e) {
               System.out.println(seller.firstName + " " + seller.lastName + " nie ma " + this.species + " o imieniu " + this.name);
            }
        } else {
           System.out.println("Upewniliśmy się, że handel ludźmi jest niemożliwy w Mojej aplikacji");
        }
    }

    public String toString(){
        return species + " " + name + " " + weight;
    }
}
