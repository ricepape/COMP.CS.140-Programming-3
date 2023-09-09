import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Parameters {

    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        int width = 0;

        System.out.println("Parameters: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read input until an empty line is entered
        while (true) {
            String line = reader.readLine();
            if (line.isEmpty()) {
                break;
            }
            strings.add(line);
            width = Math.max(width, line.length());
        }

        Collections.sort(strings);

        // Calculate the amount here, outside of the loop
        int amount = strings.size();

        // Print the header
        printHeader(width, amount);

        // Print the data
        for (int i = 0; i < strings.size(); i++) {
            System.out.format("# %"+Integer.toString(amount).length()+"d | %-" + width + "s #\n", i + 1, strings.get(i));
            if (i < strings.size() - 1) {
                printSeparator(width, amount);
            }
        }

        // Print the footer
        printHeader(width, amount);
    }

    // Helper method to print the header and footer
    private static void printHeader(int width, int amount) {
        for (int i = 0; i < (width + Integer.toString(amount).length() + 7); i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    // Helper method to print the separator between data entries
    private static void printSeparator(int width, int amount) {
        System.out.print("#-");
        for (int k = 0; k < Integer.toString(amount).length(); k++) {
            System.out.print("-");
        }
        System.out.print("-+--");
        for (int j = 0; j < width; j++) {
            System.out.print("-");
        }
        System.out.print("#\n");
    }
}