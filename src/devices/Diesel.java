package devices;

public class Diesel extends Car {
    public Diesel(String model, String producer, Double value, Integer yearOfProduction) {
        super(model, producer, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Diesel has been redieseled");
    }
}
