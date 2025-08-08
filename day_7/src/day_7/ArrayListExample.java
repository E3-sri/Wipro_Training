package day_7;
import java.util.Scanner;
import java.util.ArrayList;
class Patient
{
	private String name;
	private int age;
	private String disease;
	private char gender;
	private Doctor doctor;

	
	public Patient(String name,int age, String disease,char gender )
	{
		this.name=name;
		this.age=age;
		this.disease=disease;
		this.gender=	gender;
		this.doctor = ArrayListExample.assignDoctor(disease);

	}
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getDisease()
	{
		return disease;
	}
	public char getGender()
	{
		return gender;
	}
	public void updateDisease(String newDisease) {
        this.disease = newDisease;
        this.doctor = ArrayListExample.assignDoctor(newDisease);
    }
	public void displayInfo()
	{
		System.out.println("\n*****Patient Information*****\n");
		System.out.println("Name: "+ name + "\nAge: "+ age+ "\nGender: "+gender +"\nDisease: "+disease );
        System.out.println("Treated by Doctor: " + doctor.getName());

		
	}	
}
class Doctor
{
	String name;
	String specialisation;
	
	public Doctor(String name,String specialisation)
	{
		this.name=name;
		this.specialisation=specialisation;
	}
	public String getName()
	{
		return name;
		
	}
	public String getSpecialisation()
	{
		return specialisation;
		
	}
	public void displayDetails()
	{
		System.out.println("Name: "+name+"\nSpecialisation in "+specialisation);
	}

}

public class ArrayListExample {

	public static void main(String[] args)
	{
		ArrayList <Patient> patientList=new ArrayList<>();
		
		
		Scanner sc=new Scanner(System.in);
		//patientList.add(new Patient("Sree Lakshmi",22,'F',"Fever"));
		//patientList.add(new Patient("Hymavathi",23,'F',"Headache"));
		//patientList.add(new Patient("Rama",24,'M',"Vomtings"));
	while(true)
	{
		System.out.println("\n *******  Hospital OPD Menu  *******");
		System.out.println("\n 1.Add New Patient");
		System.out.println("\n 2.Display All Patients");
		System.out.println("\n 3.Search Patient by Name");
		System.out.println("\n 4.Exit");
		System.out.println("\n Choose your Choice:");
		int choice=sc.nextInt();

		System.out.println("");
		
		if(choice==1)
		{
			System.out.println("Enter patient name:");
			sc.nextLine();
			String name=sc.nextLine().toLowerCase();
		
			System.out.println("Enter Patient Age:");
			int age=sc.nextInt();
			sc.nextLine();
			

			
			System.out.println("Enter the disease:");
			String disease=sc.nextLine();
			
			
		    Doctor  assignedDoctor = assignDoctor(disease);
			System.out.println("\nPatient should consult the following doctor:");
			assignedDoctor.displayDetails();
			
			System.out.println("Enter Gender of Patient:");
			char gender=sc.next().charAt(0);
			
			patientList.add(new Patient(name,age,disease,gender));		
			

			System.out.println("Patient Added Successfully");
		}
		else if(choice==2)
		{
			System.out.println("All Registered Patients:\n");
			for(Patient p:patientList)
			{
				p.displayInfo();
			}
		}
		else if(choice==3)
		{
			sc.nextLine();
			System.out.println("Enter patient name to search:");
			String searchName=sc.nextLine();
			boolean found=false;
			
			//for each loop
			for (Patient p:patientList)
			{
				if(p.getName().equalsIgnoreCase(searchName))
				{
					found=true;
					
					System.out.println("Patient found. Current disease: " + p.getDisease());
		            System.out.println("Enter new disease to update:");
		            String newDisease = sc.nextLine();
		            
		            p.updateDisease(newDisease); 
		            System.out.println("Disease updated successfully!");
		            
		            p.displayInfo();
		            break;
				}
			}
			if(!found)
			{
				System.out.println("No patient found with name"+searchName);
			}
			break;
		}
		else if(choice==4)
		{
			System.out.println("Exiting.....");
			sc.close();
			return;
		}
		else
		{
			System.out.println("Invaid Choice");
		}
	}
	}
	public static Doctor assignDoctor(String disease)
	{
	    disease = disease.toLowerCase();

	    switch (disease) {
	        case "headache":
	        case "fever":
	            return new Doctor("Dr. Kumar", "General Physician");

	        case "eye pain":
	        case "blurred vision":
	            return new Doctor("Dr. Meera", "Ophthalmologist");

	        case "memory loss":
	        case "dizziness":
	            return new Doctor("Dr. Ravi", "Neurologist");

	        case "vomtings":
	            return new Doctor("Dr. Sita", "Gastroenterologist");

	        default:
	            return new Doctor("Dr. John", "General Physician");
	    }
	}
}

	
	

