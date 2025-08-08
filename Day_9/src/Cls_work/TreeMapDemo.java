package Cls_work;
import java.util.*;

public class TreeMapDemo 
{

	public static void main(String[] args)
	{
		TreeMap <Integer,String> patientMap=new TreeMap<>();
		
		patientMap.put(112, "Sree");
		patientMap.put(103, "Lakshmi");
		patientMap.put(100, "Hymavathi");
		patientMap.put(95, "Chaturvedula");

		
		//patient sorted by ID.
		
		System.out.println("Sorted Patient List:\n");
		
		for(Map.Entry<Integer,String>entry:patientMap.entrySet())
		{
			System.out.println("\n ID :"+ entry.getKey()+ "->"+entry.getValue());
			
		}
		
		//finding first and last patient.
		
		System.out.println("\nFirst Patient ID: "+patientMap.firstKey());
		
		System.out.println("\nLast Patient ID: "+patientMap.lastKey());
		
		//Search by ID
		
		System.out.println("Patient with ID 101 :"+patientMap.get(101));
		
		//check if exists
		
		System.out.println("\n Has ID 102?"+patientMap.containsKey(101));
		
		

		

		
	}

}
