package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String csvFilePath = "dataset/dataset.csv";
        String delimiter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String header = reader.readLine();
            if (header == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            String[] headers = header.split(delimiter);
            System.out.println("=== Data Preview ===\n");
            System.out.println("Columns:");
            for (String h : headers) {
                System.out.print(h + " ");
            }
            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                System.out.println(String.join(" ", fields));
                count++;
                if (count == 5) break;
            }

            while (reader.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            System.err.println("Error reading the CSV file:");
            e.printStackTrace();
        }
    }
}
