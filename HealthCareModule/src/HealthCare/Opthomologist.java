package HealthCare;

public class Opthomologist extends Doctor
{
	 public Opthomologist(String name)
	 {
	        super(name, "Opthomologist");
	  }

	    public void diagnose(PatientDetails patient) 
	    {
	        System.out.println("Dr. " + name + " (Opthomologist) diagnosing " + patient.getName());
	        System.out.println("Diagnosis: medication for " + patient.getIllness());
	    }
}
