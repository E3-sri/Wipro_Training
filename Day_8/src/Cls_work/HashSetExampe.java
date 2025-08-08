package Cls_work;
import java.util.HashSet;
import java.util.LinkedList;
//import java.util.Scanner;
public class HashSetExampe {

	public static void main(String[] args)
	{

		//Set<String> patients =new HashSet<>();
		LinkedList<String> list =new LinkedList<>();
		
		list.add("Sree");
		list.add("Hyma");
		list.add("Papai");
		list.add("Sree");
		
		System.out.println("Linkedlist is ordered and accepts duplicates");
		System.out.println("LinkedList"+list);
		
		
		HashSet<String> patients=new HashSet<>();
		
		patients.add("Sree");
		patients.add("Hyma");
		patients.add("Lakshmi");
		patients.add("Papai");
		patients.add("Sree");

		System.out.println("Hashset is Unordered and doesn't accept duplicates");
		System.out.println(patients);		
	}
	

}
