/*
 * ✅ Use Case: Patient Appointment Scheduler in Hospital (Using TreeMap)
🎯 Scenario:
In a hospital system, patient appointments must be stored in sorted order based on their appointment time (or ID, or any other natural order). Doctors and staff should be able to:
Add appointments
View all scheduled appointments in order
Remove a specific appointment
Reschedule an appointment
Check the next or last appointment
 
 */

package Cls_work;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class PatientAppointment {
    private String patientName;
    private int id;
    private LocalDateTime time;

    public PatientAppointment(String patientName, int id, LocalDateTime time) {
        this.patientName = patientName;
        this.id = id;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getId() {
        return id;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Patient Name: " + patientName + "  ID: " + id + "  Time: " + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}

public class TreeMapHospital {

    private static TreeMap<LocalDateTime, PatientAppointment> patientMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n***** Hospital Appointment Scheduler ******\n");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Remove Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. View Next Appointment");
            System.out.println("6. View Last Appointment");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addAppointment(sc);
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    removeAppointment(sc);
                    break;
                case 4:
                    rescheduleAppointment(sc);
                    break;
                case 5:
                    getNextAppointment();
                    break;
                case 6:
                    getLastAppointment();
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    private static void addAppointment(Scanner sc) {
        try {
            System.out.print("Enter Appointment Date & Time (yyyy-MM-dd HH:mm): ");
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime time = LocalDateTime.parse(input, formatter);

            if (patientMap.containsKey(time)) {
                System.out.println("Sorry, Time already booked!");
                return;
            }

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String patientName = sc.nextLine();

            PatientAppointment patient = new PatientAppointment(patientName, id, time);
            patientMap.put(time, patient);

            System.out.println("Appointment added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input format. Please use yyyy-MM-dd HH:mm.");
        }
    }

    private static void viewAppointments() {
        if (patientMap.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        System.out.println("Scheduled Appointments:\n");
        for (Map.Entry<LocalDateTime, PatientAppointment> entry : patientMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void removeAppointment(Scanner sc) {
        try {
            System.out.print("Enter Appointment Date & Time to Remove (yyyy-MM-dd HH:mm): ");
            sc.nextLine(); // consume newline if needed
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime time = LocalDateTime.parse(input, formatter);

            if (patientMap.remove(time) != null) {
                System.out.println("Appointment removed successfully.");
            } else {
                System.out.println("No appointment found at this time.");
            }
        } catch (Exception e) {
            System.out.println("Invalid format.");
        }
    }

    private static void rescheduleAppointment(Scanner sc) {
        try {
            System.out.print("Enter Current Appointment Time (yyyy-MM-dd HH:mm): ");
            sc.nextLine(); // consume newline if needed
            String oldInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime oldTime = LocalDateTime.parse(oldInput, formatter);

            PatientAppointment patient = patientMap.get(oldTime);
            if (patient == null) {
                System.out.println("No appointment at the given time.");
                return;
            }

            System.out.print("Enter New Appointment Time (yyyy-MM-dd HH:mm): ");
            String newInput = sc.nextLine();
            LocalDateTime newTime = LocalDateTime.parse(newInput, formatter);

            if (patientMap.containsKey(newTime)) {
                System.out.println("That time slot is already booked.");
                return;
            }

            patientMap.remove(oldTime);
            patient.setTime(newTime);
            patientMap.put(newTime, patient);
            System.out.println("Appointment rescheduled.");
        } catch (Exception e) {
            System.out.println("Invalid format.");
        }
    }

    private static void getNextAppointment() {
        if (patientMap.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        Map.Entry<LocalDateTime, PatientAppointment> next = patientMap.firstEntry();
        System.out.println("Next Appointment: " + next.getValue());
    }

    private static void getLastAppointment() {
        if (patientMap.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        Map.Entry<LocalDateTime, PatientAppointment> last = patientMap.lastEntry();
        System.out.println("Last Appointment: " + last.getValue());
    }
}
