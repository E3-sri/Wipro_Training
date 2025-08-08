package WT;
import java.util.Scanner;
public class book_example {
	void books()
	{
		System.out.println("Books Store\n");
	}
	void display(String Name,String Book_Name,String Author_Name,double Price)
	{
		System.out.println("***Customer Details***\n");
		System.out.println("Customer Name is:"+Name);
		System.out.println("Book Orderd:"+Book_Name);
		System.out.println("Author:"+Author_Name);
		System.out.println("Price:"+Price);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Details of Customer\n");
		System.out.println("Enter Customer Name:");
		String Name=sc.nextLine();
		System.out.println("Enter Book Name:");
		String Book_Name=sc.nextLine();
		System.out.println("Enter Author Name:");
		String Author_Name=sc.nextLine();
		System.out.println("Enter Price:");
		double Price=sc.nextDouble();
		book_example be=new book_example();
		be.display(Name,Book_Name,Author_Name,Price);
		sc.close();

	}

}
