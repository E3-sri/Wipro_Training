package BankingModule;
public class CurrentAccount extends BankAccount 
{

    public CurrentAccount(String accountNumber, String holderName, double balance)
    {
        super(accountNumber, holderName, balance);
        
    }
    
    public void deposit(int amount)
    {
        balance += amount;
        System.out.println("Deposited: Rs" + amount);
    }
    
    public void withdrawl(int amount)
    {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        }
        else
        {
            System.out.println("Insufficient Balance.");
        }
    }
    
    public void showBalance()
    {
        System.out.println("Current Account Balance: Rs" + balance);
    }
    
}
  
