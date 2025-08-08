package HealthCare;
//import java.util.Scanner;

public class PatientServiceImpl implements PatientService
{
	    private PatientDetails[] patients = new PatientDetails[10];
	    private int count = 0;

	    public void registerPatient(PatientDetails patient) {
	        if (count < patients.length) 
	        {
	            patients[count++] = patient;
	            System.out.println("Patient with ID " + patient.getId() + " registered successfully.");
	        } 
	        else {
	            System.out.println("Registration failed: Patient limit reached.");
	        }
	    }

	    public void showAllPatients() {
	        for (int i = 0; i < count; i++) {
	            patients[i].displayDetails();
	        }
	    }
}