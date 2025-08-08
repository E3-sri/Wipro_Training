package cls_work;
import java.util.Scanner;
public class StaticMethod 
{
	void greet()
	{
		System.out.println("Iam non-static method.Create an object to call me.");
	}
	static void hello()
	{
		System.out.println("Iam static method.You can call me without creating object.");
	}
	static void Hi(String name,int age)
	{
		System.out.println("Hi "+name+" age is "+age);
	}
	

	public static void main(String[] args)
	{
		//hello(); not a best practice.bcoz there can be same method name and signatures can be different.
		StaticMethod.hello();
		StaticMethod sm=new StaticMethod();
		sm.greet();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name=sc.nextLine();
		System.out.println("Enter Your Age:");
		int age=sc.nextInt();
		StaticMethod.Hi(name,age);	
	}
	

}

