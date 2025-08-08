package home;
import java.util.Scanner;

public class OneDimensional 
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size=sc.nextInt();
		
		//Declaration & Initialization of Array
		
		int array[]=new int[size];
		
		System.out.println("Enter the data into array\n");
		for (int i=0;i<array.length;i++)
		{
			int num=sc.nextInt();
			System.out.println("Array of index "+i+" = "+num);
		}
		sc.close();
		

	}

}
