/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.median;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author vudinhthi2304
 */
public class Median {

    public static void main(String[] args) throws IOException {
       System.out.println("Enter numbers:");
       ArrayList<Double> median_string = new ArrayList<>();
        try (Scanner myScanner = new Scanner(System.in)) {
            String line = myScanner.nextLine();
            
            // The the numbers input
            String[] numbers = line.split(" ");
        
            // Add the numbers to the array
            for (String s : numbers) {
                double d = Double.parseDouble(s);
                median_string.add(d);
            }

            Collections.sort(median_string);

            Double median;
            Integer middle = median_string.size()/2;

            if ((median_string.size() % 2) == 0) {
                median = (median_string.get(middle)+median_string.get(middle-1))/2;
            } else {
                median = median_string.get(middle);
            }
            System.out.println("Median: " + median);
                

        }
    }
}
