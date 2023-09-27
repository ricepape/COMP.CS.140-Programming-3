/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fi.tuni.prog3.datetime;

/**
 *
 * @author vudinhthi2304
 */
public class DateTime extends Date{
    private final int hour;
    private final int minute;
    private final int second;

    public DateTime (int year, int month, int day, int hour, int minute, int second) throws DateException{
        super(year, month, day);
        if (hour > 23 || minute > 59 || second > 59){
            throw new DateException("Illegal time "+String.format("%02d:%02d:%02d", hour, minute, second));
        }
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
