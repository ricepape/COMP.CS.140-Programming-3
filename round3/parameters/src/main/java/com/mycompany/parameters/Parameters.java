/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author vudinhthi2304
 */
public class Parameters {

    public static void main(String[] args) throws IOException {

        ArrayList<String> string = new ArrayList<>();
        int width = 0;
        
        try (var input = new BufferedReader(new FileReader("tpthvu/round3/parameters/src/main/java/com/mycompany/parameters/input.txt"))) {

            String line;
            while ((line = input.readLine()) != null) {
                string.add(line);
                if (width < line.length()) {
                    width = line.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String amount = Integer.toString(string.size());

        Collections.sort(string);
        for (int i = 0; i < (width + amount.length() + 3); i++) {
            System.out.print("#");
        }
        System.out.println();
        for (int i = 0; i < string.size(); i++) {
            System.out.format("#%2d|%-"+width+"s#\n", i + 1, string.get(i));
            System.out.print("#");
            if (i < string.size() - 1) {
                for (int k = 0; k < amount.length(); k++){
                    System.out.print("-");
                }
                System.out.print("+");
                for (int j = 0; j < width; j++) {
                    System.out.print("-");
                }
                System.out.print("#\n");
            }
        }
        
        for (int i = 0; i < (width + amount.length() + 3); i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
