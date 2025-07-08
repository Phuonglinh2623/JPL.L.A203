package fa.training.services;

import fa.training.entities.Order;
import fa.training.utils.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderService {
    private Scanner scanner = new Scanner(System.in);

    public List<Order> inputOrders() {
        List<Order> orders = new ArrayList<>();
        while (true) {
            System.out.println("Enter order infor:");
            String number;
            do {
                System.out.print("+ number: ");
                number = scanner.nextLine();
            } while (!Validator.isValidOrderNumber(number));

            Date date = null;
            do {
                try {
                    System.out.print("+ date (dd/MM/yyyy): ");
                    String dateStr = scanner.nextLine();
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Try again.");
                }
            } while (date == null);

            orders.add(new Order(number, date));

            System.out.print("Add another order? (n/N to stop): ");
            String choice = scanner.nextLine();
            if ("n".equalsIgnoreCase(choice)) {
                break;
            }
        }
        return orders;
    }
}
