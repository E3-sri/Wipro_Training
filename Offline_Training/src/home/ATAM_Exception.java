package home;

import java.util.Scanner;

// Custom Exception for Invalid PIN
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

// ATM class
class ATM {
    private final int valid_pin = 1234;

    public void validatePin(int entered_pin) throws InvalidPinException {
        if (entered_pin != valid_pin) {
            throw new InvalidPinException("Invalid PIN Entered. Please Try Again.");
        } else {
            System.out.println("PIN validated successfully. Access granted.");
        }
    }
}

// Main Class
public class ATAM_Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            System.out.println("Insert Your ATM Card.....");
            System.out.print("Enter your 4-digit PIN: ");
            int user_pin = sc.nextInt();

            atm.validatePin(user_pin);

            System.out.println("PIN Verified! Access Granted.");
            System.out.println("You can proceed with withdrawal or other options.");

        } catch (InvalidPinException e) {
            System.out.println("Access Denied: " + e.getMessage());
        } finally {
            System.out.println("Transaction Time Out. Please remove your card.");
            sc.close();
        }
    }
}
