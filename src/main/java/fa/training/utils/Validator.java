package fa.training.utils;

import java.util.regex.Pattern;

public class Validator {
    private static Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");
    private static Pattern ORDER_PATTERN = Pattern.compile("^\\d{10}$");

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.out.println("Phone number cannot be empty.");
            return false;
        }
        if (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
            System.out.println("Phone number must be 10 digits and start with 0.");
            return false;
        }
        return true;
    }

    public static boolean isValidOrderNumber(String orderNumber) {
        if (orderNumber == null || orderNumber.trim().isEmpty()) {
            System.out.println("Order number cannot be empty.");
            return false;
        }
        if (!ORDER_PATTERN.matcher(orderNumber).matches()) {
            System.out.println("Order number must be exactly 10 digits.");
            return false;
        }
        return true;
    }

    public static boolean isNonEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be empty.");
            return false;
        }
        return true;
    }
}
