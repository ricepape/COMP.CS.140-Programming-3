/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 
package fi.tuni.prog3.sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author vudinhthi2304
 */
public class Sudoku {

    private static char[][] grid;

    public Sudoku() {
        // Initialize the 9x9 grid with empty cells
        grid = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public static void set (int i, int j, char c){
        if (Character.isDigit(c) || c == ' '){
            if (i>8){
                System.out.println("Trying to access illegal cell ("+i+", "+j+")!");
                return;
            }
            grid[i][j] = c;
            return;
        }
        else {
            System.out.println("Trying to set illegal character "+ c +" to ("+i+", "+j+")!");
        } 
    }

    public static void print (){
        System.out.println("Read the following sudoku:");
        for (int x = 0; x<37; x++){
            System.out.print("#");
        }
        System.out.println();
        for (int k = 3; k < 10; k = k+3 ){
            for (int i = k-3; i < k; i++){
                System.out.print("#");
                for (int j = 0; j < 9; j++){
                    System.out.format(" %c ",grid[i][j]);
                    if (j % 3 == 2){   
                        System.out.print("#");
                    }
                    else System.out.print("|");
                }
                System.out.println();
                if (i % 3 != 2){
                    System.out.print("#");
                    for (int j = 0; j < 3; j++) {
                        System.out.print("---+---+---#");
                    }
                    System.out.println();
                }
            }
        for (int x = 0; x<37; x++){
            System.out.print("#");
        }
        System.out.println();
        }
        
    }

    public static boolean check() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != ' ') {
                    for (int k = 0; k < 9; k++) {
                        if (grid[i][j] == grid[i][k] && k != j) {
                            System.out.println("Row " + (i) + " has multiple " + grid[i][j] + "'s!");
                            return false;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[j][i] != ' ') {
                    for (int k = 0; k < 9; k++) {
                        if (grid[j][i] == grid[k][i] && k != j) {
                            System.out.println("Column " + (i) + " has multiple " + grid[j][i] + "'s!");
                            return false;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (grid[x][y] != ' ') {
                            for (int m = i; m < i + 3; m++) {
                                for (int n = j; n < j + 3; n++) {
                                    if (grid[m][n] == grid[x][y] && (m != x || n != y)) {
                                        System.out.println("Block at (" + (i - i % 3) + "," + (j - j % 3) +
                                                    ") has multiple " + grid[x][y] + "'s!");
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } 
        return true;
    }
}



