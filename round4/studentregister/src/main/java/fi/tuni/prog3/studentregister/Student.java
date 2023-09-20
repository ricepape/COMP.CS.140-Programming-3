/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

/**
 *
 * @author vudinhthi2304
 */
public class Student {
    private final String name;
    private final String studentNumber;
    
    public Student (String name, String studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
    }
    
    public String getName(){
        return name;
    }
    
    public String getStudentNumber(){
        return studentNumber;
    }
    
}

