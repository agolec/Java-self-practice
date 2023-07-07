package chapter9.challenges.EmployeeProductionWorker;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee {
    private String name;
    private String employeeNumber;
    private GregorianCalendar hireDate;
    Employee(){
        name = "";
        employeeNumber = "999-Z";
        hireDate = new GregorianCalendar();
    }
    public void setName(String name){
        if(name != null){
            this.name = name;
        }
    }
    public void setEmployeeNumber(String employeeNumber){
        boolean isValid = isEmployeeNumberValid(employeeNumber);
        String checkEmployeeNumber = employeeNumber;
        while(!isEmployeeNumberValid(checkEmployeeNumber)){
            checkEmployeeNumber = getNewEmployeeNumberInput();
        }
    }
    public void setHireDate(int year, int month, int dayOfMonth){

        while(!validateHireYear(year)){
            year = setYear();
        }
        while(!validateHireMonth(month)){
            month = enterNewMonth();
        }
        while(!validateHireDay(year, month, dayOfMonth)){
            dayOfMonth = enterNewHireDay();
        }
        this.hireDate = new GregorianCalendar(year,month,dayOfMonth);
    }
    private boolean validateHireYear(int year){
        final Year CURRENT_YEAR = Year.now();
        //Assuming for no real reason other than boredom that this company got established in 1985.
        if(year <= 1985 || year > Integer.parseInt(CURRENT_YEAR.toString())){
            return false;
        } else{
            return true;
        }
    }
    private boolean validateHireMonth(int month){
        if(month < 1 || month > 12){
            return false;
        }
        return true;
    }
    private boolean validateHireDay(int year,int month,int day){
        final int FIRST_DAY_OF_MONTH = 1;
        final int LAST_DAY_APR_JUNE_SEPT_NOV = 30;
        final int LAST_DAY_JAN_MAR_MAY_JULY_AUG_OCT_DEC = 31;
        final int LAST_DAY_FEB_LEAP_YEAR = 29;
        final int LAST_DAY_FEB_NOT_LEAP_YEAR = 28;

        boolean isValid = false;
        if(isLeapYear(year) && month == 2){
            if(checkMonthDayRange(day,FIRST_DAY_OF_MONTH,LAST_DAY_FEB_LEAP_YEAR)){
                isValid = true;
            }
        } else {
            if(month == 1 || month == 3 || month == 5 || month ==7 || month == 8 || month ==10 || month == 12){
                if(checkMonthDayRange(day,FIRST_DAY_OF_MONTH,LAST_DAY_JAN_MAR_MAY_JULY_AUG_OCT_DEC)){
                    isValid = true;
                }
            }else if(month == 2){
                if(checkMonthDayRange(day,FIRST_DAY_OF_MONTH,LAST_DAY_FEB_NOT_LEAP_YEAR)){
                    isValid = true;
                }
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11){
                if(checkMonthDayRange(day,FIRST_DAY_OF_MONTH,LAST_DAY_APR_JUNE_SEPT_NOV)){
                    isValid = true;
                }
            }
        }
        return isValid;
    }
    private int enterNewHireDay(){
        Scanner scan = new Scanner(System.in);
        String dayInput = "";
        System.out.println("ERROR. Day of month out of range. Enter a number 1-31: ");
        dayInput = scan.nextLine();
        while(!isInteger(dayInput)){
            System.out.println("Error. Input was not numeric. Enter a number between 1-31: ");
            dayInput = scan.nextLine();
        }
        return Integer.parseInt(dayInput);
    }

    public boolean checkMonthDayRange(int day,int startRange,int endRange){
        if(day >= startRange && day <= endRange){
            return true;
        } else {
            return false;
        }
    }
    private boolean isLeapYear(int year){
        boolean leapYear = false;
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
            leapYear = true;
        } else {
            leapYear = false;
        }
        return leapYear;
    }
    private int enterNewMonth(){
        Scanner scan = new Scanner(System.in);
        String string = "";
        System.out.print("Enter a number between 1 and 12: ");
        string = scan.nextLine();
        while(!isInteger(string)){
            System.out.print("\n");
            System.out.print("ERROR: Input was not a number. Enter a number between 1 and 12: ");
            string = scan.nextLine();
        }
        return Integer.parseInt(string);

    }

    private String getNewEmployeeNumberInput(){
        String newEmployeeString = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Employee ID invalid. Enter a string in the format XXX-L,\n" +
                            "where X are numbers 0-9, - is a hyphen, \n" +
                            "and L is a letter in the range A-M: ");
        newEmployeeString = scan.nextLine();
        return newEmployeeString;
    }
    public String getHireDate(){
        String hireDate = String.valueOf(this.hireDate.get(Calendar.MONTH)) + "\\" +
                (String.valueOf(this.hireDate.get(Calendar.DATE)) + "\\" +
                        (String.valueOf(this.hireDate.get(Calendar.YEAR))));
        return hireDate;
    }
    private int setYear(){
        final Year CURRENT_YEAR = Year.now();
        Scanner scan = new Scanner(System.in);
        String string = "";
        System.out.print("Enter a year between 1985 - " + CURRENT_YEAR.toString() + ": ");
        string = scan.nextLine();
        while(!isInteger(string)){
            System.out.print("\n");
            System.out.print("ERROR: Input was not a string. Enter a year between 1985 - " + CURRENT_YEAR.toString() + ": ");
            string = scan.nextLine();
        }
        return Integer.parseInt(string);

    }
    private boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean isEmployeeNumberValid(String employeeNumber){
        boolean isValid;
        final int HIGHEST_INDEX_FOR_DIGIT = 2;
        final int HYPHEN_INDEX = 3;
        final int LETTER_CHARACTER_INDEX = 4;
        final int LENGTH_OF_VALID_EMPLOYEE_NUMBER = 5;

        if(employeeNumber.length() != LENGTH_OF_VALID_EMPLOYEE_NUMBER){
            return false;
        }
        int index = 0;
        for(; index < employeeNumber.length(); index++){
            if(index <= HIGHEST_INDEX_FOR_DIGIT){
                if(Character.isDigit(employeeNumber.charAt(index)) == false){
                    return false;
                }
            }
            else if(index == HYPHEN_INDEX){
                if(employeeNumber.charAt(HYPHEN_INDEX) != '-'){
                    return false;
                }
            }
            else if(index == LETTER_CHARACTER_INDEX){
                if(Character.isAlphabetic(employeeNumber.charAt(LETTER_CHARACTER_INDEX)) == false){
                    return false;
                }else{
                    if((employeeNumber.charAt(LETTER_CHARACTER_INDEX) >= 'A' && employeeNumber.charAt(LETTER_CHARACTER_INDEX) <= 'M') == false){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
