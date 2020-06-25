package creatures;

import devices.Car;
import devices.CarTransaction;
import devices.Phone;

import java.util.Arrays;

public class Human {
    static final Integer DEFAULT_GARAGE_SIZE = 5;
    public String firstName;
    public String lastName;
    public Animal pet;
    public Double cash = 0.0d;

    private Car[] garage;
    private Double salary = 0.0d;
    protected Phone phone;


    public Human(String firstName, String lastName) {
        this(firstName, lastName, DEFAULT_GARAGE_SIZE);
    }

    public Human(String firstName, String lastName, Integer garageMAxSize) {
            this.firstName = firstName;
            this.lastName = lastName;
        this.garage = new Car[garageMAxSize];
    }

    public Car[] getGarage() {
        return this.garage;
    }

    public Double getSalary() {
    //    System.out.println("Dane o wypłacie na dzień: " + java.time.LocalDate.now() + " o godzinie " + java.time.LocalTime.now()  + "\n" + "Wypłata wynosi " + this.salary);
        return salary;
    }

    public Car getCar(Integer number) throws Exception {
        try {
            return this.garage[number];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                throw new Exception("Albo wyszliśmy poza rozmiar garażu albo nie ma samochodu na tym miejscu");
            }
        }

    public void setSalary(Double newSalary){
        if(newSalary >= 0){
          //  System.out.println("Nowe dane zostały wysłane do systemu księgowego");
          //  System.out.println("Konieczne jest odebranie aneksu do umowy od pani Hani z kadr");
          //  System.out.println("ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu");
            this.salary = newSalary;
        } else {
            System.out.println("Niemożliwe jest podwyższenie pensji o niedodatnią kwotę ");
        }
    }

    public void setCar(Car car, Integer target, CarTransaction transaction){
        this.garage[target] = car;
        car.addTransaction(transaction);
    }
    public void addCar(Car newCar) throws Exception {
        this.addCar (newCar, new CarTransaction(this, null, newCar.value, java.time.LocalDate.now()));
    }

    public void addCar (Car newCar, CarTransaction transaction) throws Exception {
        boolean success = false;
        for (int i = 0; i < garage.length; i++) {
            if(garage[i] == null){
                this.setCar(newCar, i, transaction);
                success = true;
                break;
            }
        }
        if(!success){
            throw new Exception("Nie można dodać samochodu przez addCar");
        }
    }

    public void removeCar(Car carToRemove) throws Exception {
        boolean removed = false;
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] == carToRemove){
                this.garage[i] = null;
                removed = true;
                break;
            }
        }
        if (!removed){
            throw new Exception("Nie ma samochodu do usunięcia");
        }
    }

    public Boolean havePlaceInGarage(){
        for (Car car : this.garage) {
            if (car == null) {
                return true;
            }
        }
        return false;
    }

    public Boolean haveCar(Car questionedCar){
        for (Car car : this.garage) {
            if(car == questionedCar){
                return true;
            }
        }
        return false;
    }

    public void buyCar(Car car) throws Exception {
            if(this.havePlaceInGarage()){
                if(this.cash > car.value){
                    System.out.println("Udało się kupić samochód");
                    this.cash -= car.value;
                    this.addCar(car, new CarTransaction(this, null, car.value, java.time.LocalDate.now()));
                } else {
                    System.out.println("Info w stylu \"zapisz się na studia i znajdź nową robotę albo idź po podwyżkę\"");
                }
            } else {
                System.out.println(this.firstName + " " + this.lastName + " nie ma miejsca w garażu");
            }
    }

    public Phone getPhone(){
        return phone;
    }

    public void setPhone(Phone phone){
        this.phone = phone;
    }

    public Double garageValue(){
        Double result = 0.0d;
        for (Car car : this.garage) {
            if (car != null) {
                result += car.value;
            }
        }
        return result;
    }

    public void sortGarageByAgeAscending(){
        int oldest;
        Car temp;
        boolean swapped;
        for(int i = 0; i < garage.length - 1; i++){
            oldest = i;
            swapped = false;
            for(int j = i + 1; j < garage.length; j++){
                if(this.garage[oldest] != null){
                    if(this.garage[oldest].yearOfProduction != null){
                        // full
                        if(this.garage[j] != null){
                            if(this.garage[j]. yearOfProduction != null){
                                if(this.garage[j].yearOfProduction < this.garage[oldest].yearOfProduction){
                                    oldest = j;
                                    swapped = true;
                                }
                            }
                        }
                    } else {
                        // cull
                        if(this.garage[j] != null){
                            if(this.garage[j]. yearOfProduction != null){
                                oldest = j;
                                swapped = true;
                            }
                        }
                    }
                } else {
                    // null
                    if(this.garage[j] != null){
                        if(this.garage[j]. yearOfProduction != null){
                            oldest = j;
                            swapped = true;
                        } else {
                            oldest = j;
                            swapped = true;
                        }
                    }
                }
            }
            if(swapped){
                temp = this.garage[i];
                this.garage[i] = this.garage[oldest];
                this.garage[oldest] = temp;
            }
        }
    }

    public String toString(){
        return firstName + " " + lastName + " " + this.cash  + " " + this.getSalary() + " " + phone + " Human{" + "garage=" + Arrays.toString(garage) + '}' + " Wartość garażu me " + this.garageValue();
    }
}