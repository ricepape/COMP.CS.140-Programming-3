package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public class Sevenzipsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File:");
        System.out.println("Query:");
        String archiveFileName = scanner.nextLine();
        String searchWord = scanner.nextLine();
        System.out.println();

        try {
            SevenZFile sevenZFile = new SevenZFile(new File(archiveFileName));

            SevenZArchiveEntry entry;
            while ((entry = sevenZFile.getNextEntry()) != null) {
                if (entry.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println(entry.getName());
                    searchInTextFile(sevenZFile, searchWord, entry);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close(); 
        }
    }

    private static void searchInTextFile(SevenZFile sevenZFile, String searchWord, SevenZArchiveEntry entry) throws Exception {
        InputStream inputStream = sevenZFile.getInputStream(entry);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            lineNumber++;

            if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                // Replace search word with uppercase
                String formattedLine = line.replaceAll("(?i)" + searchWord, searchWord.toUpperCase());
                System.out.println(lineNumber + ": " + formattedLine);
            }
        }

        reader.close();
    }
}