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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(name).append("\n")
        .append("Phone Number: ").append(phoneNumber).append("\n")
        .append("Address: ").append(address).append("\n")
        .append("Orders:\n");

        if (orders != null && !orders.isEmpty()) {
            for (Order order : orders) {
                sb.append("\t").append(order.toString()).append("\n");
            }
        } else {
            sb.append("\tNo orders.\n");
        }

        return sb.toString();
    }
}
