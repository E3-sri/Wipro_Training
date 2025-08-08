package WT;
import java.lang.*;
public class source {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String CustomerName="Sree lakshmi";
		System.out.println("Welcome to E-Foods"+" "+CustomerName);
		//To convert in Upper Case
		
		System.out.println("Welcome to E-Foods"+" "+CustomerName.toUpperCase());
		
		if(CustomerName.contains("Sree"))
		{
			System.out.println("Special Cusomer Detected");
		}
		char f_letter=CustomerName.charAt(0);
		System.out.println("Starts With:"+f_letter);
		
		
	}

}
