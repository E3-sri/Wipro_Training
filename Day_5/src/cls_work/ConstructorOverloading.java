package cls_work;

public class ConstructorOverloading
{
	String Name;
	int age;
	String dept;
	
	ConstructorOverloading()
	{
		this.Name="";
		this.age=0;
		this.dept="";
	}
	ConstructorOverloading(String Name)
	{
		this.Name=Name;
		this.age=0;
		this.dept="";
	
	}
	ConstructorOverloading(String Name,int age )
	{
		this.Name=Name;
		this.age=age;
		this.dept="";
	}
	ConstructorOverloading(String Name,int age, String dept )
	{
		this.Name=Name;
		this.age=age;
		this.dept=dept;
	}
	void display()
	{
		System.out.println("Name: "+Name+" Age: "+age+" Dept: "+dept);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructorOverloading co=new ConstructorOverloading();
		ConstructorOverloading co1=new ConstructorOverloading("Sree");
		ConstructorOverloading co2=new ConstructorOverloading("Sree",22);
		ConstructorOverloading co3=new ConstructorOverloading("Sree",22,"CSE");

		
		co.display();
		co1.display();
		co2.display();
		co3.display();
		
	}

}
