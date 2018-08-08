import util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Input newIn = new Input();
       options(newIn);
    }

    public static void options(Input newIn) {


        // Set Path
        String directory = "address-book";
        String filename = "contacts.text";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if(Files.notExists(dataDirectory)) {
            try {
                Files.createDirectory(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        do {
            System.out.println();
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int userChoice = newIn.getInt();

            if (userChoice == 1) {
                displayAll.addressDisplay(dataFile);
            } else if (userChoice == 2) {
                addContact.newContact(dataFile, newIn);
            } else if (userChoice == 3) {
                search.searchContact(dataFile, newIn);
            } else if (userChoice == 4) {
                deleteContact.eraseContact(dataFile, newIn);
            } else if (userChoice == 5) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }while (true);
    }


}
