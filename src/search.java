import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class search {
    public static void searchContact(Path dataFile, Input newIn) {
        String findName = newIn.getString("Enter First & Last Name: ");

        // reading
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Searches for user input(findName) against array of addresses(listStuff)
        for (int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).contains(findName)){
                System.out.println("\n-------------------------------");
                System.out.println(contactList.get(i));
                System.out.println("-------------------------------");
            }
        }
    }
}
