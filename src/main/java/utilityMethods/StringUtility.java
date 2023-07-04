package utilityMethods;

import java.util.InputMismatchException;

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
}
