package cls_work;

public class Enc_Main {

	public static void main(String[] args) {
		Enc_Emp emp=new Enc_Emp(100000);
		System.out.println("Present Salary:"+emp.getSalary());
		
		emp.setSalary(120000);
		System.out.println("Incremented Salary:"+emp.getSalary());
		emp.setSalary(-15000);
	}

}
