/*✅ Use Case: Manage Scheduled Appointments in Sorted Order
🎯 Scenario:
In a hospital system, patients book appointments. Each appointment has a date and time. The hospital wants to:
Maintain sorted appointments (by date/time).
Avoid duplicate appointment entries.
Display all appointments in chronological order.
 */
 


package Cls_work;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Appointment implements Comparable<Appointment> {
    private int patientId;
    private String patientName;
    private LocalDateTime appointmentTime;

    public Appointment(int patientId, String patientName, LocalDateTime appointmentTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    // Compare by appointment time to maintain sorted order
    @Override
    public int compareTo(Appointment other) {
        return this.appointmentTime.compareTo(other.appointmentTime);
    }

    // Equals and hashCode based only on appointmentTime to prevent duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return appointmentTime.equals(that.appointmentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentTime);
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + patientName + ", Time: " + appointmentTime;
    }
}

public class HospitalAppointmentManager {

    private static TreeSet<Appointment> appointments = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        boolean loop = true;
        while (loop) {
            System.out.println("\n===== Hospital Appointment Scheduler =====");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter Appointment Date & Time (yyyy-MM-dd HH:mm): ");
                        String dateTimeInput = sc.nextLine();
                        LocalDateTime appointmentTime = LocalDateTime.parse(dateTimeInput, formatter);

                        System.out.print("Enter Patient ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Patient Name: ");
                        String name = sc.nextLine();

                        Appointment appt = new Appointment(id, name, appointmentTime);

                        if (appointments.contains(appt)) {
                            System.out.println("❌ Appointment already exists at this time.");
                        } else {
                            appointments.add(appt);
                            System.out.println("✅ Appointment added.");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Invalid input. Please follow the correct format.");
                    }
                }
                case 2 -> {
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments scheduled.");
                    } else {
                        System.out.println("\n📅 Scheduled Appointments:");
                        for (Appointment a : appointments) {
                            System.out.println(a);
                        }
                    }
                }
                case 3 -> loop = false;
                default -> System.out.println("❌ Invalid choice.");
            }
        }
        sc.close();
        System.out.println("Exiting Appointment Scheduler.");
    }
}
