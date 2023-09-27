/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.datetime;

/**
 *
 * @author vudinhthi2304
 */
public class Date {
    private final int year;
    private final int month;
    private final int day;

    public Date (int year, int month, int day) throws DateException{
        if (day >= 29) {
            if (month == 2) {
                if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
                    // This condition checks if it's not a leap year
                    throw new DateException("Illegal date "+String.format("%02d.%02d.%04d", day, month, year));
                }
            } else if (day == 31) {
                // Handle cases where day is 31 based on the month
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    throw new DateException("Illegal date "+ String.format("%02d.%02d.%04d", day, month, year));
                }
            } else if (day > 31 || month > 12){
                throw new DateException("Illegal date "+ String.format("%02d.%02d.%04d", day, month, year));
            }
        }
        
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }
    
    public String toString(){
        String formattedDate = String.format("%02d.%02d.%04d", day, month, year);
        return formattedDate;
    }

}

