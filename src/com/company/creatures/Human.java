package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    public double cash;
    public Animal pet;

    protected Phone mobile;

    private static final Integer MAX_GARAGE_SIZE = 5;
    private Double salary = 1500.0d;
    public Car[] garage;


    public Human() {
        super("Homo sapient");
        this.garage = new Car[MAX_GARAGE_SIZE];
    }

    public Human(Integer maxGarageSize){
        super("Homo sapient");
        this.garage = new Car[maxGarageSize];
    }

    public Double getSalary() {
        return salary;
    }

    public Car getCar(Integer number){
        return this.garage[number+1];
    }

    public void setCar(Car car, Integer number){
        this.garage[number] = car;
    }


    public void riseMySalary(double rise){
        salary += rise;
    }

    public void canAffordThatCar(Car car) throws Exception {
        if(car.value < this.salary * 12 ){
            this.setOfWheels = car;
        } else{
            throw new Exception("Wybacz stary, nie stać cię");
        }
    }

    public void feed(){
        feed(1.0d);
    }

    public void feed(Double foodWeight)
    {
            System.out.println("Człowiek zjadł, lecz nie waży więc nie tyje.");
    }

    public String toString(){
        return this.firstName + " " + this.lastName;
    }

    public double allCarsValue(){
        double value = 0;
        for(Integer i = 0; i < this.garage.length; i++){
            value += this.garage[i].value;
        }
        return value;
    }

    public void sortCarsByYearAscending(){
        Arrays.sort(this.garage);
    }
}
