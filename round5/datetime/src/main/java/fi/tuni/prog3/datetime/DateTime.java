/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fi.tuni.prog3.datetime;

/**
 *
 * @author vudinhthi2304
 */
public class DateTime {
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;

    public DateTime (int year, int month, int day, int hour, int minute, int second){
        new Date(year, month, day);
        try {
            // Some code that might throw a DateException
            throw new DateException("Illegal time ");
        } catch (DateException e) {
            if (hour > 24 || minute > 60 || second > 60){
                System.err.println(e.getMessage()+String.format("%02d.%02d.%02d", hour, minute, second));
            }
        }
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }

    public int getSecond(){
        return second;
    }
    
    public String toString(){
        String formattedDateTime = super.toString()+" "+String.format("%02d.%02d.%02d", hour, minute, second);
        return formattedDateTime;
    }




}
