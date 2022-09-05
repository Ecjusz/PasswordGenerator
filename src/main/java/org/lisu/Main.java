package org.lisu;

import java.util.Random;
import java.util.Scanner;

public class Main {
    @Override
    public String toString() {
        return "Main{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {


        System.out.println(PasswordBuilder());

    }

    public static String PasswordBuilder(){
        int numOfSigns;
        boolean ifBigCase;
        boolean ifDigits;
        boolean ifSpecialSigns;
        final String digits = "0123456789";
        String pool = "qwertyuiopasdfghjklzxcvbnm";
        final String bigCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        final String specials = "~!@#$%^&*()_+{}:|<>?-=[];'./,'";
        String password = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Generator");
        System.out.println("How many signs?");
        numOfSigns = scanner.nextInt();
        System.out.println("Big Case signs? (y/n)");
        String big = scanner.next();
        System.out.println("Digits as signs? (y/n)");
        String digit = scanner.next();
        System.out.println("Special signs? (y/n)");
        String special = scanner.next();

        ifBigCase = big.equals("y");
        ifDigits = digit.equals("y");
        ifSpecialSigns = special.equals("y");

        if (ifBigCase){
            pool += bigCase;
        } if (ifDigits){
            pool += digits;
        } if (ifSpecialSigns){
            pool += specials;
        }

        int total = pool.length();

        for (int i = 0; i < numOfSigns; i++){
                Random r = new Random();
                int randomNumber = r.ints(numOfSigns, 0, total).findFirst().getAsInt();
                char letter = pool.charAt(randomNumber);
                password += letter;
            }
        return password;
    }
}
