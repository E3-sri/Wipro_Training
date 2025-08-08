package WT;
import java.util.Scanner;
public class chatbot {
	void show(String Message)
	{
		if(Message.isEmpty())
		{
			System.out.println("Thank you For reaching Me");
		}
		
	}
	public static void main(String[] args) {
		//int max_attempts=3;
		Scanner sc=new Scanner(System.in);
		System.out.println("How May I help You?");
		String Message=sc.nextLine();
		
		chatbot bot=new chatbot();
		bot.show(Message);
		sc.close();
	}
}
