/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

/**
 *
 * @author vudinhthi2304
 */
public class Attainment {
    private final String courseCode;
    private final String studentNumber;
    private final int grade;

    public Attainment (String courseCode, String studentNumber, int grade){
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public String getCourseCode(){
        return courseCode;
    }
    
    public String getStudentNumber(){
        return studentNumber;
    }

    public int getGrade(){
        return grade;
    }
}
