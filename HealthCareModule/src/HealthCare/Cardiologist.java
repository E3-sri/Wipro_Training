package HealthCare;
public class Cardiologist extends Doctor
{
	    public Cardiologist(String name)
	    {
	        super(name, "Cardiologist");
	    }

	    public void diagnose(PatientDetails patient)
	    {
	        System.out.println("Dr. " + name + "Cardiologist diagnosing " + patient.getName());
	        if (patient.getIllness().toLowerCase().contains("Heart"))
	        {
	            System.out.println("Diagnosis: Specialized heart treatment for " + patient.getIllness());
	        } 
	        else 
	        {
	            System.out.println("Diagnosis: Referred to a general physician for " + patient.getIllness());
	        }
	    }
}

