package cls_work;

public class EmpInheritance
{
		String name;
		int id;
	
	void getDetails(String name, int id)
	{
	        this.name = name;
	        this.id = id;
	     
	 }
	void displayDetails()
	{
		System.out.println("Employee Name:"+name);
		System.out.println("Employee Id:"+id);
	}
}
class Manager extends EmpInheritance
{
	String Department;
	void setDepartment(String Department)
	{
		this.Department = Department;
	}
	 void mgrDetails()
	 {
		super.displayDetails();
		System.out.println("Department:"+Department);
		
	 }
}
class Developer extends EmpInheritance
{
	double salary;
	void setSalary(double salary)
	{
		this.salary = salary;
	}
	void devDetails()
	{
		super.displayDetails();
		System.out.println("Salary:"+salary);	
	}
}
