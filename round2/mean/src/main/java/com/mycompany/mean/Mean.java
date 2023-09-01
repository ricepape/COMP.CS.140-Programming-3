/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mean;

/**
 *
 * @author Thi Vu
 * 
 */

import java.util.Scanner;

public class Mean {

    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        try (Scanner myScanner = new Scanner(System.in)) {
            String line = myScanner.nextLine();
            
            String[] numbers = line.split(" ");
            
            double sum = 0.0;
            int count = 0;
            for (String s : numbers) {
                double d = Double.parseDouble(s);
                sum += d;
                count +=1;
            }
            double mean = sum/count;
            
            System.out.println("Mean: " + mean);
        } 
    }
}
