package com.company.devices;

import java.net.MalformedURLException;
import java.net.URL;

public class Phone extends Device {

    static final String DEFAULT_APPLICATIONS_SERVER = "http://defaultCity.com";
    static final String DEFAULT_APPLICATIONS_PROTOCOL = "https";
    static final String DEFAULT_APPLICATIONS_VERSION = "current";

    @Override
    void turnOn() {
        System.out.println("Phone is now turned on");
    }

    public void installAnnApp(String appName){
        installAnnApp(appName, DEFAULT_APPLICATIONS_VERSION);
    }

    public void installAnnApp(String appName, String version){
        installAnnApp(appName, version, DEFAULT_APPLICATIONS_SERVER);
    }

    public void installAnnApp(String appName, String version, String serverAddress){
        URL url = null;
        try {
            url = new URL(DEFAULT_APPLICATIONS_PROTOCOL, DEFAULT_APPLICATIONS_SERVER, 433, appName + "ver." + version);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        installAnnApp(url);
    }

    public void installAnnApp(String[] appNames){
        for (String appName : appNames) {
            installAnnApp(appName);
        }
    }

    public void installAnnApp(URL url){
        try{
            System.out.println("Zainstalowano " + url.getFile());
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
