package ui;

import manager.SaveManager;
import model.FacultyField;
import model.Student;
import system.University;

import java.util.List;
import java.util.Scanner;

/**
 * ProgramLoop provides a simple text-based interactive menu to manage the university.
 * It loads saved state at start and saves after any change (create faculty, enroll, graduate).
 */
public class ProgramLoop {

    private University university;
    private Scanner scanner;

    public ProgramLoop() {
        // Load saved state (grade 9 requirement)
        university = SaveManager.load();
        scanner = new Scanner(System.in);
    }

    // Starts the interactive loop
    public void start() {
        System.out.println("Welcome to the TUM Student Management temporary system.");
        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    generalOperations();
                    break;
                case "2":
                    facultyOperations();
                    break;
                case "0":
                    System.out.println("Exiting... Saving state.");
                    SaveManager.save(university);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Goodbye.");
    }

    // Main menu
    private void printMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1 - General operations (faculties)");
        System.out.println("2 - Faculty operations (students)");
        System.out.println("0 - Exit");
        System.out.print("Choose: ");
    }

    // General operations menu
    private void generalOperations() {
        System.out.println("\nGeneral Operations:");
        System.out.println("1 - Create a new faculty");
        System.out.println("2 - Search what faculty a student belongs to (by email)");
        System.out.println("3 - Display all faculties");
        System.out.println("4 - Display faculties by field");
        System.out.println("0 - Back");
        System.out.print("Choose: ");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1":
                createFaculty();
                break;
            case "2":
                searchStudentFaculty();
                break;
            case "3":
                displayAllFaculties();
                break;
            case "4":
                displayFacultiesByField();
                break;
            case "0":
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Faculty operations menu
    private void facultyOperations() {
        System.out.println("\nFaculty Operations:");
        System.out.println("1 - Create & assign a student to a faculty");
        System.out.println("2 - Graduate a student from a faculty");
        System.out.println("3 - Display current enrolled students (graduates ignored)");
        System.out.println("4 - Display graduates");
        System.out.println("5 - Check if a student belongs to this faculty");
        System.out.println("0 - Back");
        System.out.print("Choose: ");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1":
                enrollStudent();
                break;
            case "2":
                graduateStudent();
                break;
            case "3":
                displayEnrolled();
                break;
            case "4":
                displayGraduates();
                break;
            case "5":
                checkBelongs();
                break;
            case "0":
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Create faculty
    private void createFaculty() {
        System.out.print("Enter faculty name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter field (e.g. SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY): ");
        String fieldStr = scanner.nextLine().trim();
        FacultyField field = FacultyField.fromString(fieldStr);
        boolean ok = university.createFaculty(name, field);
        if (ok) {
            System.out.println("Faculty '" + name + "' created.");
            SaveManager.save(university);
        } else {
            System.out.println("Faculty with that name already exists.");
        }
    }

    // Search a student's faculty by email
    private void searchStudentFaculty() {
        System.out.print("Enter student email to search: ");
        String email = scanner.nextLine().trim();
        String fac = university.findFacultyOfStudent(email);
        if (fac == null) {
            System.out.println("Student not found in any faculty.");
        } else {
            System.out.println("Student belongs to faculty: " + fac);
        }
    }

    // Display all faculties
    private void displayAllFaculties() {
        List<?> facs = university.listFaculties();
        if (facs.isEmpty()) {
            System.out.println("No faculties yet.");
            return;
        }
        System.out.println("Faculties:");
        for (Object f : facs) {
            System.out.println("- " + f.toString());
        }
    }

    // Display faculties filtered by field
    private void displayFacultiesByField() {
        System.out.print("Enter field name: ");
        String fieldStr = scanner.nextLine().trim();
        FacultyField field = FacultyField.fromString(fieldStr);
        List<?> facs = university.listFacultiesByField(field);
        if (facs.isEmpty()) {
            System.out.println("No faculties in that field.");
            return;
        }
        System.out.println("Faculties in " + field + ":");
        for (Object f : facs) {
            System.out.println("- " + f.toString());
        }
    }

    // Enroll new student
    private void enrollStudent() {
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine().trim();
        if (university.getFacultyByName(facultyName) == null) {
            System.out.println("Faculty not found.");
            return;
        }
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();
        System.out.print("Enter student email (unique): ");
        String email = scanner.nextLine().trim().toLowerCase();
        // Basic validation
        if (!email.contains("@")) {
            System.out.println("Invalid email format.");
            return;
        }
        // If student already exists in some faculty, warn
        String existing = university.findFacultyOfStudent(email);
        if (existing != null) {
            System.out.println("Student already exists in faculty: " + existing);
            return;
        }
        Student s = new Student(studentName, email);
        boolean ok = university.assignStudentToFaculty(facultyName, s);
        if (ok) {
            System.out.println("Student enrolled in " + facultyName + ".");
            SaveManager.save(university);
        } else {
            System.out.println("Could not enroll student (already enrolled?).");
        }
    }

    // Graduate a student from a faculty
    private void graduateStudent() {
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine().trim();
        if (university.getFacultyByName(facultyName) == null) {
            System.out.println("Faculty not found.");
            return;
        }
        System.out.print("Enter student email to graduate: ");
        String email = scanner.nextLine().trim().toLowerCase();
        boolean ok = university.graduateStudentFromFaculty(facultyName, email);
        if (ok) {
            System.out.println("Student graduated from " + facultyName + ".");
            SaveManager.save(university);
        } else {
            System.out.println("Student not found among enrolled students in this faculty.");
        }
    }

    // Display enrolled students of a faculty
    private void displayEnrolled() {
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine().trim();
        List<?> students = university.listEnrolledStudents(facultyName);
        if (students.isEmpty()) {
            System.out.println("No enrolled students or faculty not found.");
            return;
        }
        System.out.println("Enrolled students in " + facultyName + ":");
        for (Object s : students) {
            System.out.println("- " + s.toString());
        }
    }

    // Display graduates of a faculty
    private void displayGraduates() {
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine().trim();
        List<?> grads = university.listGraduates(facultyName);
        if (grads.isEmpty()) {
            System.out.println("No graduates or faculty not found.");
            return;
        }
        System.out.println("Graduates of " + facultyName + ":");
        for (Object s : grads) {
            System.out.println("- " + s.toString());
        }
    }

    // Check if a student belongs to a faculty
    private void checkBelongs() {
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine().trim();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine().trim().toLowerCase();
        boolean ok = university.facultyHasStudent(facultyName, email);
        if (ok) {
            System.out.println("Yes, the student belongs to this faculty (either enrolled or graduated).");
        } else {
            System.out.println("No, the student does not belong to this faculty.");
        }
    }
}
