package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class displayAll {
    public static void addressDisplay(Path dataFile){
        // Set Path

        // Reading files
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Displays Entire list of names & addresses
        System.out.println("\n---------------------------");
        System.out.println("    Name    | Phone number ");
        System.out.println("---------------------------");

        // Sort through each contact name & number as a String
        for (String contact : contactList){
            // Split name and separate | number |
            String[] parts = contact.split(" ");
            String part1 = parts[0] + " " + parts[1];
            String part2 = parts[2];
            System.out.println(part1 + " | " + part2 + " |");
        }
    }
}
