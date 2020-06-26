package com.company;

import creatures.Human;
import devices.*;



public class Main {

    public static void main(String[] args) throws Exception {
        Human me = new Human("Captain", "Peppers", 1 );
        me.setPhone(new Phone("Apple", "OPv3",14.0f, "IOS"));
        me.cash = 5000.0d;
        me.setSalary(3500.0d);

        Application sampleApp = new Application("Instashot", "0.24601", 2.0d);

        me.getPhone().installAnApp(new Application("Hungry Beards", "0.70beta", 10.0d));
        me.getPhone().installAnApp(new Application("Tinker", "1.01b", 0.0d));
        me.getPhone().installAnApp(new Application("Non Stop Rock", "1.14", 0.0d));
        me.getPhone().installAnApp(new Application("Quran Online", "1.02", 85.0));
        me.getPhone().installAnApp(new Application("Tip-top", "1.2", 0.0d));
        me.getPhone().installAnApp(new Application("Anti-Hit Portable edition", "1.19", 20.0d));
        me.getPhone().installAnApp(new Application("Dot Weeb premium", "0.92b", 20.0d));
        me.getPhone().installAnApp(new Application("Weather", "1.01", 0.0d));
        me.getPhone().installAnApp(sampleApp);

        System.out.println(me.getPhone().appList.toString());
        System.out.println("is installed (Application)" + me.getPhone().isInstalled(sampleApp));
        System.out.println("Is installed (new Application) " + me.getPhone().isInstalled(new Application("Instashot", "0.24601", 2.0d)));
        System.out.println("Is installed (app name): " + me.getPhone().isInstalled("Tip-top"));
        me.getPhone().printFreeApps();
        System.out.println("Wartość wszystkich aplikacji w telefonie me = " + me.getPhone().appValue());
        me.getPhone().sortAppsByName();
        me.getPhone().sortByPrice();
    }
}
