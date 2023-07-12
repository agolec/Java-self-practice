package chapter9.challenges.EmployeeProductionWorker;

import utilityMethods.StringUtility;

import java.util.Scanner;

import static utilityMethods.StringUtility.isInteger;

public class ProductionWorker extends Employee{
    private int shift;
    private double hourlyPayRate;

    ProductionWorker(){
        super();
        this.shift = -1;
        this.hourlyPayRate = 0;

    }
    ProductionWorker(int shift){
        super();
        this.shift = shift;
        this.hourlyPayRate = 0;
    }
    void setShift(int shift){
        boolean isValid = false;
        int enteredShift = shift;

        enteredShift = validateShiftEntered(isValid, enteredShift);
        this.shift = enteredShift;

    }

    private int validateShiftEntered(boolean isValid, int shiftCheck) {
        final int DAY_SHIFT = 0;
        final int NIGHT_SHIFT = 1;
        if(shiftCheck == DAY_SHIFT || shiftCheck == NIGHT_SHIFT){
            isValid = true;
        }
        while(!isValid){
            System.out.println("ERROR: Shift must be entered as 0 or 1: ");
            shiftCheck = getAnotherShiftInput();
            isValid = (shiftCheck == DAY_SHIFT || shiftCheck == NIGHT_SHIFT);
        }
        return shiftCheck;
    }

    void setHourlyPayRate(double hourlyPayRate){
        double payRateInput = hourlyPayRate;
        if(payRateInput < 0){
            System.out.println("Error. Cannot have negative hourly payrate.");
            payRateInput = getPayRateInput();
        }
    }
    public int getShift(){
        return this.shift;
    }
    public String getShiftString(){
        String shiftString;
        if(this.shift == 0){
            shiftString = "night";
        } else if (this.shift == 1) {
            shiftString = "day";
        } else {
            shiftString = "-1";
        }
        return shiftString;
    }
    public double getPayRateInput(){
        double hourlyPayRate = 0;
        hourlyPayRate = StringUtility.getDoubleInput("Enter a new payrate: ","Error: Input was not numeric: ");
        return hourlyPayRate;
    }
    public int getAnotherShiftInput(){
        int shiftInput = -1;
        shiftInput = StringUtility.getIntegerInput("Enter another number 0 or 1", "Error: Input was not numeric.");
        return shiftInput;
    }
}
