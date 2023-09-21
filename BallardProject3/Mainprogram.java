import java.util.Scanner;

class Car {
    // Instance variables
    private String make;         // Car make (e.g. "Subaru")
    private String model;        // Car model (e.g. "WRX" )
    private double mpg;          // The car's miles per gallon
    private double milesDriven;  // The total miles driven (odometer)
    private double fuelGallons;  // The number gallons currently in the fuel tank

    // constructor
    public Car(String carMake, String carModel, double weight) {
        make = carMake;
        model = carModel;
        mpg = (weight > 4000) ? 20 : 30;
        milesDriven = 7;
        fuelGallons = 15;
    }

    // accessor methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getMpg() {
        return mpg;
    }

    public double getMilesDriven() {
        return milesDriven;
    }

    public double getFuelGallons() {
        return fuelGallons;
    }

    // mutator methods
    public void setMilesDriven(double miles) {
        milesDriven = miles;
    }

    public void setFuelGallons(double gallons) {
        fuelGallons = gallons;
    }

    // method to calculate remaining driving range
    public double milesLeft() {
        return fuelGallons * mpg;
    }

    //method to drive the car
    public void drive(double miles) {
        double possibleMiles = milesLeft();
        if (miles <= possibleMiles) {
            milesDriven += miles;
            fuelGallons -= miles / mpg;
        } else {
            milesDriven += possibleMiles;
            fuelGallons = 0;
        }
    }

    // method to print car info
    public String toString() {
        if (fuelGallons > 0) {
            return "The " + make + " " + model + " has driven " + milesDriven + " miles and has " + String.format("%.2f", fuelGallons) + " gallons left";
        } else {
            return "The " + make + " " + model + " has driven " + milesDriven + " miles and is out of gas";
        }
    }
}

public class Mainprogram {
    //function to print info for all cars
    public static void printAllCarsInfo(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // function to drive all cars for a certain number of miles
    public static void driveAllCars(Car[] cars, double miles) {
        for (Car car : cars) {
            car.drive(miles);
        }
    }

    public static void main(String[] args) {
        System.out.println("Program 12");

        // create 3 cars
        Car hondaCivic = new Car("Honda", "Civic", 3000);
        Car toyotaCamry = new Car("Toyota", "Camry", 3400);
        Car fordF150 = new Car("Ford", "F-150", 5000);

        // drive each car 10 miles home
        driveAllCars(new Car[]{hondaCivic, toyotaCamry, fordF150}, 10);

        // print the current info of each car
        printAllCarsInfo(new Car[]{hondaCivic, toyotaCamry, fordF150});

        // add 5 gallons of gas to the Camry using accessor and mutator
        toyotaCamry.setFuelGallons(toyotaCamry.getFuelGallons() + 5);

        // take a road trip with the cars
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many miles is your road trip? ");
        double roadTripMiles = scanner.nextDouble();
        scanner.close();

        driveAllCars(new Car[]{hondaCivic, toyotaCamry, fordF150}, roadTripMiles);

        // print the ending info of each car
        printAllCarsInfo(new Car[]{hondaCivic, toyotaCamry, fordF150});
    }
}