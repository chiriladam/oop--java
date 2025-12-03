package model;

import java.io.Serializable;

/**
 * Student represents a simple student with a name and a unique email identifier.
 * Implements Serializable so it can be saved to disk.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email; // unique identifier

    public Student(String name, String email) {
        this.name = name;
        this.email = email.toLowerCase(); // store lower-case for consistency
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // A compact, readable representation for printing
    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}
