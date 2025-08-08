package home;
import java.util.Scanner;
public class StrMethods {
	public static void main(String[] args) {
		//String Class
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String1:");
		String s1=sc.nextLine();
		System.out.println("Enter String2:");
		String s2=sc.nextLine();
		
		System.out.println("Concatenation:"+(s1.concat(s2)));
		System.out.println("Length:"+(s1.length()));
		System.out.println("charAt:"+(s1.charAt(0)));
		System.out.println("SubString:"+(s1.substring(0,5)));
		System.out.println("Repetition:"+s1.repeat(4));
		sc.close();
	}

}
