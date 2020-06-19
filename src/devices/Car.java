package devices;

public class Car extends Device{
    public Integer numberOfDoors;
    public Float maxSpeed;
    public Double value;


    public Car(String model, String producer, Double value) {
        this.model = model;
        this.producer = producer;
        this.value = value;
    }

    public String toString(){
        return model + " " + producer + " " + numberOfDoors + " " + maxSpeed + " " + value;
    }

    @Override
    public void turnOn() {
        System.out.println("Car has been turned on");
    }
}
