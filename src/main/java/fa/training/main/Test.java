package fa.training.main;

import fa.training.services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService service = new CustomerService();

        int choice;
        do {
            System.out.println("Choose function:");
            System.out.println("1. Add a new Customer");
            System.out.println("2. Show all Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    List<String> created = service.createCustomer();
                    System.out.println(service.save(created));
                    break;
                case 2:
                    List<String> all = service.findAll();
                    service.display(all);
                    break;
                case 3:
                    System.out.print("Enter phone to search: ");
                    String searchPhone = scanner.nextLine();
                    List<String> found = service.search(searchPhone);
                    service.display(found);
                    break;
                case 4:
                    System.out.print("Enter phone to remove: ");
                    String removePhone = scanner.nextLine();
                    boolean removed = service.remove(removePhone);
                    if (removed) {
                        System.out.println("Customer removed successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose from 1 to 5.");
            }

            System.out.println(); 
        } while (choice != 5);

        scanner.close();
    }
}
