package HealthCare;

public class PatientDetails
{
		private int id;
		private String name;
		private int age;
		private String illness;
		
	public PatientDetails(int id,String name,int age,String illness)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.illness=illness;
		
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getIllness()
	{
		return illness;
	}
	public void displayDetails()
	{
		System.out.println("Patient Id:"+id);
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
		System.out.println("Illness:"+illness);
		
	}
}
