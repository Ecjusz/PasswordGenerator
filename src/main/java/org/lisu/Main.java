package org.lisu;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println(PasswordBuilder());

    }

    public static String PasswordBuilder(){
        int numberOfSigns;
        boolean ifBigCase;
        boolean ifDigits;
        boolean ifSpecialSigns;

        //Creating possible pools of signs, initializing empty password and new scanner.
        String pool = "qwertyuiopasdfghjklzxcvbnm";
        final String digits = "0123456789";
        final String bigCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        final String specials = "~!@#$%^&*()_+{}:|<>?-=[];'./,'";
        String password = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("PASSWORD GENERATOR");
        System.out.println("How many signs?");

        var numOfSigns = scanner.next();
        numberOfSigns = Integer.parseInt(numOfSigns);

        //Making sure that numOfSigns/numberOfSings is an Integer bigger than 0 (at least 1 sign).
        while (numberOfSigns < 1){
            System.out.println("Password has to have at least 1 sign. Try again");
            numOfSigns = scanner.next();
            numberOfSigns = Integer.parseInt(numOfSigns);
        }

    // Try-catch option but app is ending after putting illegal sign. //
    //  try
    //  {
    //      int signs = Integer.parseInt(numOfSigns);
    //      while (signs < 1 ){
    //          System.out.println("Password has to have at least 1 sign. Try again");
    //          numOfSigns = scanner.next();
    //          signs = Integer.parseInt(numOfSigns);
    //      }
    //      System.out.println("Password will have " + numOfSigns + " signs");
    //  }
    //  catch (NumberFormatException e)
    //  {
    //      System.out.println(numOfSigns + " is not a integer");
    //  }


        //Setting the pool of signs for password.
        System.out.println("Big Case signs? (y/n)");
        String big = scanner.next();
        System.out.println("Digits as signs? (y/n)");
        String digit = scanner.next();
        System.out.println("Special signs? (y/n)");
        String special = scanner.next();

        ifBigCase = big.equalsIgnoreCase("y");
        ifDigits = digit.equalsIgnoreCase("y");
        ifSpecialSigns = special.equalsIgnoreCase("y");

        if (ifBigCase){
            pool += bigCase;
        } if (ifDigits){
            pool += digits;
        } if (ifSpecialSigns){
            pool += specials;
        }

        int total = pool.length();

        //Drawing letters from set pool.
        for (int i = 0; i < numberOfSigns; i++){
                Random r = new Random();
                int randomNumber = r.ints(numberOfSigns, 0, total)
                        .findFirst()
                        .getAsInt();
                char letter = pool.charAt(randomNumber);
                password += letter;
            }
        return "This is your password: " + password;
    }

}
