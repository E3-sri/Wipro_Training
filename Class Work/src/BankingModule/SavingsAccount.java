package BankingModule;

public class SavingsAccount extends BankAccount
{
	public SavingsAccount(String accountNumber, String holderName, double balance)
	{
        super(accountNumber, holderName, balance);
    }
	
	
	public void deposit(int amount)
	{
		System.out.println("Initial Balance:"+balance);
        balance += amount;
        System.out.println("Deposited: Rs" + amount);
    }
	
	public void withdrawl(int amount)
	{
        if (balance - amount >= 500)
        {
        	System.out.println("Initial Balance:"+balance);
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        } 
        else
        {
            System.out.println("Insufficient balance. Minimum Rs.500 must be maintained.");
        }
    }
	public void showBalance()
	{
        System.out.println("Savings Account Balance: Rs" + balance);
    }
	
	
	

}
