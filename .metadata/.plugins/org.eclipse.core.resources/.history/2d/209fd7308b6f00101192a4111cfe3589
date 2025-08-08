package com.ClassWork;
import java.sql.*;
//import java.util.Scanner;

public class EmpValues 
{

	public static void main(String[] args)
	{
	
		//Scanner sc=new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/Worker"; 
        String username = "root";     
        String password = "Hyma@2002";
		 try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection(url,username,password);
				 
				// Taking input of patient details
				
				/*
				System.out.print("Enter  Id: ");
	            int Id = sc.nextInt(); 
	            sc.nextLine();
	            
	            System.out.print("Enter Employee Name: ");
	            String Name = sc.nextLine();
	          

	            System.out.print("Enter Age: ");
	            int age = sc.nextInt();
	            sc.nextLine(); 

	            System.out.print("Enter Department: ");
	            String Department = sc.nextLine();

	            System.out.print("Enter Joining Date (yyyy-mm-dd): ");
	            String Joining_Date = sc.nextLine();

	            System.out.print("Enter Salary: ");
	            int Salary = sc.nextInt();
	            
	            
	            //Inserting values to Employee Table
	            
	            String insertSQL = "INSERT INTO Employee(id,Name, Age, Department, Joining_Date, Salary) VALUES (?,?, ?, ?, ?, ?)";
	            
	            PreparedStatement pstmt = con.prepareStatement(insertSQL);
	            pstmt.setInt(1, Id);
	            pstmt.setString(2, Name);
	            pstmt.setInt(3, age);
	            pstmt.setString(4,Department );
	            pstmt.setDate(5, Date.valueOf(Joining_Date)); // converts to java.sql.Date
	            pstmt.setInt(6,Salary);
	            
	           
	            int rowsInserted = pstmt.executeUpdate();
	            
	    		if(rowsInserted>0)
	    		{
		            System.out.println(rowsInserted + " Inserted registered successfully.\n");

	    		}
	    		con.close();
	    		sc.close();
	    		
			 }
			catch (Exception e)
			{
			e.printStackTrace();
			
					
			}
			
			*/
				
			//To Insert Multiple records
				
	            String insertSQL = "INSERT INTO Employee(id,Name, Age, Department, Joining_Date, Salary) VALUES (?,?, ?, ?, ?, ?)";
						
				PreparedStatement pstmt=con.prepareStatement(insertSQL);
						String[][] data=
						{
								/*{"101","Hymavathi","22","Sales","2025-01-05","10000"},
								{"103","Lalitha","25","HR","2025-05-15","20000"},
								{"104","Rama","26","Marketing","2025-08-25","10500"},
								{"105","Cheeku","27","Accounts","2025-03-25","12500"}  */
								
							//{"10","Sowmya","28","TechSupport","2025-10-05","15000"}
								
							{"107","Rama","28","ITSupport","2025-11-15","10000"},
							{"104","Sree","25","CustomerSupport","2024-10-10","14000"},
						    };
							for(String[] row : data)
						{
							pstmt.setString(1, row[0]);
							pstmt.setString(2, row[1]);
							pstmt.setInt(3, Integer.parseInt(row[2]));
							pstmt.setString(4, row[3]);
							pstmt.setString(5, row[4]);
							pstmt.setInt(6, Integer.parseInt(row[5]));
							pstmt.executeUpdate();
							
						}
						System.out.println(" All Employees inserted Successfully");
						con.close();
					    }
					catch (Exception e)
					{
					e.printStackTrace();
							
					}
		}
	
}
			


