package WT;

import java.util.Scanner;
public class emp_Report {
	public static void main(String[]args) 
	{
		
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Employee Name:");
	String EmployeeName=sc.nextLine();
	
	System.out.println("Enter Salary:");
	double Salary=sc.nextDouble();

	System.out.println("Department:");
	String Department=sc.next();

	System.out.println("Enter Years of Experience:");
	int Experience=sc.nextInt();
	StringBuffer genertor=new StringBuffer();
	
	
	genertor.insert(0,"Employee Report\n");
	genertor.replace(1,0,"e");
	genertor.append(EmployeeName);
	System.out.println("\n");
	genertor.append(Salary);
	System.out.println("\n");

	genertor.append(Department);
	System.out.println("\n");

	genertor.append(Experience);
	System.out.println("\n");
	
	System.out.println(genertor.toString());


	sc.close();
	}
	
}
