package utilityMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringUtility {

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
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public static boolean isDouble(String s){
        try{
            Double.parseDouble(s);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public static int getIntegerInput(String prompt,String errorPrompt){
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        System.out.println(prompt);
        userInput = scan.nextLine();
        while(!isInteger(userInput)){
            System.out.println(errorPrompt);
            userInput = scan.nextLine();
        }
        return Integer.parseInt(userInput);

    }
    public static double getDoubleInput(String prompt, String errorPrompt){
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        System.out.println(prompt);
        while(!isDouble(userInput)){
            System.out.println(errorPrompt);
        }
        return Double.parseDouble(userInput);
    }
}
