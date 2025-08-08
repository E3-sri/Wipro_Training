package ClassWork;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Student implements Serializable
{
	    String name;
	    int age;

	    public Student(String name, int age) 
	    {
	        this.name = name;
	        this.age = age;
	    }
	    
	    public void display()
	    {
	        System.out.println("Student Name: " + name);
	        System.out.println("Student Age: " + age);
	    }
}
public class StudentExample
{
	public static void main(String[] args)
	{
		try
		{
            Student s = new Student("Sri Lakshmi", 23);

            FileOutputStream fileOut = new FileOutputStream("student.dat");  //It creates a connection to a file named student.dat.If the file doesn’t exist, it creates one.
            ObjectOutputStream out = new ObjectOutputStream(fileOut);//Creates a special stream that knows how to write Java objects (like Student) to the file stream you just created.
            out.writeObject(s); // 🔸 SERIALIZATION happens here  serializes the Student object s and writes it into the file student.dat
            out.close();   //Closes the ObjectOutputStream. Releases the system resources used for writing the object.
            fileOut.close();

            System.out.println("Student object has been serialized (saved).");
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
		
		//Deserialization
		
		 try 
		 {
	            FileInputStream fis = new FileInputStream("student.dat");  //Opens the file student.dat for reading.


	            ObjectInputStream ois = new ObjectInputStream(fis);   //Creates a stream that can read Java objects from the file stream (fis).



	            Student loadedStudent = (Student) ois.readObject(); // 🔹 Deserialization   Reads the object from the file and converts it back into a Student object.
	            													//You must cast it to the Student type because readObject() returns a generic Object.



	            ois.close();  // Closes the object input stream.


	            fis.close();   // Closes the file input stream.



	            System.out.println("Object deserialized from student.dat");
	            
	            loadedStudent.display();			//This is just a confirmation message telling you: “The student object was successfully read from the file.”



	       } 
		 catch (IOException | ClassNotFoundException e)   //Calls the display() method of the Student class to print the student’s name and age.
		 {
	            e.printStackTrace();
	     }
	}
			
		
}


