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

        System.out.println("Liczba tranzakcji dla pewnego auta: " + me.getCar(0).numberOfOwnerChanges());
        me.getCar(0).sell(me, myWife, 4000.0d);
        System.out.println("Liczba tranzakcji dla pewnego auta: " + myWife.getCar(2).numberOfOwnerChanges());


        System.out.println(me.toString());
        System.out.println(myWife.toString());

        System.out.println(myWife.getGarage()[2].ownerList);
        System.out.println(myWife.getGarage()[2].lastOwner());
        System.out.println("Czy mi posiadał? (powinno być true): " + myWife.getGarage()[2].wasOwner(me));
        System.out.println("Czy mi posiadał? (powinno być false): " + myWife.getGarage()[1].wasOwner(me));
        System.out.println("Czy me sprzedał myWife samochód 2? (powinno być true): " + myWife.getGarage()[2].hasSold(me,myWife));
        System.out.println("Czy me sprzedał myWife samochód 2? (powinno być false): " + myWife.getGarage()[2].hasSold(myWife, me));


    }
}
