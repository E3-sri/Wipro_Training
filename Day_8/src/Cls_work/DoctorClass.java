package Cls_work;

public class DoctorClass
{
	 	private String name;
	    private String specialization;

	    public DoctorClass(String name, String specialization)
	    {
	        this.name = name;
	        this.specialization = specialization;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getSpecialization() {
	        return specialization;
	    }

	    
	    public String toString()
	    {
	        return "Dr. " + name + " (" + specialization + ")";
	    }
}

