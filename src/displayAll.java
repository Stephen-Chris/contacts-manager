import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class displayAll {
    public static void addressDisplay(Path dataFile){
        // Reading files
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Displays Entire list of names & addresses
        System.out.println("\n-------------------------------");
        System.out.println("     Name    |  Phone number ");
        System.out.println("-------------------------------");

        // Sort through each contact name & number as a String
        for (String contact : contactList){
            // Split name and separate | number |
            String[] parts = contact.split(" ");
            String fullName = parts[0] + " " + parts[1];
            String telephone = String.valueOf(parts[2]).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            System.out.printf("%-12s | %-14s | %n", fullName, telephone);
        }
    }
}
