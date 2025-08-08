package Cls_work;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class EmailHashset {

	public static void main(String[] args)
	{
		Set<String> uniqueEmail =new HashSet<>();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		//choice=sc.nextInt();
		
		
		while(true)
		{
			System.out.println("\n*********Email Subscription******\n");
			
			System.out.println("1.Email Address");
			System.out.println("2.Check Subscriptions List");
			System.out.println("3.Exit\n");
			System.out.println("Enter the choice:");
			choice=sc.nextInt();
			sc.nextLine();

			if(choice==1)
			{
				System.out.println("Enter email Address:");
				String email=sc.nextLine();
				if(email.equalsIgnoreCase("exit"))
				{
					break;
				}
				else
				{
					if(uniqueEmail.contains(email))
					{
						System.out.println("Already Subscribed.");
					}
					else
					{
						if(!(email.isEmpty()))
						{
							uniqueEmail.add(email);
							System.out.println("Your Subscription is Confirmed, Thank You!!!  "+email);
						}
					}
				}
		
			}
			else if(choice==2)
			{
				if(!(uniqueEmail.isEmpty()))
				{
				System.out.println("Final Subcribers list\n");
				
				for(String email:uniqueEmail)
				{
					System.out.println(email);
				}
				}
				else
				{
					System.out.println("Subcribers list is Empty..");

				}
			}
			else if(choice==3)
			{
				System.out.println("Exiting.......");
			}
			else 
			{
				System.out.println("Invaid input (choose choice bet'n 1 to 3)");
			}
		
		}
		sc.close();
				
	}

}
