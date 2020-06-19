package devices;

public class Car {
    final public String model;
    final public String producer;
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
}
