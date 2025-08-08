package clas_work;
import java.util.Scanner;

//This is a user-defined checked exception, so it needs to be declared using throws.
class InsufficientBalanceException extends Exception
{
	public InsufficientBalanceException(String Message)
	{
		super(Message);
	}
}
class PaymentProcess
{
	private double balance;
	public PaymentProcess(double balance)
	{
		this.balance=balance;
	}
	
	public void processPayment(double amount) throws InsufficientBalanceException
	{
		if(amount<=0)
		{
			throw new IllegalArgumentException("Amount should be Positive");
	
		}
		else if(amount>balance)
		{
			throw new InsufficientBalanceException("No Enough Balance.Transaction declined.");
		}
		else
		{
			balance=balance-amount;
			System.out.println("payment of Rs: "+amount +" Successful. Remaining Balance: Rs"+balance);
		}
	}
		
		public double getBalance()
		{
			return balance;
		}
	}
public class ExceptionHandling
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		PaymentProcess  pc=new PaymentProcess(1000);
		
		 try {
	            System.out.print("Enter amount to pay: ");
	            double amount = sc.nextDouble();
	            pc.processPayment(amount);
		
	          }
		 catch(Exception e)
		 {
		            System.out.println("An unexpected error occurred: " + e.getMessage());
		 }
		 finally
		 {
	            System.out.println("Thank you. Have a nice day!");
	            sc.close(); 
		 }
		 	
}
}
