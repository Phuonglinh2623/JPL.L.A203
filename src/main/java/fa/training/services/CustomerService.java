package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerService {
    private Scanner scanner = new Scanner(System.in);
    private List<Customer> customers = new ArrayList<>();

    public List<String> createCustomer() {
        while (true) {
            System.out.println("----Enter Customer information--");

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            String phone;
            do {
                System.out.print("Enter phone: ");
                phone = scanner.nextLine();
            } while (!Validator.isValidPhoneNumber(phone));

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            List<Order> orders = new OrderService().inputOrders();

            customers.add(new Customer(name, phone, address, orders));

            System.out.print("Continue? (n/N to stop): ");
            String choice = scanner.nextLine();
            if ("n".equalsIgnoreCase(choice)) {
                break;
            }
        }

        List<String> result = new ArrayList<>();
        for (Customer c : customers) {
            result.add(c.toString());
        }
        return result;
    }

    public String save(List<String> customerStrings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_NAME))) {
            for (String s : customerStrings) {
                writer.write(s);
                writer.newLine();
            }
            return "Saved successfully.";
        } catch (IOException e) {
            return "Error while saving: " + e.getMessage();
        }
    }

    public List<String> findAll() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
        return list;
    }

    public void display(List<String> customers) {
        System.out.printf("%-20s%-20s%-15s%-20s%n", "Customer Name", "Address", "Phone Number", "OrderList");
        for (String s : customers) {
            System.out.println(s);
        }
    }

    public List<String> search(String phone) {
        List<String> result = new ArrayList<>();
        List<String> all = findAll();
        for (String line : all) {
            if (line.contains(phone)) {
                result.add(line);
            }
        }
        return result;
    }

    public boolean remove(String phone) {
        List<String> all = findAll();
        boolean removed = all.removeIf(line -> line.contains(phone));
        if (removed) {
            save(all);
        }
        return removed;
    }
}
