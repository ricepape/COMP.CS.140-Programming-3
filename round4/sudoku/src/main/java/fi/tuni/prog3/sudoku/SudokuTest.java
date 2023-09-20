package fi.tuni.prog3.sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuTest {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String line;
            Sudoku sudoku = new Sudoku();
            while((line = reader.readLine()) != null){ ;
                for (int i = 0; i < line.length(); i++){
                    Sudoku.set(i / 9, i % 9, line.charAt(i));
                }
                Sudoku.print();
                if(Sudoku.check()){
                    System.out.println("The sudoku is legal.");    
                };
                System.out.println();
            }
        }
    }
}
