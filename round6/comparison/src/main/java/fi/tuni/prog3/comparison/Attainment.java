package fi.tuni.prog3.comparison;

import java.util.Comparator;


public class Attainment implements Comparable<Attainment> {
    private final String courseCode;
    private final String studentNumber;
    private final int grade;

    public Attainment(String courseCode, String studentNumber, int grade) {
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

    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment attainment1, Attainment attainment2) {
            int courseCodeComparison = attainment1.courseCode.compareTo(attainment2.courseCode);
            if (courseCodeComparison != 0) {
                return courseCodeComparison;
            }
            return Integer.compare(attainment2.grade, attainment1.grade);
        }
    };

    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment attainment1, Attainment attainment2) {
            int courseCodeComparison = attainment1.courseCode.compareTo(attainment2.courseCode);
            if (courseCodeComparison != 0) {
                return courseCodeComparison;
            }
            return Integer.compare(Integer.parseInt(attainment2.studentNumber), 
                                    Integer.parseInt(attainment1.studentNumber));
        }
    };
}