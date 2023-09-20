/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fi.tuni.prog3.studentregister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vudinhthi2304
 */
public class StudentRegister {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Attainment> attainments;

    public StudentRegister(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
        attainments = new ArrayList<>();
    };

    public ArrayList<Student> getStudents() {
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        
        Collections.sort(sortedStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });

        return sortedStudents;
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> sortedCourses = new ArrayList<>(courses);
        
        Collections.sort(sortedCourses, new Comparator<Course>() {
            public int compare(Course course1, Course course2) {
                return course1.getName().compareTo(course2.getName());
            }
        });

        return sortedCourses;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void addAttainment(Attainment att){
        attainments.add(att);
    }

    public void printStudentAttainments(String studentNumber, String order) {
        String studentName = null;
    
        for (Student student : students) {
            if (studentNumber == student.getStudentNumber()){
                studentName = student.getName();
            }
        }

        if (studentName == null) {
            System.out.println("Unknown student number: "+studentNumber);
            return;
        } 

        System.out.println(studentName+" ("+studentNumber+"):");
        ArrayList<Attainment> personal_attainments = new ArrayList<>();;
        for (Attainment attainment : attainments) {
            if (studentNumber == attainment.getStudentNumber()){
                personal_attainments.add(attainment);
            }
        }
        if (order == "by code"){
            ArrayList<Attainment> sortedAttainmentbyCode = new ArrayList<>(personal_attainments);

            Collections.sort(sortedAttainmentbyCode, new Comparator<Attainment>() {
                public int compare(Attainment attainment1, Attainment attainment2) {
                    return attainment1.getCourseCode().compareTo(attainment2.getCourseCode());
                }
            });
            for (Attainment attainment : sortedAttainmentbyCode){
                System.out.println("  "+attainment.getCourseCode()
                                    +" "+getCourseNamefromCode(attainment.getCourseCode())+": "
                                    +attainment.getGrade());
            }
        } else if (order == "by name"){
            ArrayList<Attainment> sortedAttainmentbyName = new ArrayList<>(personal_attainments);

            Collections.sort(sortedAttainmentbyName, new Comparator<Attainment>() {
                public int compare(Attainment attainment1, Attainment attainment2) {
                    return getCourseNamefromCode(attainment1.getCourseCode()).compareTo(getCourseNamefromCode(attainment2.getCourseCode()));
                }
            });
            for (Attainment attainment : sortedAttainmentbyName){
                System.out.println("  "+attainment.getCourseCode()
                                    +" "+getCourseNamefromCode(attainment.getCourseCode())+": "
                                    +attainment.getGrade());
            }
        } else {
            for (Attainment attainment : personal_attainments){
                System.out.println("  "+attainment.getCourseCode()
                                    +" "+getCourseNamefromCode(attainment.getCourseCode())+": "
                                    +attainment.getGrade());
            }
        }
        
    }  

    public void printStudentAttainments(String studentNumber) {
        String studentName = null;
    
        for (Student student : students) {
            if (studentNumber == student.getStudentNumber()){
                studentName = student.getName();
            }
        }

        if (studentName == null) {
            System.out.println("Unknown student number: "+studentNumber);
            return;
        } 

        System.out.println(studentName+" ("+studentNumber+"):");
        ArrayList<Attainment> personal_attainments = new ArrayList<>();;
        for (Attainment attainment : attainments) {
            if (studentNumber == attainment.getStudentNumber()){
                personal_attainments.add(attainment);
            }
        }
        for (Attainment attainment : personal_attainments){
                System.out.println("  "+attainment.getCourseCode()
                                    +" "+getCourseNamefromCode(attainment.getCourseCode())+": "
                                    +attainment.getGrade());
            }

    }

    private String getCourseNamefromCode(String courseCode){
        for (Course course : courses) {
            if (courseCode == course.getCode()){
                return course.getName();
            }
        }
        return null;
    }
    
}







