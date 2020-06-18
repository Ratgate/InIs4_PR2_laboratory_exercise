package com.company;

import java.io.File;

public class Animal {
    final public String species;
    public String name;
    File pic;

    private Double weight;

    public Animal(String species) {
        this.species = species;
    }


    void feed(){
        System.out.println("Animal " + this.name + " has been fed");
    }

    void takeForAWalk(){
        System.out.println("Animal " + this.name + " has been taken for a walk");
    }

    void playWith(){
        System.out.println("Animal " + this.name + " has been played with");
    }
}
