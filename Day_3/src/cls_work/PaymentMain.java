package cls_work;
import java.util.Scanner;
public class PaymentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount which you want to pay with UPI:");
		int amount1=sc.nextInt();
		System.out.println("Enter amount which you want to pay with CreditCard:");
		int amount2=sc.nextInt();
		System.out.println("Enter amount which you want to pay with NetBanking:");
		int amount3=sc.nextInt();

		PaymentSystem UPS=new UPIPayment();
		
		PaymentSystem CPS=new CreditCardPayment();
		PaymentSystem NPS=new NetBanking();
		UPS.Pay(amount1);
		CPS.Pay(amount2);
		NPS.Pay(amount3);	
		sc.close();

	}

}
