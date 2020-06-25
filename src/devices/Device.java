package devices;

import creatures.Human;


abstract public class Device {
    public String model;
    public String producer;
    public Integer yearOfProduction;
    public Double value;


    public abstract void sell(Human seller, Human buyer, Double price) throws Exception;

    abstract void turnOn();

    public String toString(){
        return model + " " + producer + " " + yearOfProduction;
    }

}
