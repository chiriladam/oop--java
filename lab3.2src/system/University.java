package system;

import model.Faculty;
import model.FacultyField;
import model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * University holds multiple faculties and offers operations to create faculties,
 * assign students, graduate them, and search which faculty a student belongs to.
 * Implements Serializable for persistence.
 */
public class University implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Faculty> faculties;

    public University() {
        this.faculties = new ArrayList<>();
    }

    // Create a new faculty; returns false if faculty with same name already exists
    public boolean createFaculty(String name, FacultyField field) {
        if (getFacultyByName(name) != null) return false;
        faculties.add(new Faculty(name, field));
        return true;
    }

    // Find a faculty by exact name (case-insensitive)
    public Faculty getFacultyByName(String name) {
        for (Faculty f : faculties) {
            if (f.getName().equalsIgnoreCase(name)) return f;
        }
        return null;
    }

    // Assign a student to a faculty by faculty name
    public boolean assignStudentToFaculty(String facultyName, Student s) {
        Faculty f = getFacultyByName(facultyName);
        if (f == null) return false;
        return f.enrollStudent(s);
    }

    // Graduate student by email from a given faculty
    public boolean graduateStudentFromFaculty(String facultyName, String studentEmail) {
        Faculty f = getFacultyByName(facultyName);
        if (f == null) return false;
        return f.graduateStudentByEmail(studentEmail);
    }

    // Display lists: return enrolled students in a faculty
    public List<Student> listEnrolledStudents(String facultyName) {
        Faculty f = getFacultyByName(facultyName);
        if (f == null) return new ArrayList<>();
        return f.getEnrolledStudents();
    }

    // Display graduates for a faculty
    public List<Student> listGraduates(String facultyName) {
        Faculty f = getFacultyByName(facultyName);
        if (f == null) return new ArrayList<>();
        return f.getGraduates();
    }

    // Check if a student belongs to a faculty (either enrolled or graduate)
    public boolean facultyHasStudent(String facultyName, String studentEmail) {
        Faculty f = getFacultyByName(facultyName);
        if (f == null) return false;
        return f.hasStudentInEnrolled(studentEmail) || f.hasStudentInGraduates(studentEmail);
    }

    // Search which faculty a student belongs to by email (returns faculty name or null)
    public String findFacultyOfStudent(String email) {
        for (Faculty f : faculties) {
            if (f.hasStudentInEnrolled(email) || f.hasStudentInGraduates(email)) {
                return f.getName();
            }
        }
        return null;
    }

    // List all faculties
    public List<Faculty> listFaculties() {
        return new ArrayList<>(faculties);
    }

    // List faculties by field
    public List<Faculty> listFacultiesByField(FacultyField field) {
        List<Faculty> out = new ArrayList<>();
        for (Faculty f : faculties) {
            if (f.getField() == field) out.add(f);
        }
        return out;
    }
}
