import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = getValidIntegerInput();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    private static int getValidIntegerInput() {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    private static void addStudent() {
        System.out.print("Enter Student ID (string+number): ");
        String id = scanner.next();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.next();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new grade: ");
                String grade = scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.next();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
