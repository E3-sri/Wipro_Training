package cls_work;
import java.util.Scanner;
public class Constructor
{
	String name;
	
	Constructor(String n)
	{
		name=n;
	}
	void Display()
	{
		System.out.println("Name:"+name+" You have called through construtor");
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name:");
		String name=sc.nextLine();
		Constructor c=new Constructor(name);
		c.Display();
		sc.close();
	}

}
