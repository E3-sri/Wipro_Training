package cls_work;
import java.util.Scanner;

// Renamed to NotificationBase to avoid conflict
class NotificationBase {
    public void notifyUser(String message) {
        System.out.println("General Notification: " + message);
    }
}

// Renamed to EmailNotification
class EmailNotification extends NotificationBase {
    public void notifyUser(String message) {
        System.out.println("Email Notification Sent: " + message);
    }
}

// Renamed to SMSNotification
class SMSNotification extends NotificationBase {
    public void notifyUser(String message) {
        System.out.println("SMS Notification Sent: " + message);
    }
}

public class NotifyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = sc.nextLine();

        NotificationBase email = new EmailNotification();
        NotificationBase sms = new SMSNotification();

        email.notifyUser(message);
        sms.notifyUser(message);

        sc.close();
    }
}
