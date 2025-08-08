package WT;

import java.util.Scanner;

public class google {
	
	void display(String file_name,String file_type, int file_size)
	{
		System.out.println("**File uploaded Successfully**");
		System.out.println("File Name:"+file_name);
		System.out.println("File Type:"+file_type);
		System.out.println("File Size:"+file_size);


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter file name:\n");
		String file_name=sc.nextLine();
		System.out.println("Enter file Type:\n");
		String file_type=sc.nextLine();
		System.out.println("Enter file size in mb:\n");
		int file_size=sc.nextInt();
		google g=new google();
		g.display(file_name,file_type,file_size);
		sc.close();
		
	}

}
