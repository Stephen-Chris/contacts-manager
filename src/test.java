import util.Input;

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

        do {
            System.out.println();
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.\n");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");

            //Using Input getInt() method //scanner input
            int userChoice = newIn.getInt();
            //System.out.println();

            if (userChoice == 1) {
                addressDisplay();
            } else if (userChoice == 2) {
                addContact();
            } else if (userChoice == 3) {
                searchContact();
            } else if (userChoice == 4) {
                deleteContact();
            } else if (userChoice == 5) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

        }while (true);

//        for (Movie movie : MoviesArray.findAll()) {
//            String categories = movie.getCategory();
//            String movies = movie.getName();
//            String output = movies + " -- " + categories;
//
//            if (numChoice == 0) {
//                System.out.println("Thank you come again!");
//                System.exit(0);
//            } else if (numChoice == 1) {
//                System.out.println(output);
//            } else if (numChoice == 2 && categories.equalsIgnoreCase("animated")) {
//                System.out.println(output);
//            } else if (numChoice == 3 && categories.equalsIgnoreCase("drama")) {
//                System.out.println(output);
//            } else if (numChoice == 4 && categories.equalsIgnoreCase("horror")) {
//                System.out.println(output);
//            } else if (numChoice == 5 && categories.equalsIgnoreCase("scifi")) {
//                System.out.println(output);
//            }
//        }


        //addressSetUp();
    }

    public static void addressDisplay(){
        // getting


        String directory = "address-book";
        String filename = "contacts.text";

        // creating
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if(Files.notExists(dataDirectory)) {
            try{
                Files.createDirectories(dataDirectory);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(dataFile)){
            try {
                Files.createFile(dataFile);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        // Reading
        List<String> listStuff = null;
        try {
            listStuff = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i =0; i < listStuff.size(); i++){
            System.out.println((i + 1) + ": " + listStuff.get(i));
        }
    }

    public static void addContact () {
        // getting
        Input newIn = new Input();

        String name = newIn.getString("Enter First & Last Name:");


        int pNumber = newIn.getInt("Enter Number: ");

        String directory = "address-book";
        String filename = "contacts.text";

        // creating
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if(Files.notExists(dataDirectory)) {
            try{
                Files.createDirectories(dataDirectory);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        //        // writing
        List<String> names = new ArrayList<>();
        names.add(name + " " + pNumber);

        try {                           // NEED THIS TO NOT OVERWRITE FILE!!!
            Files.write(dataFile, names, StandardOpenOption.APPEND);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContact () {
        Input newIn = new Input();

        String findName = newIn.getString("Enter First & Last Name:");

        String directory = "address-book";
        String filename = "contacts.text";

        // creating
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);



        List<String> listStuff = null;
        try {
            listStuff = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i =0; i < listStuff.size(); i++){
           if (listStuff.get(i).contains(findName)){
               System.out.println(listStuff.get(i));

            }
        }

    }

    public static void deleteContact () {

    }
}
