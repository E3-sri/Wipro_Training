package Cls_work;
import java.io.File;
import java.io.IOException;

public class Create {

	public static void main(String[] args) 
	{
		try
		{
			File myFile=new File("fileCreation.txt");
			 if (myFile.createNewFile()) 
			 {
	                System.out.println("File created: " + myFile.getName());
	         } 
			 else
			 {
	                System.out.println("File already exists.");
	                
			 }
			
		}
		catch(IOException e)
		{
			    System.out.println("An error occurred.");
	            e.printStackTrace();
		}	//see where the error occurred, including the file name, line number, and method calls.
	}

}
