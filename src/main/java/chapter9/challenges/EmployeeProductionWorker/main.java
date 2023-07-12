package chapter9.challenges.EmployeeProductionWorker;

import utilityMethods.StringUtility;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.setEmployeeNumber("222-M");
        int date = 32;
        emp.setHireDate(1988,2,date);
        System.out.println(emp.getHireDate());

        ProductionWorker pw = new ProductionWorker();
        pw.setShift(3);

        System.out.println("Shift is: " + pw.getShiftString().toUpperCase());

        System.out.println("Demo of ProductionWorker with unset shift: ");
        ProductionWorker worker = new ProductionWorker();
         checkIfShiftNotSet(worker);
    }

    private static void checkIfShiftNotSet(ProductionWorker worker) {
        boolean userEnteredNewShift = false;
        if(worker.getShiftString().equalsIgnoreCase("-1")){
            System.out.println("The shift is not set.");
            enterNewShift(worker);
            userEnteredNewShift = true;
        } else if (worker.getShiftString() == "night" || worker.getShiftString() == "day") {
            System.out.println("Shift was set. Found: " + worker.getShiftString());
        }
        if(userEnteredNewShift){
            System.out.println("Your new shift is: " + worker.getShiftString());
        }
    }

    public static void enterNewShift(ProductionWorker worker){
        int shiftInput = StringUtility.getIntegerInput("Enter a shift number 0-1: ","ERROR: Number Not numeric. Enter another number 0-1: ");
        worker.setShift(shiftInput);
    }

}