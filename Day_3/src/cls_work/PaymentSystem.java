package cls_work;

public abstract class PaymentSystem 
{
	abstract void Pay(int amount);
	
}
class CreditCardPayment extends PaymentSystem
{
	void Pay(int amount)
	{
		System.out.println(" Paid "+amount+" Using CreditCard");
	}
}
class UPIPayment extends PaymentSystem
{
	void Pay(int amount)
	{
		System.out.println(" Paid "+amount+" Through UPI");
	}
}
class NetBanking extends PaymentSystem
{
	void Pay(int amount)
	{
		System.out.println(" Paid "+amount+" Using NetBanking");
	}
}
