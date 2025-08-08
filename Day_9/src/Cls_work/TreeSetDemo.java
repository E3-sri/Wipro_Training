package Cls_work;
//import java.util.Scanner;
import java.util.TreeSet;


public class TreeSetDemo 
{

	public static void main(String[] args) 
	{
		
	TreeSet<Integer> rooms =new TreeSet<>();
	
	rooms.add(900);
	rooms.add(305);
	rooms.add(250);
	rooms.add(120);
	
	
	System.out.println("Avaliable Rooms (Sorted):");
	for(int room : rooms)
	{
		System.out.println("Rooms: "+room);
	}	
	System.out.println("\nFirst Room:"+rooms.first());
	System.out.println("\nLast Room:"+rooms.last());		
	}

}
