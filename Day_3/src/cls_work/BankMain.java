package cls_work;

public class BankMain {

	public static void main(String[] args) {
		BankAccount b=new BankAccount(15000);
		System.out.println("Present Balance"+b.getBalance());
		b.deposit(1500);
		System.out.println("Balance After first Deposit:"+b.getBalance());
		b.withdraw(500);
		System.out.println("Balance after withdrawl:"+b.getBalance());
		b.withdraw(17000);
		
	}

}
