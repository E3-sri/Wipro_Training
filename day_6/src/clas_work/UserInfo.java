package clas_work;
class UserInfo
{
   private String accType;
    private int pin;
    private double balance;

    public UserInfo( String accType , int pin, double balance)
    {
        this.accType = accType;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccType()
    {
        return accType;
    }
    public double getBalance()
    {
        return balance;
    }
    
    public void deposit(double amount)
    {
        balance += amount;
    }

    public boolean validatePin(int inputPin)
    {
        return this.pin == inputPin;
    }
   

    public void withdraw(double amount) throws InsufficientBalanceException
    {
        if (amount > balance)
        {
            throw new InsufficientBalanceException("No enough balance.");
        }
        else
        {
        	balance -= amount;
        }
       
    }
        
  }