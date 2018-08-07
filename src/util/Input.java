package util;

import java.util.Scanner;

public class Input {
    //private available only in this Class
    private Scanner scanner = new Scanner(System.in);

    public String consumeLine(){
        return this.scanner.nextLine();
    }

    public String getWord(String prompt){
        System.out.print(prompt);
        return this.scanner.next();
    }

    public String getString(String prompt){
        System.out.print(prompt);
        return this.scanner.nextLine();
    }

    public String getString(){
        System.out.print("type something: ");
        return this.scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.print("\nWant to continue? (yes/no): ");
        String proceed = this.scanner.next();
        //if user types 'yes' or 'y' will return true
        return (proceed.equalsIgnoreCase("y") || proceed.equalsIgnoreCase("yes"));
    }

    public int getInt(int min, int max){
        boolean keepAsking = true;
        int userNum = 0;
        while(keepAsking) {
            System.out.print("\nEnter number within " + min + " - " + max + " : ");
            userNum = this.scanner.nextInt();
            if (userNum >= min && userNum <= max) {
                keepAsking = false;
            }
        }
        return userNum;
    }

    public int getInt(String prompt){
        int realNum = 0;
        boolean correctNum = true;
        while(correctNum){
            try {
                System.out.print("\n" + prompt);
                String userNum = this.scanner.nextLine();
                Integer.valueOf(userNum);
                realNum = Integer.parseInt(userNum);
                correctNum = false;
            } catch (Exception e){
                System.out.println(e.fillInStackTrace());
                System.out.println("Not a valid number, please try again...");
            }
        }
        return realNum;
    }

    public int getInt(){
        int realNum;
                      //Uses .getString() to save input String
        String userNum = this.getString("\nPick a number: ");
            try {
                realNum = Integer.valueOf(userNum);
            } catch (Exception e){
                System.out.println(e.fillInStackTrace());
                System.out.println("Not a valid number, please try again...");
                realNum = getInt(); //Recursion, will repeat method if it keeps failing
            }
        return realNum;
    }

    public double getDouble(double min, double max){
        boolean keepAsking = true;
        double userNum = 0;
        while(keepAsking) {
            System.out.print("\nEnter number within " + min + " - " + max + " : ");
            userNum = this.scanner.nextDouble();
            if (userNum >= min && userNum <= max) {
                keepAsking = false;
            }
        }
        return userNum;
    }

    public double getDouble(){
        boolean correctNum = true;
        double realNum = 0;
        while(correctNum){
            System.out.print("\nEnter a number (double): ");
            String userNum = this.scanner.nextLine();
            try {
                realNum = Double.parseDouble(userNum);
                correctNum = false;
            } catch(Exception e) {
                System.out.println(e.fillInStackTrace());
                System.out.println("Not a valid number, please try again...");
            }
        }
        return realNum;
    }
//    ========================== Bonus ============================
//    public int getBinary(){
//
//    }
//
//    public int getHex(){
//
//    }
}
