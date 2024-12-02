package com.wince;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // int currentYear = 2024;

        // try {
        //     //With IntelliJ calling getInputFromConsole will throw a null pointer exception
        //     // because the IDE does not allow console.readLine
        //     //With visual studio code you can call getInputFromScanner because it allows it 
        //     // there will never be an exception to fall into catch so getInputFromScanner will
        //     // never get called.
        //     System.out.println(getInputFromScanner(currentYear));
        // } catch (NullPointerException e) {
        //     System.out.println(getInputFromScanner(currentYear));
        // }
        

        /*
        Challange 1: Read 5 valid numbers from the console entered by users and print sum
        of those 5 numbers.
        If not valid number, print out message "Invalid number" to the console but conintue
        looping until you have 5 valid numbers
        Before the user enters each number, prompt them with the message, "Enter number #x",
        where x represents the count 1, 2, 3 etc.
        */
        //System.out.println(getInputAndPrintSumScanner());

        /*
        Challange 2: Use an endless loop: 
        Prompt user to enter a number or any character to quit.
        Validate if user entered data is a number.
        If user data is not a number, quit the loop.
        Keep track of minimum number entered.
        Keep track of maximum number entered.
        Display the minimum and maximum number that user entered.
         */
        //System.out.println(getMinMaxChallangeScanner());

        System.out.println(getMinMaxChallangeAlternateSolution());

    }
    
    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, What's your name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course!");
        
        String dateOfBirth = System.console().readLine("What year were you born?");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, What's your name? ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", Thanks for taking the course!");

        System.out.println("What year were you born? ");

        boolean validDOB = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " +
                    (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age < 0 ? false : true;
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed!!! Try again.");
            }
        } while (!validDOB);

        // To run all methods, comment all but last call to below for each but last method
        //scanner.close();

        return "So you are " + age + " years old";
    }
    
    public static String getInputAndPrintSumScanner() {

        Scanner scanner = new Scanner(System.in);

        int counter = 1;
        int sum = 0;

        System.out.println("Please enter 5 valid numbers");

        while (counter <= 5) {
            System.out.println("Enter number #" + counter + ":");

            try {
                sum += Integer.parseInt(scanner.nextLine());
                counter++;
            } catch (NumberFormatException badUserData) {
                System.out.println("Invalid number!!! Try again.");
            }

        }

        //scanner.close();

        return "The sum of the five numbers is " + sum;
    }
    
    public static String getMinMaxChallangeScanner() {

        Scanner scanner = new Scanner(System.in);

        boolean validNumber = true;
        int iterator = 0;
        double min = 0;
        double max = 0;

        System.out.println("Enter a number or any character to quit");

        do {
            try {

                double userInput = Integer.parseInt(scanner.nextLine());

                if (iterator == 0) {
                    min = userInput;
                    max = userInput;
                } else {
                    if (userInput < min) {
                        min = userInput;
                    } else if (userInput > max) {
                        max = userInput;
                    }
                }

                System.out.println("Minimum: " + min + ", Maximum: " + max);
                iterator++;
            } catch (NumberFormatException nfe) {
                System.out.println("Goodbye!");
                validNumber = false;
            }
        } while (validNumber);

        scanner.close();

        return "";
    }

    public static String getMinMaxChallangeAlternateSolution() {

        Scanner scanner = new Scanner(System.in);

        int iterator = 0;
        double min = 0;
        double max = 0;

        while (true) {
            System.out.println("Enter a number or any character to quit");
            String nextEntry = scanner.nextLine();
            try {
                double userInput = Double.parseDouble(nextEntry);
                if (iterator == 0 || userInput < min) {
                    min = userInput;
                    
                } 
                if (iterator == 0 || userInput > max) {
                    max = userInput;
                }
                iterator++;
            } catch (NumberFormatException nfe) {
                break;
            }
        }

        if (iterator > 0) {
            System.out.println("min - " + min + ", max = " + max);
        } else {
            System.out.println("No valid data entered");
        }
        scanner.close();

        return "";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return (currentYear - dob);
    }
    
}