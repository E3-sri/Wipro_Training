package HealthCare;

public class HealthCareMain
{

				public static void main(String[] args)
				{
		       
		        PatientService service = new PatientServiceImpl();

		        PatientDetails p1 = new PatientDetails(1, "Sree Lakshmi",22, "Eye Problem");
		        PatientDetails p2 = new PatientDetails(2, "Rama", 23, "Heart Pain");

		        service.registerPatient(p1);
		        service.registerPatient(p2);

		
		        System.out.println("\nRegistered Patients:");
		        service.showAllPatients();


		        Doctor optho_obj = new Opthomologist("Krishna");
		        Doctor cardio_obj = new Cardiologist("Bhavani");
		        
		        System.out.println("\nDoctor Diagnoses:");
		        optho_obj.diagnose(p1);
		        optho_obj.diagnose(p2);

		        cardio_obj.diagnose(p1);
		        cardio_obj.diagnose(p2);
		    }
}
