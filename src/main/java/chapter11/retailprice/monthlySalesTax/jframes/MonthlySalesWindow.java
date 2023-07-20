package chapter11.retailprice.monthlySalesTax.jframes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.InputMismatchException;

/**
 * A retail company must file a monthly sales tax report listing the total sales for the month, and the amount
 * of sales tax and county sales tax collected. The state sales tax rate is 4% and the county sales tax is
 * 2%.
 *
 * Create a gui application that allows the user to enter the total sales for the month into a text field.
 *
 * From this figure, the application should calculate and display the following:
 *
 *      + Amount of county sales tax.
 *      + The amount of the state sales tax.
 *      + The total sales tax (county + state).
 */
public class MonthlySalesWindow extends JFrame {
    private JLabel promptLabel;
    private JTextField monthlySalesTextBox;
    private JButton okayButton;
    private JPanel panel;
    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = WINDOW_HEIGHT * (32/9);
    //Constructor.

    /**
     * Goals of constructor for a JFrame extending class:
     * 1- call the superclass constructor and set the title.
     * 2-define the window's size.
     * 3-Set default close operation.
     * 4-Build the Panel.
     * 5-Add the panel to the JFrame.
     * 6-Set visibility.
     */
    public MonthlySalesWindow(){
        super("County Sales Tax and State Sales Tax Breakdown");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);


    }

    /**
     * Goals of buildPanel class
     *  1 - Take every component that we intend to add to the JFrame and initialize them here.
     *  2 - Register event listeners.
     *  3 - Initialize a new panel object.
     *  4 - Add every component object that we initialized and add it to the panel.
     */
    private void buildPanel(){
         promptLabel = new JLabel("Enter this month's sale amount in USD: $ ");
         monthlySalesTextBox = new JTextField(10);
         okayButton = new JButton("Calculate Sales Tax Information");

         okayButton.addActionListener(new GenerateTaxButtonListener());

         panel = new JPanel();

         panel.add(promptLabel);
         panel.add(monthlySalesTextBox);
         panel.add(okayButton);
    }
    private class GenerateTaxButtonListener implements ActionListener {
        private final double STATE_SALES_TAX_PERCENT = 0.04;
        private final double COUNTY_SALES_TAX_PERCENT = 0.02;

        public void actionPerformed(ActionEvent e){
            double totalMonthlySales = 0;
            double totalCountySalesTax = 0;
            double totalStateSalesTax = 0;
            double totalOfAllSalesTax = 0;

            try{
                totalMonthlySales = Double.parseDouble(monthlySalesTextBox.getText());
                totalCountySalesTax = totalMonthlySales * COUNTY_SALES_TAX_PERCENT;
                totalStateSalesTax = totalMonthlySales * STATE_SALES_TAX_PERCENT;
                totalOfAllSalesTax = totalCountySalesTax + totalStateSalesTax;

                NumberFormat formatter = NumberFormat.getCurrencyInstance();

                JOptionPane.showMessageDialog(null,
                        "Total County Sales Tax: " + formatter.format(totalCountySalesTax) +
                        "\n" + "Total State Sales Tax is: " + formatter.format(totalStateSalesTax) +
                        "\n" + "Total of all sales tax: " + formatter.format(totalOfAllSalesTax) +
                        "\n" + "Total Sales: " + formatter.format(totalMonthlySales));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,
                        "Error: Unable to parse data for county sales " +
                        "tax or state sales tax. Enter a number: ");
            }

        }
    }
}
