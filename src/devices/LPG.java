package devices;

public class LPG extends Car {
    public LPG(String model, String producer, Double value) {
        super(model, producer, value);
    }

    @Override
    public void refuel() {
        System.out.println("Once more pure liquid petroleum gas flows through this LPG veins");
    }
}
