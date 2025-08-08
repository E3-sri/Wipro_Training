package Cls_work;

import java.util.Scanner;
import java.util.LinkedList;

public class PatientQueue {

    public static DoctorClass assignDoctor(String disease) {
        switch (disease.toLowerCase()) {
            case "fever":
                return new DoctorClass("Sharma", "General Physician");
            case "heart attack":
                return new DoctorClass("Mehta", "Cardiologist");
            case "fracture":
                return new DoctorClass("Verma", "Orthopedic");
            case "headache":
                return new DoctorClass("Khan", "Neurologist");
            case "stomach pain":
                return new DoctorClass("Patel", "Gastroenterologist");
            default:
                return new DoctorClass("Singh", "General Medicine");
        }
    }

    public static void main(String[] args) {
        LinkedList<PatientClass> patientQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n******* Hospital Patient Queue *******");
            System.out.println("1. Add New Patient (Normal)");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. Remove Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. View First and Last Patient");
            System.out.println("6. Exit");
            System.out.print("Choose your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name of the Patient: ");
                    String patientName = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Enter Symptoms: ");
                    String symptoms = sc.nextLine();
                    DoctorClass doctor = assignDoctor(disease);
                    PatientClass patient = new PatientClass(patientName, disease, symptoms, doctor);
                    patientQueue.addLast(patient);
                    System.out.println("Patient added to Queue.");
                    break;

                case 2:
                    System.out.print("Enter Name of the Emergency Patient: ");
                    String eName = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String eDisease = sc.nextLine();
                    System.out.print("Enter Symptoms: ");
                    String eSymptoms = sc.nextLine();
                    DoctorClass eDoctor = assignDoctor(eDisease);
                    PatientClass ePatient = new PatientClass(eName, eDisease, eSymptoms, eDoctor);
                    patientQueue.addFirst(ePatient);
                    System.out.println("Emergency Patient added to Front of Queue.");
                    break;

                case 3:
                    if (!patientQueue.isEmpty()) {
                        PatientClass removedPatient = patientQueue.removeFirst();
                        System.out.println("Removed Patient: " + removedPatient);
                    } else {
                        System.out.println("No patients in Queue.");
                    }
                    break;

                case 4:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("All Patients in Queue:");
                        for (PatientClass p : patientQueue) {
                            System.out.println(p);
                        }
                    } else {
                        System.out.println("Queue is Empty.");
                    }
                    break;

                case 5:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("First Patient: " + patientQueue.getFirst());
                        System.out.println("Last Patient: " + patientQueue.getLast());
                    } else {
                        System.out.println("Queue is Empty.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter a valid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
