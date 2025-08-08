package clas_work;
import java.util.*;

public class ATMMachine {
    private static final int MAX_ATTEMPTS = 3;
    private static List<UserInfo> users = new ArrayList<>();

    public static void main(String[] args)
    {
        initializeUsers();
        Scanner sc = new Scanner(System.in);

        try {
        	System.out.println("*****Welcome To ATM******");
        	System.out.println("Choose Your account Type:");
           
            String accType = sc.nextLine().toLowerCase();

            UserInfo currentUser = findUserByAccount(accType);

            if (currentUser == null)
            {
                System.out.println("Account not found.");
                return;
            }

            int attempts = 0;
            boolean authenticated = false;
            while (attempts < MAX_ATTEMPTS && !authenticated)
            {
            	System.out.println("Please Insert Your card");
                System.out.print("Enter PIN: ");
                int inputPin = sc.nextInt();

                if (currentUser.validatePin(inputPin)) {
                    authenticated = true;
                } 
                else 
                {
                    attempts++;
                    System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
                }
            }

            if (!authenticated) {
                throw new InvalidPinException("Too many incorrect PIN attempts.");
            }

            boolean exit = false;
            while (!exit)
            {
                System.out.println("\n1. Check Balance\n2. Withdraw\n3. Deposit\n4.Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                if(choice==1)
                {
                	 System.out.println("Balance: ₹" + currentUser.getBalance());
                }
                else if(choice==2)
                {
                	 System.out.print("Enter withdrawal amount: ");
                     double withdrawAmount = sc.nextDouble();
                     try {
                         currentUser.withdraw(withdrawAmount);
                         System.out.println("Withdrawn successfully.");
                     }
                     catch (InsufficientBalanceException e)
                     {
                         System.out.println("Error: " + e.getMessage());
                     }
                }
                else if(choice==3)
                {
                	 System.out.print("Enter deposit amount: ");
                     double depositAmount = sc.nextDouble();
                     currentUser.deposit(depositAmount);
                     System.out.println("Deposited successfully.");
                }
                else if(choice==4)
                {
                	exit = true;
                    System.out.println("Thank you!,Please remove Card");
                }
                else
                {
                	System.out.println("Invalid choice.");
                }
            }

        }
        catch (InvalidPinException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Please enter valid input.");
        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong: " + e.getMessage());
        } 
        finally 
        {
            System.out.println("Session Ended.");
            sc.close();
        }
    }

    private static void initializeUsers() {
        users.add(new UserInfo("savings", 1234, 10000));
        users.add(new UserInfo("current", 4321, 5000));
        users.add(new UserInfo("", 1111, 7500));
    }

    private static UserInfo findUserByAccount(String accType) {
        for (UserInfo user : users) {
            if (user.getAccType().equals(accType)) {
                return user;
            }
        }
        return null;
    }
}
