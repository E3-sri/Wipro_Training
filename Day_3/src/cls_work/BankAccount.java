package cls_work;

public class BankAccount
{
	
	private double balance;
	
	public BankAccount(double Pre_Balance)
	{
		if(Pre_Balance>=0)
		{
			this.balance=balance;
		}
	}
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit (double amount)
	{
		if(amount>0)
		{
			balance+=amount;
			System.out.println("Amount Deposited:"+amount);
		}
		else
		{
			System.out.println("Invalid Deposit amount");
		}
	}
	public void withdraw(double amount)
	{
		if(amount>0 && amount<=balance)
		{
			balance=balance-amount;
			System.out.println("Withdraw Successful:"+amount);
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}

}
