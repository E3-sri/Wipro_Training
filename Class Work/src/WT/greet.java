package WT;
import java.util.Scanner;
public class greet {
		void start()
		{
			System.out.println("**Starts**");
		}
		void hi(String Name)
		{
			System.out.println("Hi"+" "+Name);
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name:");
		String Name=sc.nextLine();
		greet g=new greet();
		g.start();
		g.hi(Name);
		sc.close();
	}
	

}
