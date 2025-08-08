package Cls_work;

import java.util.HashMap;
import java.util.Scanner;

class HospitalPatient {
    private int id;
    private String name;
    private String disease;

    public HospitalPatient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Disease: " + disease;
    }
}


public class HospitalMapping {
    public static void main(String[] args) {
    	HashMap<Integer, HospitalPatient> patientMap = new HashMap<>();

        // Adding some default patients
        patientMap.put(101, new HospitalPatient(101, "Renu", "Cold"));
        patientMap.put(102, new HospitalPatient(102, "Sai", "Fever"));
        patientMap.put(103, new HospitalPatient(103, "Mahasa", "Flu"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Patient Map ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Get Patient by ID");
            System.out.println("3. Check if Patient ID Exists");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    patientMap.put(id, new HospitalPatient(id, name, disease));
                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to retrieve: ");
                    int searchId = sc.nextInt();
                    HospitalPatient p = patientMap.get(searchId);
                    if (p != null) {
                        System.out.println("Found: " + p);
                    } else {
                        System.out.println("Patient ID not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to check: ");
                    int checkId = sc.nextInt();
                    if (patientMap.containsKey(checkId)) {
                        System.out.println("Patient exists.");
                    } else {
                        System.out.println("Patient does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("All Patients:");
                    for (HospitalPatient pat : patientMap.values()) {
                        System.out.println(pat);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
