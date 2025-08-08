package day_7;
import java.util.Scanner;
public class FromValidationWrapper
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		String name;
        String ageInput;
        String marksInput;
        
        int age = 0;
        int marks = 0;
        
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        
        while (true) 
        {
            System.out.print("Enter your age: ");
            ageInput = sc.nextLine();
            
            try {
                age = Integer.parseInt(ageInput);
                if (age < 0 || age > 150) {
                    System.out.println(" Age must be between 0 and 150.");
                } 
                else 
                {
                    break; 
                }
            		}
        catch (NumberFormatException e)
            {
            System.out.println(" Invalid input! Age Should be Positive and less than 150.");
            }
            
        }     
         while (true) 
         {
                System.out.print("Enter your marks (0–100): ");
                marksInput = sc.nextLine();
                
                try {
                    marks = Integer.parseInt(marksInput);
                    if (marks < 0 || marks > 100) {
                        System.out.println(" Marks must be between 0 and 100.");
                    } 
                    else
                    {
                        break;
                    }
                		} 
                catch (NumberFormatException e)
                {
                    System.out.println(" Invalid input! Marks must be a number.");
                }
         }
         
                
                System.out.println("\n Form Submitted Successfully!");
                System.out.println("Name : " + name);
                System.out.println("Age  : " + age);
                System.out.println("Marks: " + marks);
         
         	}
        }
	 

        
	
	

