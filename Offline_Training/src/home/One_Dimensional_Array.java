package home;
import java.util.Scanner;
public class One_Dimensional_Array 
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try {
		int a=10/0;
		System.out.println(a);
		}
		catch(ArithmeticException e)
		{
			System.out.println("you cannot divide num by 0 ");
		}
		/*String str=null;
		str.length();
		System.out.println(str);*/

		
	}

}
