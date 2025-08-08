public class jaggedArray {
    public static void main(String[] args) {
       
        String[][] employeeProjects = new String[3][];

        // Assigning projects
        employeeProjects[0] = new String[] {"Pro M", "Pro N"};
        employeeProjects[1] = new String[] {"Project a", "Project b", "Project c"};
        employeeProjects[2] = new String[] {"Project k"};

        // Display the projects assigned to each employee
        for (int i = 0; i < employeeProjects.length; i++) {
            System.out.println("Employee " + (i + 1) + " is assigned to:");
            for (int j = 0; j < employeeProjects[i].length; j++) {
                System.out.println("  - " + employeeProjects[i][j]);
            }
            System.out.println();
        }
    }
}
