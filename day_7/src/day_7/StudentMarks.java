package day_7;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();

	    System.out.println("Enter number of students: ");
	    int count = sc.nextInt();
	    
	    for (int i = 0; i < count; i++) {
            System.out.println();
            System.out.println("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
         
            System.out.println("Enter marks of student " + (i + 1) + ": ");
            int primitiveMarks = sc.nextInt(); 
            Integer marks = Integer.valueOf(primitiveMarks);
            
            Student student = new Student(name,marks);
            students.add(student);
            
            System.out.println("\n--- Student Marks List ---");
            for (Student s : students) 
            {
                s.display();
            }
            Integer total = 0;
            for (Student s : students)
            {
                total += s.getMarks();
            }
            Double average = total.doubleValue() / students.size();
            System.out.println("\nAverage Marks: " + average);
	    }    
	    
	    }
}
