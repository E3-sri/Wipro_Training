package BankingModule;

public abstract class BankAccount implements BankOperations
{
	private String accountNumber;
	private String holderName;
	protected double balance;

public BankAccount(String accountNumber, String holderName, double balance)
{
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
}
public String getAccountNumber()
{
    return accountNumber;
}

public String getHolderName()
{
    return holderName;
}

public double getBalance()
{
    return balance;
}
public void showAccountDetails() 
{
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Holder Name: " + holderName);
    System.out.println("Current Balance: " + balance);
}
public abstract void deposit(int amount);
public abstract void withdrawl(int amount);
public abstract void showBalance();

}

  


















