package devices;

public class LPG extends Car {
    public LPG(String model, String producer, Double value, Integer yearOfProduction) {
        super(model, producer, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Once more pure liquid petroleum gas flows through this LPG veins");
    }
}
