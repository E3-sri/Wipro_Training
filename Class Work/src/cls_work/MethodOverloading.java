package cls_work;
import java.util.Scanner;
public class MethodOverloading
{
	
	void displayDetails(String name,int age)
	{
		System.out.println("Name is:"+name+ "and age is:"+age);
	}
	void displayDetails(double salary)
	{
		System.out.println("Salary is:"+salary);
	}
	void displayDetails(String department)
	{
		System.out.println("Working in :"+department);
	}
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	MethodOverloading mo=new MethodOverloading();
	
	System.out.println("Enter your name:");
	String name=sc.nextLine();
	
	System.out.println("Enter your age:");
	int age=sc.nextInt();
	
	mo.displayDetails(name,age);
	
	System.out.println("Enter your department:");

	String dept=sc.nextLine();
	double salary=sc.nextDouble();
	
}
}
