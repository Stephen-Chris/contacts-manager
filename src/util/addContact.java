package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class addContact {
    public static void newContact(Path dataFile, Input newIn) {


        String pName = newIn.getString("Enter First & Last Name: ");
        int pNumber = newIn.getInt("Enter Number: ");


        // writing
        List<String> names = new ArrayList<>();
        names.add(pName + " " + pNumber);
        try {
            Files.write(dataFile, names, StandardOpenOption.APPEND);
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n------------------------------------");
        System.out.println("You added: " + pName + " " + pNumber);
        System.out.println("------------------------------------");
    }
}
