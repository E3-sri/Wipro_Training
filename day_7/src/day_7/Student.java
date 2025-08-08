package day_7;

public class Student
{
	private String name;
	
	private Integer marks;
	
	
	public Student(String name,Integer marks)
	{
		this.name=name;
		//this.rollno=rollno;
		this.marks=marks;
	}
	public String getName()
	{
		return name;
	}
	public Integer getMarks()
	{
		return marks;
	}
	/*public int getRollno()
	{
		return rollno;
	}*/
	public void setMarks(Integer marks)
	{
		this.marks=marks;
	}
	 public void display()
	 {
	        System.out.println("Student: " + name  +"Marks: " + marks);
	  }
}
	
	

