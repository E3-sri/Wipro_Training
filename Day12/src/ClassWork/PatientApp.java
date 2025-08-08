package ClassWork;
import java.io.*;
import java.util.Scanner;
class Patient implements Serializable //marker interface(means no methods or fields)
{
	int id;
	String name;
	String disease;
	int age;
	public Patient(int id, String name, String disease, int age)
	{
	this.id=id;
	this.name=name;
	this.disease=disease;
	this.age=age;
    }
 
	public String toString()
	{
		return id + " - "+ name + " - " + disease + " - " + age;
	}
}
public class PatientApp
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter ID:");
		int id =sc.nextInt();
		sc.nextLine();
 
		System.out.println("Enter Name:");
		String name =sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter Disease:");
		String disease =sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter Age:");
		int age =sc.nextInt();
		sc.nextLine();
		
		Patient p= new Patient(id, name, disease, age);
		
		//save patient object to file
		try
		{
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("patient.dat"));
			out.writeObject(p);
			out.close();
			System.out.println("Patient saved.");
		}
		catch(IOException e)
		{
			System.out.println("Error writing file.");
		}
		//Read patient object from file
		try
		{
			ObjectInputStream in= new ObjectInputStream(new FileInputStream("patient.dat"));
			Patient savedPatient=(Patient)in.readObject();
			in.close();
			System.out.println(" saved Patient.");
			System.out.println(savedPatient);
 
		}
		catch(Exception e)
		{
			System.out.println("Error Reading file.");
		}
 
		}
	}
	
 
 
 
 