package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Faculty holds information about a faculty: name, field, enrolled students and graduates.
 * Provides methods to enroll, graduate and query students.
 */
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private FacultyField field;

    // enrolled students (currently studying)
    private List<Student> enrolled;

    // graduates (students who graduated)
    private List<Student> graduates;

    public Faculty(String name, FacultyField field) {
        this.name = name;
        this.field = field;
        this.enrolled = new ArrayList<>();
        this.graduates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public FacultyField getField() {
        return field;
    }

    // Adds a student to enrolled list if not already present (by email)
    public boolean enrollStudent(Student s) {
        if (hasStudentInEnrolled(s.getEmail())) return false;
        enrolled.add(s);
        return true;
    }

    // Moves a student from enrolled to graduates list by email; returns true if successful
    public boolean graduateStudentByEmail(String email) {
        Student found = null;
        for (Student s : enrolled) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                found = s;
                break;
            }
        }
        if (found != null) {
            enrolled.remove(found);
            graduates.add(found);
            return true;
        }
        return false;
    }

    // Check if student is enrolled
    public boolean hasStudentInEnrolled(String email) {
        for (Student s : enrolled) {
            if (s.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }

    // Check if a student is a graduate
    public boolean hasStudentInGraduates(String email) {
        for (Student s : graduates) {
            if (s.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }

    // Return a copy of enrolled list for safe iteration
    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolled);
    }

    // Return a copy of graduates list
    public List<Student> getGraduates() {
        return new ArrayList<>(graduates);
    }

    @Override
    public String toString() {
        return name + " (" + field + ") - Enrolled: " + enrolled.size() + ", Graduates: " + graduates.size();
    }
}
