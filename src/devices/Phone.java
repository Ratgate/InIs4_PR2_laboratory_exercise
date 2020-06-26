package devices;

import creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Phone extends Device {
    static final String DEFAULT_APPLICATIONS_SERVER = "http://defaultCity.com";
    static final String DEFAULT_APPLICATIONS_PROTOCOL = "https";
    static final String DEFAULT_APPLICATIONS_VERSION = "latest";
    final Float screenSize;
    final String os;
    public Human owner;
    public ArrayList<Application> appList = new ArrayList<>();


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

    public void installAnApp(Application app){
        if(this.owner.cash >= app.price){
            this.appList.add(app);
            this.owner.cash -= app.price;
        }
    }

    public Boolean isInstalled(Application questionedApp){
        for (Application app : this.appList) {
            if(questionedApp.name.equals(app.name) & questionedApp.version.equals(app.version)){
                return true;
            }
        }
        return false;
    }

    public Boolean isInstalled(String questionedName){
        for (Application app : this.appList) {
            if(app.name.equals(questionedName)){
                return true;
            }
        }
        return false;
    }

    public void printFreeApps() throws Exception {
        for (Application app : this.appList) {
            if(app.price != null){
                if(app.price == 0){
                    System.out.println(app.toString());
                }
            } else {
                throw new Exception(app.toString() + " cena jest nullem");
            }
        }
    }

    public Double appValue(){
        double value = 0.0d;
        for (Application app : this.appList) {
            if(app.price != null){
                value += app.price;
            }
        }
        return value;
    }

    public void sortAppsByName(){
        ArrayList<Application> sortedList = new ArrayList<>(this.appList);
        Comparator<Application> comp = Comparator.comparing(Application::getName);
        sortedList.sort(comp);
        System.out.println(sortedList);
    }

    public void sortByPrice(){
        ArrayList<Application> sortedList = new ArrayList<>(this.appList);
        Comparator<Application> comp = Comparator.comparing(Application::getPrice);
        sortedList.sort(comp);
        System.out.println(sortedList);
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
