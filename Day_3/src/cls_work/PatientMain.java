package cls_work;

public class PatientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient p=new Patient();
		p.setName("Sree");
		p.setAge(20);
		p.setDiagnosis("Anemia");
		
		System.out.println("Patient Name:"+p.getName());
		System.out.println("Patient Age:"+p.getAge());
		System.out.println("Patient Diagnosis:"+p.getDiagnosis());
	}

}
