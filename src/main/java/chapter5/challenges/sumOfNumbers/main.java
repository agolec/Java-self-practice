package chapter5.challenges.sumOfNumbers;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String userString = "";
        System.out.println("Enter a number and I will sum everything up to it.");
        userString = keyboard.nextLine();
        int totalValueOfDigitsInString = 0;

        userString = validateUserString(keyboard, userString);
        totalValueOfDigitsInString = getSumOfDigitsInString(userString);
        printStats(userString,totalValueOfDigitsInString);


        /*
        Now gathering input to count up to user digit.
         */
        int sumOfAllNumbers = 0;
        userString = "";
        System.out.println("Enter another number and I will count up to it: ");
        userString = keyboard.nextLine();

        userString = validateUserString(keyboard,userString);
        sumOfAllNumbers = getSumOfIteratingUpToUserNumber(userString);
        printSumOfNumbers(userString,sumOfAllNumbers);



    }

    private static String validateUserString(Scanner keyboard, String userString) {
        while(!isNumeric(userString)){
            System.out.println("Error. Re-enter string. Must be numeric input.\n"+
                    "You previously entered: " + userString);
            userString = keyboard.nextLine();

        }
        return userString;
    }

    //Enter the user's string and iterate over every character in it.
    //Gather a running total of the values for every number in the string.
    private static int getSumOfDigitsInString(String userString) {
        int runningTotal = 0;
        int currentCharacterValue;
        System.out.println("Processing String: ");
        for(int i = 0; i < userString.length(); i++){
            currentCharacterValue = Integer.parseInt(userString.substring(i,i+1));
            runningTotal += currentCharacterValue;
        }

        return runningTotal;
    }
    private static int getSumOfIteratingUpToUserNumber(String userString){
        int runningTotal = 0;
        final int NUMBER_TO_COUNT_TO = Integer.parseInt(userString);
        System.out.println("Processing string counting from 1 to " + userString);
        for(int i = 0; i < NUMBER_TO_COUNT_TO; i++){
            runningTotal += (i+1);
        }
        return runningTotal;
    }

    public static boolean isNumeric(String userInputString){
        return userInputString.chars().allMatch(Character::isDigit);
    }
    public static void printStats(String userString, int totalValueOfDigitsInString){
        System.out.println("The string you entered was: " + userString);
        System.out.println("The total of all digits was: " + totalValueOfDigitsInString);

    }
    public static void printSumOfNumbers(String userString, int allValues){
        System.out.println("The string you entered was: " + userString);
        System.out.println("The total of all digits was: " + allValues);
    }
}
