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
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int userChoice = newIn.getInt();

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

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        // creating
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
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Displays Entire list of names & addresses
        System.out.println("\n------------------------------");
        System.out.println("Name           | Phone number");
        System.out.println("------------------------------");

//        for (String contact : contactList){
//            String seperator = "";
//            //System.out.println(contact);
//            //String[] getWords = contact.split("\\s+");
//            for(String sep: contact.split("\\s+")){
//                seperator = seperator + "" + sep;
//
//            }
//            System.out.println(seperator);
//        }

        for (String contact : contactList){
            String[] parts = contact.split(" ");
            String part1 = parts[0] + " " + parts[1];
            String part2 = parts[2];
            System.out.println(part1 + " | " + part2 + " |");
        }

    }

    public static void addContact () {
        Input newIn = new Input();

        String pName = newIn.getString("Enter First & Last Name: ");
        int pNumber = newIn.getInt("Enter Number: ");

        // getting
        String directory = "address-book";
        String filename = "contacts.text";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        // creating
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

    public static void searchContact () {
        Input newIn = new Input();
        String findName = newIn.getString("Enter First & Last Name: ");

        // getting
        String directory = "address-book";
        String filename = "contacts.text";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        // reading
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Searches for user input(findName) against array of addresses(listStuff)
        for (int i =0; i < contactList.size(); i++){
           if (contactList.get(i).contains(findName)){
               System.out.println("\n-------------------------------");
               System.out.println(contactList.get(i));
               System.out.println("-------------------------------");
            }
        }
    }

    public static void deleteContact () {

    }
}
