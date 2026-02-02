package carrentalsystem;

public class Rental {
    private final Car car;
    private final Customer customer;
    private final int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public double calculateCost() {
        return car.getPricePerDay() * days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }
}