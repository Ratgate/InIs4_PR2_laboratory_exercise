package devices;

import com.company.Human;

import java.util.Date;

abstract public class Device {
    public String model;
    public String producer;
    public Date yearOfProduction;


    public abstract void sell(Human seller, Human buyer, Double price);

    abstract void turnOn();

    public String toString(){
        return model + " " + producer + " " + yearOfProduction;
    }
}
