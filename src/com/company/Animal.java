package com.company;

import java.io.File;

public class Animal {
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

    public String toString(){
        return species + " " + name + " " + weight;
    }
}
