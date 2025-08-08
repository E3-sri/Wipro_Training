package Cls_work;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

	public static void main(String[] args)
	{
		try {
            FileWriter writer = new FileWriter("fileCreation.txt");
            writer.write("Hello! This is a test.\nThis is line 2.");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } 
		catch (IOException e) 
		{      	
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
			
}
