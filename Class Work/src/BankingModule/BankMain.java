package BankingModule;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a Savings Account
        BankAccount acc1 = new SavingsAccount("SA127", "Hymavathi", 1000);
        acc1.showAccountDetails();
        acc1.deposit(2000);
        acc1.withdrawl(3000);
        acc1.showBalance();

        System.out.println("\n----------------------\n");

        // Create a Current Account
        BankAccount acc2 = new CurrentAccount("CA456", "Sree Chaturvedula", 5000);
        acc2.showAccountDetails();
        acc2.deposit(1000);
        acc2.withdrawl(7000); // Should fail
        acc2.showBalance();

        sc.close();
    }
}

