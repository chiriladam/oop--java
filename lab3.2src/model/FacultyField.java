package model;

/**
 * Enumeration of possible faculty fields. Add or modify fields as required.
 */
public enum FacultyField {
    SOFTWARE_ENGINEERING,
    FOOD_TECHNOLOGY,
    MECHANICS,
    ELECTRONICS,
    BUSINESS,
    OTHER;

    // Try to parse a string into a FacultyField; returns OTHER if not matched
    public static FacultyField fromString(String s) {
        if (s == null) return OTHER;
        try {
            return FacultyField.valueOf(s.trim().toUpperCase().replace(' ', '_'));
        } catch (Exception e) {
            return OTHER;
        }
    }
}
