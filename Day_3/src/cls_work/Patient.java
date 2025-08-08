package cls_work;

public class Patient 
{
	private String name;
	private int age ;
	private String diagnosis;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		if(!name.isEmpty())
		{
			this.name=name;
		}
		else
		{
			System.out.println("Name cannot be Empty");
		}
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		if(age>0)
		{
			this.age=age;
		}
		else
		{
			System.out.println("Invaid Age");
		}
	}
	public String getDiagnosis()
	{
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis)
	{
		if(!diagnosis.isEmpty())
		{
			this.diagnosis=diagnosis;
		}
		else
		{
			System.out.println("Empty Diagnosis");
		}
		
	}
}
