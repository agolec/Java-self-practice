package chapter5.challenges.penniesforpay;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        int numberToPrintTo = 0;
        String userInput = new String();
        Scanner sc = new Scanner(System.in);
        final int MINIMUM_ALLOWED_VALUE = 1;
        boolean userInputAboveThreshold = false;

        System.out.println("This program will prompt you for how many days you would like to work for.");
        System.out.println("It will then print a table where the first day displays $0.01 and doubles every day");
        System.out.println();
        System.out.print("Enter a number 1 or higher to print out your pay for: ");
        userInput = sc.nextLine();
        userInputAboveThreshold = isStringAboveMinimumThreshold(userInput, MINIMUM_ALLOWED_VALUE);
        while(!isStringNumeric(userInput) && !userInputAboveThreshold){
            System.out.print("Input must be numeric and above" + MINIMUM_ALLOWED_VALUE
                    + ". Enter another integer: ");
            userInput = sc.nextLine();
            userInputAboveThreshold = isStringAboveMinimumThreshold(userInput, MINIMUM_ALLOWED_VALUE);
        }
        int numberOfDaysUserWorks = Integer.parseInt(userInput);
        printUserPay(numberOfDaysUserWorks);
        System.out.println("DONE");


    }

    private static void printUserPay(int numberOfDaysUserWorks) {
        final double FIRST_DAYS_PAY = 0.01;
        int iteratorGap = 1;
        double daysPay = FIRST_DAYS_PAY;
        System.out.println("DAYS WORKED\t\t\t\t\t\t\tPAY");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
        //if numberOfDaysUserWorks is very high, we will run a loop that iterates by 5 instead of 1.
        if(numberOfDaysUserWorks > 10){
            for(int i = 0; i < numberOfDaysUserWorks;i++){
                if((i + 1) % 5 == 0){
                    System.out.println(i+1 + "\t\t\t\t\t\t\t\t\t\t" +dollarFormat.format(daysPay));
                }
                daysPay *= 2;
            }
        } else{
            for(int i = 0; i < numberOfDaysUserWorks;i++){
                System.out.println(i+1 + "\t\t\t\t\t\t\t\t\t\t" +dollarFormat.format(daysPay));
                daysPay *= 2;
            }
        }

    }

    private static boolean isStringAboveMinimumThreshold(String userInput, int MINIMUM_ALLOWED_VALUE) {
        boolean userInputAboveThreshold = false;
        if(isStringNumeric(userInput)){
            int primingUserInput = Integer.parseInt(userInput);
            if(primingUserInput <= MINIMUM_ALLOWED_VALUE){
                userInputAboveThreshold = true;
            }
        } else{
            userInputAboveThreshold = false;
        }
        return userInputAboveThreshold;
    }

    public static boolean isStringNumeric(String userInput){
        boolean validInput = false;
        int number = 0;
        try{
            number = Integer.parseInt(userInput);
            validInput = true;
        } catch(InputMismatchException e){
            //System.out.println(e.getMessage());
            validInput = false;
        }
        return validInput;
    }
}
