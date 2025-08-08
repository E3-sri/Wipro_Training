package WT;
import java.util.Scanner;

public class emp_example {
	void info(String Name,double Salary,String Department)
	{
		System.out.println("Employee details are:\n");
		System.out.println("Employee Name:"+Name);
		System.out.println("Employee Salary:"+Salary);
		System.out.println("Employee Department:"+Department);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Details");
		System.out.println("Enter Name:\n");
		String Name=sc.nextLine();
		System.out.println("Enter salary:\n");
		double Salary=sc.nextDouble();
		System.out.println("Enter Department:\n");
		String Department=sc.next();
		emp_example e=new emp_example();
		e.info(Name,Salary,Department);
		sc.close();
	}

}
