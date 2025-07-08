package fa.training.entities;

import java.util.List;

public class Customer {
    private String name;
    private String phoneNumber;
    private String address;
    private List<Order> orders;

    public Customer() {}

    public Customer(String name, String phoneNumber, String address, List<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }

    // Getters and setters
}
