package Cls_work;

public class PatientClass 
{
	    private String patientName;
	    private String disease;
	    private String symptoms;
	    private DoctorClass doctor;

	    public PatientClass(String patientName, String disease, String symptoms, DoctorClass doctor)
	    {
	        this.patientName = patientName;
	        this.disease = disease;
	        this.symptoms = symptoms;
	        this.doctor = doctor;
	    }

	    public String getName()
	    {
	        return patientName;
	    }

	    public DoctorClass getDoctor()
	    {
	        return doctor;
	    }

	 
	    public String toString()
	    {
	        return "Name: " + patientName + ", Disease: " + disease + ", Symptoms: " + symptoms + ", Assigned Doctor: " + doctor;
	    }
}

