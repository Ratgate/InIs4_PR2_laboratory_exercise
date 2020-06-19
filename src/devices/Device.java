package devices;

import java.util.Date;

abstract public class Device {
    public String model;
    public String producer;
    public Date yearOfProduction;


    public String toString(){
        return model + " " + producer + " " + yearOfProduction;
    }

    abstract void turnOn();
}
