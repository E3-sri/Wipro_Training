package home;
import java.util.Scanner;
public class WrapperClass {

	public static void main(String[] args)
	{
		//Boxing  (primitive to object)
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value:");
		int a=sc.nextInt();
		Integer b=a;
		Integer c=Integer.valueOf(a);
		System.out.println(a+" "+b+" "+c );
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
		sc.nextLine();
		
		//Unboxing  (object to primitive)
		
		Integer i=new Integer(10);
		System.out.println("i is"+i.getClass().getName());
		int x=i;
		int y=i.intValue();	
		System.out.println(i);
	}

}
