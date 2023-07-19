package chapter11.travelExpenses;

import javax.swing.*;
import java.awt.*;

public class TripPanel extends JPanel {

    private static final int ALLOWED_EXPENSES = 6000;
    private double totalExpenses = 0.0;

    private JLabel dayLabel = new JLabel("Days on trip");
    private JLabel airfareLabel = new JLabel("Airfare");
    private JLabel carRentalLabel = new JLabel("Car Rental Fee");
    private JLabel milesDrivenLabel = new JLabel("Miles Driven");
    private JLabel parkingFeeLabel = new JLabel("Parking Fees");
    private JLabel taxiChargesLabel = new JLabel("Taxi charges");
    private JLabel conferenceLabel = new JLabel("Conference fee");
    private JLabel lodgingLabel = new JLabel("Lodging charges");

    private JTextField dayTF = new JTextField(10);
    private JTextField airfareTF = new JTextField(10);
    private JTextField carRentalTF = new JTextField(10);
    private JTextField milesDrivenTF = new JTextField(10);
    private JTextField parkingFeeTF = new JTextField(10);
    private JTextField taxiChargesTF = new JTextField(10);
    private JTextField conferenceTF = new JTextField(10);
    private JTextField lodgingTF = new JTextField(10);

    TripPanel(){
        buildPanel();
    }

    private void buildPanel(){
        setLayout(new GridLayout(8,8));
        setBackground(Color.decode("#FF3333"));
        add(dayLabel);
        add(dayTF);

        add(airfareLabel);
        add(airfareTF);

        add(carRentalLabel);
        add(carRentalTF);

        add(milesDrivenLabel);
        add(milesDrivenTF);

        add(parkingFeeLabel);
        add(parkingFeeTF);

        add(taxiChargesLabel);
        add(taxiChargesTF);

        add(conferenceLabel);
        add(conferenceTF);

        add(lodgingLabel);
        add(lodgingTF);

        setStyle();
    }
    private void setStyle(){
        dayLabel.setForeground(Color.WHITE);
        airfareLabel.setForeground(Color.WHITE);
        carRentalLabel.setForeground(Color.WHITE);

        milesDrivenLabel.setForeground(Color.WHITE);
        parkingFeeLabel.setForeground(Color.WHITE);
        dayLabel.setForeground(Color.WHITE);

        taxiChargesLabel.setForeground(Color.WHITE);
        conferenceLabel.setForeground(Color.WHITE);
        lodgingLabel.setForeground(Color.WHITE);

        dayTF.setBackground(Color.RED);
        dayTF.setForeground(Color.WHITE);

        airfareTF.setBackground(Color.RED);
        airfareTF.setForeground(Color.WHITE);

        carRentalTF.setBackground(Color.RED);
        carRentalTF.setForeground(Color.WHITE);

        milesDrivenTF.setBackground(Color.RED);
        milesDrivenTF.setForeground(Color.WHITE);

        parkingFeeTF.setForeground(Color.WHITE);

        taxiChargesTF.setBackground(Color.RED);
        taxiChargesTF.setForeground(Color.WHITE);

        conferenceTF.setBackground(Color.RED);
        conferenceTF.setForeground(Color.WHITE);

        lodgingTF.setBackground(Color.RED);
        lodgingTF.setForeground(Color.WHITE);

        parkingFeeTF.setBackground(Color.RED);
    }
    private int getDays(){
        int days = 0;

        if(!dayTF.getText().isEmpty()){
            days = Integer.parseInt(dayTF.getText());
        }
        return days;
    }
    private double getExpenses(){
        final int DAILY_MEAL_EXPENSE_ALLOWANCE = 37;
        final int DAILY_LODGING_EXPENSE_ALLOWANCE = 95;
        final int DAILY_TAXI_EXPENSE_ALLOWANCE = 20;
        final int DAILY_PARKING_EXPENSE_ALLOWANCE = 10;
        final double CENTS_PER_MILE_TRAVELED = 0.27;
        totalExpenses += (getDays() * DAILY_MEAL_EXPENSE_ALLOWANCE);

//        if(!airfareTF.getText().isEmpty()){
//            double airFare = Double.parseDouble(airfareTF.getText().toString());
//            totalExpenses += airFare;
//        }
        totalExpenses = getSingleFeeExpense(airfareTF);

//        if(!lodgingTF.getText().isEmpty()){
//            double lodging = Double.parseDouble(lodgingTF.getText().toString());
//            totalExpenses += (getDays() * DAILY_LODGING_EXPENSE_ALLOWANCE);
//        }
        totalExpenses = getCalculatedFeeExpense(lodgingTF,DAILY_LODGING_EXPENSE_ALLOWANCE);
//        if(!conferenceTF.getText().isEmpty()){
//            double conferenceFees = Double.parseDouble(conferenceTF.getText());
//            totalExpenses += conferenceFees;
//        }
        totalExpenses = getSingleFeeExpense(conferenceTF);

//        if(!taxiChargesTF.getText().isEmpty()){
//            totalExpenses += (getDays() * DAILY_TAXI_EXPENSE_ALLOWANCE);
//        }
        totalExpenses = getCalculatedFeeExpense(taxiChargesTF,DAILY_TAXI_EXPENSE_ALLOWANCE);
//        if(!parkingFeeTF.getText().isEmpty()){
//            totalExpenses += (getDays() * DAILY_PARKING_EXPENSE_ALLOWANCE);
//        }
        totalExpenses = getCalculatedFeeExpense(parkingFeeTF,DAILY_PARKING_EXPENSE_ALLOWANCE);

//        if(!milesDrivenTF.getText().isEmpty()){
//            double miles = Double.parseDouble(milesDrivenTF.getText());
//            if(miles > 0){
//                totalExpenses += miles * CENTS_PER_MILE_TRAVELED;
//            } else {
//                totalExpenses += 0;
//            }
//        }
        totalExpenses = getCalculatedFeeExpense(milesDrivenTF,(int)CENTS_PER_MILE_TRAVELED);
//        if(!carRentalTF.getText().isEmpty()){
//            totalExpenses += Double.parseDouble(carRentalTF.getText());
//        }
        totalExpenses = getSingleFeeExpense(carRentalTF);
        return totalExpenses;
    }
    private double getSingleFeeExpense(JTextField expenseTextField){
        if(!expenseTextField.getText().isEmpty()){
            double fee = Double.parseDouble(expenseTextField.getText().toString());
            totalExpenses += fee;
        }
        return totalExpenses;
    }
    private double getCalculatedFeeExpense(JTextField expenseTextField, int constantMultiplier){
        if(!expenseTextField.getText().isEmpty()){
            totalExpenses += (getDays() * constantMultiplier);
        }
        return totalExpenses;
    }
    public double getTotalExpenses(){
        return getExpenses();
    }
    public double getTotalAllowedExpenses(){
        return ALLOWED_EXPENSES;
    }
    public double getExcess(){
        double excess = 0;

        if(totalExpenses > ALLOWED_EXPENSES){
            excess = ALLOWED_EXPENSES - totalExpenses;
        } else {
            excess = 0;
        }
        return excess;
    }

    public double getSavedAmount(){
        double savedAmount = 0;

        if(totalExpenses < ALLOWED_EXPENSES){
            savedAmount = ALLOWED_EXPENSES-totalExpenses;
        } else {
            savedAmount = 0;
        }
        return savedAmount;
    }
}
