package carrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private final List<Car> cars;
    private final List<Customer> customers;
    private final List<Rental> rentals;

    public RentalAgency() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Rental rentCar(String carId, String customerId, int days) {
        Car selectedCar = null;
        Customer selectedCustomer = null;

        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCar != null && selectedCustomer != null) {
            selectedCar.rentCar();
            Rental rental = new Rental(selectedCar, selectedCustomer, days);
            rentals.add(rental);
            return rental;
        }

        return null;
    }

    public void returnCar(String carId) {
        for (Rental rental : rentals) {
            if (rental.getCar().getCarId().equals(carId)) {
                rental.getCar().returnCar();
                break;
            }
        }
    }
}