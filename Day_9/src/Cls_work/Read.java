package Cls_work;
import java.io.*;

public class Read {

	public static void main(String[] args)
	{
		try {
           
            BufferedReader reader = new BufferedReader(new FileReader("fileCreation.txt"));

            String line;

            System.out.println("\n Reading file content");
            
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line); 
            }
            reader.close();
        }
		catch (IOException e)
		{
            System.out.println(" Error while reading file.");
            e.printStackTrace();
        }
    }
	
}
