import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;
    private int nextId;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
        nextId = 1;
    }

    public void start() {
        System.out.println("=== Student Management System ===");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    displayStatistics();
                    break;
                case 7:
                    System.out.println("Thank you for using Student Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Display Statistics");
        System.out.println("7. Exit");
    }

    private void addStudent() {
        System.out.println("\n--- Add New Student ---");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        int age = getIntInput("Enter student age: ");
        
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        
        double gpa = getDoubleInput("Enter GPA (0.0 - 4.0): ");
        
        Student student = new Student(nextId++, name, age, course, gpa);
        students.add(student);
        
        System.out.println("Student added successfully!");
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Course");
        
        int searchChoice = getIntInput("Enter search choice: ");
        
        switch (searchChoice) {
            case 1:
                int id = getIntInput("Enter student ID: ");
                searchById(id);
                break;
            case 2:
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                searchByName(name);
                break;
            case 3:
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                searchByCourse(course);
                break;
            default:
                System.out.println("Invalid search choice!");
        }
    }

    private void searchById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }

    private void searchByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with name: " + name);
        }
    }

    private void searchByCourse(String course) {
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse().equalsIgnoreCase(course)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found in course: " + course);
        }
    }

    private void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int id = getIntInput("Enter student ID to update: ");
        
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Current details: " + student);
                
                System.out.print("Enter new name (current: " + student.getName() + "): ");
                String name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    student.setName(name);
                }
                
                int age = getIntInput("Enter new age (current: " + student.getAge() + "): ");
                student.setAge(age);
                
                System.out.print("Enter new course (current: " + student.getCourse() + "): ");
                String course = scanner.nextLine();
                if (!course.trim().isEmpty()) {
                    student.setCourse(course);
                }
                
                double gpa = getDoubleInput("Enter new GPA (current: " + student.getGpa() + "): ");
                student.setGpa(gpa);
                
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }

    private void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int id = getIntInput("Enter student ID to delete: ");
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                Student removed = students.remove(i);
                System.out.println("Student deleted: " + removed);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }

    private void displayStatistics() {
        System.out.println("\n--- Statistics ---");
        if (students.isEmpty()) {
            System.out.println("No students to analyze!");
            return;
        }
        
        int totalStudents = students.size();
        double totalGpa = 0;
        int maxAge = Integer.MIN_VALUE;
        int minAge = Integer.MAX_VALUE;
        
        for (Student student : students) {
            totalGpa += student.getGpa();
            maxAge = Math.max(maxAge, student.getAge());
            minAge = Math.min(minAge, student.getAge());
        }
        
        double averageGpa = totalGpa / totalStudents;
        
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Average GPA: " + String.format("%.2f", averageGpa));
        System.out.println("Youngest Age: " + minAge);
        System.out.println("Oldest Age: " + maxAge);
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.start();
    }
}
