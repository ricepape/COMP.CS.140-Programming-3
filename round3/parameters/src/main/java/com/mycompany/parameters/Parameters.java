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
        
        try (var input = new BufferedReader(new FileReader("input.txt"))) {
            int width = 0;
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
        Collections.sort(string);
        System.out.format("#%2d|%{width}s#", "#", "#");
        for (int i = 1; i <= string.size() ; i++) {
            System.out.format("#%2d|%{width}s#", i, string.get(i-1));
            System.out.format("#%2s+%{width}s#", "-", "-");
        }
        System.out.format("#%2d|%{width}s#", "#", "#");
    }
}
