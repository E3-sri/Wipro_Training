package cls_work;
import java.util.Scanner;
public class EmpMain
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee role:(1.Manager,2.Developer):");
		int choice = sc.nextInt();
		
		System.out.println("Enter Name:");
		String name=sc.nextLine();
		
		System.out.println("Enter Id:");
		int id=sc.nextInt();
		
		//System.out.println("Enter Salary:");
		//double salary =sc.nextDouble();
		
		//System.out.println("Enter Department:");
		//String Department=sc.nextLine();
		
		if (choice == 1)
		{
		 Manager m_obj=new Manager();
         m_obj.getDetails(name, id);

         System.out.print("Enter Department: ");
         String department = sc.nextLine();
         m_obj.setDepartment(department);

         System.out.println("\n--- Manager Details ---");
         m_obj.displayDetails();
		}
		else if(choice ==2)
		{
		
			Developer d_obj=new Developer();
			d_obj.getDetails(name, id);

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            d_obj.setSalary(salary);

            System.out.println("\n--- Developer Details ---");
            d_obj.displayDetails();
		}
		sc.close();

	}

}
