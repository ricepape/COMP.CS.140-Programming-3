/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

/**
 *
 * @author vudinhthi2304
 */
public class Course {
    private final String code;
    private final String name;
    private final int credits;

    public Course (String code, String name, int credits){
        this.name = name;
        this.code = code;
        this.credits = credits;
    }

    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }

    public int getCredits(){
        return credits;
    }

}
