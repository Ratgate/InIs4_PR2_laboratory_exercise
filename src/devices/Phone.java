package devices;

import java.sql.SQLOutput;

public class Phone {
    final public String producer;
    final String model;
    final Float screenSize;
    final String os;


    public Phone(String producer, String model, Float screenSize, String os) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.os = os;
    }


    void turnOn(){
        System.out.println("Phone has been turned on");
    }

    void mute(){
        System.out.println("Phone has been muted");
    }

    void installAnApp(){
        System.out.println("App has been installed on the phone");
    }

    public String toString(){
        return producer + " " + model + " " + screenSize + " " + os;
    }
}
