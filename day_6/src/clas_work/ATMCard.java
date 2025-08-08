package clas_work;
import java.util.Scanner;

	public class ATMCard {
	    private String CorrectPin = "1234";
	    private double balance = 5000.0; 
	    
	    public void checkPin(String enteredPin) throws Exception {
	        if (enteredPin == null) {
	            throw new Exception("PIN cannot be empty");
	        }
	        
	        if (!enteredPin.equals(CorrectPin)) {
	            throw new Exception("Invalid PIN Entered");
	        }
	        
	        System.out.println("PIN is correct! Access granted.");
	    }
	    
	    public void withdraw(double amount) throws Exception {
	        if (amount <= 0) {
	            throw new Exception("Invalid withdrawal amount");
	        }
	        
	        if (amount > balance) {
	            throw new Exception("Insufficient balance");
	        }
	        
	        balance = balance - amount;
	        System.out.println("Withdrawal successful!");
	        System.out.println("\nAmount withdrawn: Rs." + amount);
	        System.out.println("Remaining balance: Rs." + balance);
	    }
	    
	    public void deposit(double amount) throws Exception {
	        if (amount <= 0) {
	            throw new Exception("Invalid deposit amount");
	        }
	        
	        balance = balance + amount;
	        System.out.println("Deposit successful!");
	        System.out.println("Amount deposited: Rs." + amount);
	        System.out.println("New balance: Rs." + balance);
	    }
	    
	    public void checkBalance() {
	        System.out.println("Current balance: Rs." + balance);
	    }
	    
	    public final void removeCard() {
	        System.out.println("\nATM Card removed safely!");
	        System.out.println("Thank you for using ATM service.");
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ATMCard card = new ATMCard();
	        
	        try {
	            System.out.print("Enter your PIN: ");
	            String pin = scanner.nextLine();
	            card.checkPin(pin);
	            
	            System.out.println("\n ACCOUNT OPTIONS");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Withdraw Money");
	            System.out.println("3. Deposit Money");
	            System.out.print("\nChoose option: ");
	            
	            int choice = scanner.nextInt();
	            
	            if (choice == 1) {
	                card.checkBalance();
	                
	            } else if (choice == 2) {
	                System.out.print("Enter withdrawal amount: Rs.");
	                double amount = scanner.nextDouble();
	                card.withdraw(amount);
	                
	            } else if (choice == 3) {
	                System.out.print("Enter deposit amount: Rs.");
	                double amount = scanner.nextDouble();
	                card.deposit(amount);
	                
	            } else {
	                throw new Exception("Invalid menu option");
	            }
	            
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	            
	        } finally {
	            card.removeCard();
	            scanner.close();
	            System.out.println("Session ended.");
	        }
	    }
	}
	

	