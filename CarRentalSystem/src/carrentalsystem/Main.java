package carrentalsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RentalAgency agency = new RentalAgency();
        int choice;

        do {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return a Car");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.nextLine();

                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();

                    System.out.print("Enter Price per Day: ");
                    double price = scanner.nextDouble();

                    agency.addCar(new Car(carId, model, price));
                    System.out.println("Car added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();

                    agency.addCustomer(new Customer(customerId, name));
                    System.out.println("Customer added successfully.");
                    break;

                case 3:
                    System.out.print("Enter Car ID: ");
                    String rentCarId = scanner.nextLine();

                    System.out.print("Enter Customer ID: ");
                    String rentCustomerId = scanner.nextLine();

                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();

                    Rental rental = agency.rentCar(rentCarId, rentCustomerId, days);

                    if (rental != null) {
                        System.out.println("\n=== RENTAL SUCCESSFUL ===");
                        System.out.println("Customer: " + rental.getCustomer().getName());
                        System.out.println("Car: " + rental.getCar().getModel());
                        System.out.println("Days: " + days);
                        System.out.println("Total Cost: ksh" + rental.calculateCost());
                    } else {
                        System.out.println("Rental failed. Check IDs or availability.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Car ID to return: ");
                    String returnCarId = scanner.nextLine();
                    agency.returnCar(returnCarId);
                    System.out.println("Car returned successfully.");
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

}
