package fi.tuni.prog3.junitattainment;

public class Attainment implements Comparable<Attainment> {
    private final String courseCode;
    private final String studentNumber;
    private final int grade;

    public Attainment(String courseCode, String studentNumber, int grade) {
        if (courseCode == null || studentNumber == null || grade < 0 || grade > 5) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return courseCode + " " + studentNumber + " " + grade;
    }

    public int compareTo(Attainment other) {
        int studentNumberComparison = this.studentNumber.compareTo(other.studentNumber);
        if (studentNumberComparison != 0) {
            return studentNumberComparison;
        }

        // If studentNumbers are the same, compare by courseCode
        return this.courseCode.compareTo(other.courseCode);
    }
}