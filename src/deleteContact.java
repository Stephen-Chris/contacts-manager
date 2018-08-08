import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class deleteContact {
    public static void eraseContact(Path dataFile, Input newIn) {
        String deleteName = newIn.getString("Fill in name to delete: ");

        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete name entered by user
        List<String> newList = new ArrayList<>();
        for (String contact : contactList) {
            if (contact.contains(deleteName)) {
                System.out.println("You deleted: " + deleteName);
                continue;
            }
            newList.add(contact);
        }

        try {
            Files.write(dataFile, newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
