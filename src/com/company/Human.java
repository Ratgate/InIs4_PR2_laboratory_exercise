package com.company;

import devices.Car;
import devices.Phone;

public class Human {
    public String firstName;
    public String lastName;
    public Animal pet;
    private Car car;

    private Double salary = 0.0d;
    protected Phone phone;

    public Double getSalary() {
        System.out.println("Dane o wypłacie na dzień: " + java.time.LocalDate.now() + " o godzinie " + java.time.LocalTime.now()  + "\n" + "Wypłata wynosi " + this.salary);
        return salary;
    }

    public void setSalary(Double newSalary){
        if(newSalary >= 0){
            System.out.println("Nowe dane zostały wysłane do systemu księgowego");
            System.out.println("Konieczne jest odebranie aneksu do umowy od pani Hani z kadr");
            System.out.println("ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu");
            this.salary = newSalary;
        } else {
            System.out.println("Niemożliwe jest podwyższenie pensji o niedodatnią kwotę ");
        }
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if(this.salary > car.value){
            System.out.println("Udało się kupić samochód za gotówkę");
            this.car = car;
        } else if(this.salary > car.value/12){
            System.out.println("Udało się kupić samochód na kredyt");
            this.car = car;
        } else {
            System.out.println("Info w stylu \"zapisz się na studia i znajdź nową robotę albo idź po podwyżkę\"");
        }
    }

    public String toString(){
        return firstName + " " + lastName + " " + pet + " " + this.getCar() + " " + this.getSalary() + " " + phone;
    }
}
