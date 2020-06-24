package com.company;

import creatures.Animal;
import creatures.Human;
import creatures.Pet;
import devices.*;



public class Main {

    public static void main(String[] args) throws Exception {
        Human me = new Human("Captain", "Peppers", 10 );
        System.out.println(me.toString());

        me.addCar(new LPG("Sedan", "Fist", 2000.0d, 1920));
        me.addCar(new LPG("Cheap", "Wagenmachen", 3200.0d, 2013));
        me.addCar(new Diesel("Affordable", "Panstraad", 18000.0d, 1999));
        me.addCar(new Electric("Ultraspensive", "Warcod", 80000.0d, 2011));
        me.setPhone(new Phone("Apple", "OPv3",14.0f, "IOS"));
        me.cash = 5000.0d;
        me.setSalary(3500.0d);

        Car sampleCar = new Electric("Sedan", "OverpricedMotorsCompany", 12000.0d, 2002);

        Human myWife = new Human("Yatra", "Aletroch");
        myWife.addCar(sampleCar);
        myWife.addCar(sampleCar);
        myWife.removeCar(myWife.getCar(1));
        System.out.println("Wartość samochodów myWife = " + myWife.garageValue());

        myWife.setSalary(4200.0d);
        myWife.cash = 8000.0d;

        System.out.println();

        System.out.println(me.toString());
        me.sortGarageByAgeAscending();
        System.out.println(me.toString());

        System.out.println();

        System.out.println(myWife.toString());
        myWife.sortGarageByAgeAscending();
        System.out.println(myWife.toString());

        System.out.println();

        System.out.println(myWife.getCar(0).toString());
        myWife.setCar(new LPG("Combi", "Ursus", 14500.0d, 2019), 1);
        System.out.println(myWife.getCar(1).toString());

        System.out.println(me.toString());
        System.out.println(myWife.toString());

        me.getCar(0).sell(me, myWife, 4000.0d);
        System.out.println(me.toString());
        System.out.println(myWife.toString());
        }
}
