import java.util.Scanner;

class Car {
    // Instance variables
    String make;         // Car make (e.g. "Subaru")
    String model;        // Car model (e.g. "WRX" )
    double mpg;          // The car's miles per gallon
    double milesDriven;  // The total miles driven (odometer)
    double fuelGallons;  // The number gallons currently in the fuel tank

    // constructor
    public Car(String carMake, String carModel, double weight) {
        make = carMake;
        model = carModel;
        mpg = (weight > 4000) ? 20 : 30;
        milesDriven = 7;
        fuelGallons = 15;
    }

    // method to add fuel to the car
    public void addFuel(double gallons) {
        fuelGallons += gallons;
    }

    //method to calculate remaining driving range
    public double milesLeft() {
        return fuelGallons * mpg;
    }

    // method to drive the car
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
    public void printInfo() {
        if (fuelGallons > 0) {
            System.out.printf("The %s %s has driven %.1f miles and has %.2f gallons left\n", make, model, milesDriven, fuelGallons);
        } else {
            System.out.printf("The %s %s has driven %.1f miles and is out of gas\n", make, model, milesDriven);
        }
    }
}

public class Ballard12 {
    public static void main(String[] args) {
        System.out.println("Program 12");

        // create 3 cars
        Car hondaCivic = new Car("Honda", "Civic", 3000);
        Car toyotaCamry = new Car("Toyota", "Camry", 3400);
        Car fordF150 = new Car("Ford", "F-150", 5000);

        // drive each car 10 miles home
        hondaCivic.drive(10);
        toyotaCamry.drive(10);
        fordF150.drive(10);

        // rint the current info of each car
        hondaCivic.printInfo();
        toyotaCamry.printInfo();
        fordF150.printInfo();

        // add 5 gallons of gas to the Camry
        toyotaCamry.addFuel(5);

        //  how many miles road trip with the cars
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many miles is your road trip? ");
        double roadTripMiles = scanner.nextDouble();
        scanner.close();

        hondaCivic.drive(roadTripMiles);
        toyotaCamry.drive(roadTripMiles);
        fordF150.drive(roadTripMiles);

        // print the ending info of each car
        hondaCivic.printInfo();
        toyotaCamry.printInfo();
        fordF150.printInfo();
    }
}