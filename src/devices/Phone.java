package devices;

import creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;

public class Phone extends Device {
    static final String DEFAULT_APPLICATIONS_SERVER = "http://defaultCity.com";
    static final String DEFAULT_APPLICATIONS_PROTOCOL = "https";
    static final String DEFAULT_APPLICATIONS_VERSION = "latest";
    final Float screenSize;
    final String os;


    public Phone(String producer, String model, Float screenSize, String os) {
        this.screenSize = screenSize;
        this.os = os;
    }


    @Override
    public void turnOn(){
        System.out.println("Phone has been turned on");
    }

    void mute(){
        System.out.println("Phone has been muted");
    }

    void installAnApp(){
        System.out.println("App has been installed on the phone");
    }

    void installAnnApp(String name){
        installAnnApp(name, DEFAULT_APPLICATIONS_VERSION);
    }

    void installAnnApp(String name, String version){
        installAnnApp(name, version, DEFAULT_APPLICATIONS_SERVER);
    }

    void installAnnApp(String name, String version, String address){
        URL url = null;
        try {
            url = new URL(DEFAULT_APPLICATIONS_PROTOCOL, DEFAULT_APPLICATIONS_SERVER, 433, name + "ver." + version);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        installAnnApp(url);
    }

    void installAnnApp(String[] namesList){
        for (String name : namesList) {
            installAnnApp(name);
        }
    }

    void installAnnApp(URL url){
        try{
            System.out.println("Zainstalowano " + url.getFile());
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        try {
            if (seller.getPhone().equals(this)) {
                if (buyer.cash >= price) {
                    buyer.cash -= price;
                    seller.cash += price;
                    buyer.setPhone(this);
                    seller.setPhone(null);
                    System.out.println(buyer.firstName + " " + buyer.lastName + " kupił " + this.model  + " od " + seller.firstName + " " + seller.lastName + " za " + price);
                } else {
                    System.out.println(buyer.firstName + " " + buyer.lastName + " nie stać by zapłacić " + price);
                }
            } else {
                System.out.println(seller.firstName + " " + seller.lastName + "nie ma wskazanego " + this.model);
            }
        } catch (NullPointerException e){
            System.out.println(seller.firstName + " " + seller.lastName + " nie ma oczekiwanego telefonu o modelu " + this.model);
        }
    }

    public String toString(){
        return producer + " " + model + " " + screenSize + " " + os;
    }
}
