package chapter9.challenges.EmployeeProductionWorker;

import utilityMethods.StringUtility;

import java.util.Scanner;

import static utilityMethods.StringUtility.isInteger;

public class ProductionWorker extends Employee{
    private int shift;
    private double hourlyPayRate;

    ProductionWorker(){
        shift = 0;
        hourlyPayRate = 0;

    }
    void setShift(int shift){
        final int DAY_SHIFT = 0;
        final int NIGHT_SHIFT = 1;

        boolean isValid = false;
        int shiftCheck = shift;
        if(shiftCheck == DAY_SHIFT || shiftCheck == NIGHT_SHIFT){
            isValid = true;
        }
        while(!isValid){
            shiftCheck = getAnotherShiftInput();
            isValid = (shiftCheck == DAY_SHIFT || shiftCheck == NIGHT_SHIFT);
        }
        this.shift = shiftCheck;

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
