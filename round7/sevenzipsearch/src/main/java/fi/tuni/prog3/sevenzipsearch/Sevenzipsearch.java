package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

import net.sf.sevenzipjbinding.*;

public class SearchIn7zFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File: ");
        String archiveFileName = scanner.nextLine();
        System.out.print("Query: ");
        String searchWord = scanner.nextLine();
        System.out.println();

        try {
            SevenZip.initSevenZipFromPlatformJAR();

            File archiveFile = new File(archiveFileName);

            if (!archiveFile.exists() || !archiveFile.isFile() || !archiveFile.getName().endsWith(".7z")) {
                System.err.println("Invalid 7z file.");
                return;
            }

            IInArchive archive = SevenZip.openInArchive(null, new RandomAccessFile(archiveFile, "r"));

            if (archive == null) {
                System.err.println("Failed to open the 7z archive.");
                return;
            }

            for (ISimpleInArchiveItem item : archive.getSimpleInterface().getArchiveItems()) {
                if (item.getPath().toLowerCase().endsWith(".txt")) {
                    System.out.println("File: " + item.getPath());
                    searchInTextFile(item, searchWord);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchInTextFile(ISimpleInArchiveItem item, String searchWord) throws Exception {
        InputStream inputStream = item.getExtractableData();
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