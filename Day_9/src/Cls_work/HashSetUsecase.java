/*✅ Use Case: Unique Doctor Registration in a Hospital System
🎯 Scenario:
In a hospital, doctors from various departments are registered with the hospital system. Each doctor has a unique license number (just like a unique ID).

The goal is to ensure that no doctor is registered more than once, even if their name or department is the same.
 
✅ Operations in the System:
Add a new doctor.
Prevent duplicate registration.
Display all registered doctors.*/
 

package Cls_work;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;


class Doctor
{
	private String licenseNumber;
	private String name;
	private String department;
	
	
	public Doctor(String licenseNumber, String name, String department)
	{
		this.licenseNumber=licenseNumber;
		this.name=name;
		this.department=department;
	}
	
	public String getLicenseNumber()
	{
		return licenseNumber;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public boolean equals(Object obj)
	{
        if (this == obj)
        {
        		return true;
        }
        if (!(obj instanceof Doctor))
        	{
        		return false;
        	}
        Doctor other = (Doctor) obj;
        return this.licenseNumber.equals(other.licenseNumber);
    }

    public int hashCode() 
    {
        return licenseNumber.hashCode();
    }

    
    public String toString()
    {
        return "Doctor [License: " + licenseNumber + ", Name: " + name + ", Dept: " + department + "]";
    }
}

public class HashSetUsecase {

	public static void main(String[] args)
	{
		Set<Doctor> doctorSet=new HashSet<>();
		Scanner sc=new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("1.Add a New Doctor");
			System.out.println("2.View all doctors");
			System.out.println("3. Exiting.....\n");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			sc.nextLine();
			if(choice==1)
			{
				System.out.println("Enter Lincense Number:");
				String LicenseNumber=sc.	nextLine();
				
				System.out.println("Enter Name:");
				String name=sc.nextLine();
				
				System.out.print("Enter Department: ");
                String department = sc.nextLine();
                
                Doctor newDoc = new Doctor(LicenseNumber, name, department);
                
                if (doctorSet.contains(newDoc))
                {
                    System.out.println(" Doctor already registered with this license number.");
                }
                else 
                {
                    doctorSet.add(newDoc);
                    System.out.println(" Doctor added successfully!");
                }	
			}
			else if(choice==2)
			{
				System.out.println("Viewing list the doctors");
				if (doctorSet.isEmpty()) 
				{
                    System.out.println("No doctors registered yet.");
                } 
				else
				{
                    for (Doctor d : doctorSet) 
                    {
                        System.out.println(d);
                    }
                }
				
			}
			else if(choice==3)
			{
				System.out.println("Exiting....");
			}
			else
			{
				System.out.println("Enter Valid Choice");
			}
		}while(choice!=3);
		 sc.close();

			
		}
	}
