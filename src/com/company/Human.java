package com.company;

import com.company.devices.Phone;

public class Human extends  Animal{
    public String firstName;
    public String lastName;
    protected Phone mobile;
    public Animal pet;
    private Double salary = 1500.0d;
    private Car setOfWheels;

    public Human() {
        super("Homo sapient");
    }

    public Double getSalary() {
        return salary;
    }

    public Car getCar(){
        return setOfWheels;
    }

    public void setCar(Car car){
        this.setOfWheels = car;
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

    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
