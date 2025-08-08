package cls_work;

public class Enc_Emp {
	
	private float salary;
	public Enc_Emp(float salary)
	{
		this.salary=salary;
	}
	public float getSalary()
	{
		return salary;
	}
	
	public void setSalary(float salary)
	{
		if(salary>0)
		{
			this.salary=salary;
		}
		else
		{
			System.out.println("Invalid Amount");
		}
	}

}
