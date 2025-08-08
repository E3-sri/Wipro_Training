/*✅ Use Case: Avoid Duplicate Patient Registrations in Hospital System
🎯 Scenario:
In a hospital, when patients arrive for registration, each patient is given a unique ID. We want to ensure:
No patient is registered more than once (based on ID).
Staff can view the list of unique registered patients.
 */


package Cls_work;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

class Patient
{
	    private String id;
	    private String name;

	    public Patient(String id, String name)
	    {
	        this.id = id;
	        this.name = name;
	    }

	    public String getId() 
	    { 
	    		return id;
	    	}
	    public String getName()
	    { 
	    	return name;
	    	}
	   
	    public String toString()
	    {
	        return "Patient ID: " + id + ", Name: " + name;
	    }
}



public class PatientHashSet {

	public static void main(String[] args)
	{
		
		 	 Set<String> uniqueIds = new HashSet<>(); 
	         ArrayList<Patient> patientList = new ArrayList<>();
	         
	         Scanner sc = new Scanner(System.in);
	         int choice;
	         
	         do {
	             System.out.println("\n--- Patient Registration ---\n");
	             System.out.println("1. Register Patient");
	             System.out.println("2. View All Patients");
	             System.out.println("3. Search patient by ID");
	             System.out.println("4. Delete patient by ID");
	             System.out.println("5.Exit");	             
	             System.out.print("Enter your choice: ");
	             choice = sc.nextInt(); 
	             sc.nextLine();
	         
	             
	           if(choice==1)
	           {
	                    System.out.print("Enter Patient ID: ");
	                    String id = sc.nextLine();
	                    
	                    if (uniqueIds.contains(id)) {
	                        System.out.println("Patient with ID " + id + " ID already exists!");
	                    } 
	                    else 
	                    {
	                        System.out.print("Enter Patient Name: ");
	                        String name = sc.nextLine();
	                        Patient patient = new Patient(id, name);
	                        patientList.add(patient);
	                        uniqueIds.add(id);  
	                        System.out.println(" Patient Registered Successfully!");
	                    }
	           }
	           else if (choice==2)
	           {
	                    System.out.println("\n--- Registered Patients ---");
	                    for (Patient p : patientList) {
	                        System.out.println(p);
	                    }
	           }

	           else if(choice==3)
	           {
	        	   			System.out.println("Enter ID you wants to search");
	        	   			String searchId = sc.nextLine();

	        	   			boolean found = false;
	        	   			for (Patient p : patientList)
	        	   			{
	        	   			    if (p.getId().equals(searchId))
	        	   			    {
	        	   			        System.out.println(" Patient Found: " + p);
	        	   			        found = true;
	        	   			        break;
	        	   			    }
	        	   			}

	        	   			if (!found) {
	        	   			    System.out.println("Patient not found with ID: " + searchId);
	        	   			}		
	           }
	           else if(choice==4)
	           {
	        	   		System.out.println("Enter ID you wants to delete");
	        	   		String deleteId = sc.nextLine();
	        	   		Patient temp=null;
	        	   		for (Patient p : patientList)
	        	   		{
	        	   		    if (p.getId().equals(deleteId))
	        	   		    {  // Check if ID matches
	        	   		        temp = p;
	        	   		    }
	        	   		}
	        	   		 if (temp != null)
	        	   		 {
	        	   		    patientList.remove(temp);
	        	   		    System.out.println("Patient with ID " + deleteId + " has been treated.");
	        	   		} 
	        	   		else
	        	   		{
	        	   		    System.out.println("Patient not found with ID: " + deleteId);
	        	   		}
	           }
	           
	           else if(choice==5)
	           {
	        	   			System.out.println("Exiting....");
	           }           
	           else
	           {
	                    System.out.println("Invalid choice.");
	           }

	        } while (choice != 5);
	          sc.close();
	}


}
