package chapter11.RetailPrice;

import javax.swing.*;

public class RetailPriceCalculator {
    public static void main(String[] args){
//        String wholeSaleCost = "";
//        String markupPercent = "";
//
//        wholeSaleCost = JOptionPane.showInputDialog(null, "Enter value,","enter carefully!",JOptionPane.INFORMATION_MESSAGE);
//        markupPercent = JOptionPane.showInputDialog(null,"enter markup percent","something",JOptionPane.INFORMATION_MESSAGE);
//        int wholesaleInt = Integer.parseInt(wholeSaleCost);
//        int markupPercentInt = Integer.parseInt(markupPercent);
//
//        double lol = calculateRetailMarkup(wholesaleInt,markupPercentInt);
//        System.out.println(lol);
        RetailPriceWindow rpw = new RetailPriceWindow();


    }

    public static double calculateRetailMarkup(double wholeSaleCost,double markupPercent){
        return ((markupPercent/100) * wholeSaleCost) + wholeSaleCost;
    }

}
