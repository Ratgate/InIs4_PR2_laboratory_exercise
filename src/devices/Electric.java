package devices;

public class Electric extends Car {
    public Electric(String model, String producer, Double value, Integer yearOfProduction) {
        super(model, producer, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Electric's batteries has been recharged");
    }
}
