import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class addContact {
    public static void newContact(Path dataFile, Input newIn) {
        String firstN = newIn.getWord("\nEnter First Name: ");
        newIn.consumeLine();
        String lastN = newIn.getWord("Enter Last Name: ");
        newIn.consumeLine();

        int pNumber = newIn.getInt("Enter Number: ");

        // writing
        List<String> names = new ArrayList<>();

        names.add(firstN + " " + lastN + " " + pNumber);
        try {
            Files.write(dataFile, names, StandardOpenOption.APPEND);
            System.out.println("\n------------------------------------");
            System.out.println("You added: " + firstN + " " + lastN + " " + pNumber);
            System.out.println("------------------------------------");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
