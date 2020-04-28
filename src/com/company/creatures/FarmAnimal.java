package com.company.creatures;

import com.company.Ediable;

public class FarmAnimal extends Animal implements Ediable {


    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        this.isAlive = false;
    }
}
