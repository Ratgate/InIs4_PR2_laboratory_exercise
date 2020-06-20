package creatures;

public class FarmAnimal extends Animal implements Edbile {


    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        this.isAlive = false;
        System.out.println(this.species + " " + this.name + " został zjedzony");
    }
}
