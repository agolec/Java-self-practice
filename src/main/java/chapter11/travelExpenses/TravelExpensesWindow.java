package chapter11.travelExpenses;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Create a GUI application that calculates and displays the total travel expenses of a business person on a trip.
 *
 *         HERE IS THE INFORMATION THE APPLICATION MUST BE PROVIDED:
 *        *********************************************************
 *      *                                                           *
 *      *   Number of days on the trip.                             *
 *      *                                                           *
 *      *    Amount of airfare, if any.                             *
 *      *                                                           *
 *      *   Amount of car rental fees, if any.                      *
 *      *                                                           *
 *      *   Number of miles driven, if private vehicle was used.    *
 *      *                                                           *
 *      *   Amount of parking fees, if any.                         *
 *      *                                                           *
 *      *   Amount of taxi charges,if any.                          *
 *      *                                                           *
 *      *   Conference or Seminar registration fees, if any         *
 *      *                                                           *
 *          Lodging charges, per night.                             *
          *********************************************************
 *
 *                              BUSINESS RULES
 *         ********************************************************
 *       *  The company reinburses travel expenses according to     *
 *       *      the following policy:                               *
 *       *                                                          *
 *       *  $37 Dollars per day for meals.                          *
 *       *  Parking fees up to $10.00 per day.                      *
 *       *  Taxi charges, up to $20.00 per day.                     *
 *       *  Lodging charges, up to $95.00 a day.                    *
 *       *  If a private vehicle is used, $0.27 per mile driven.    *
 *         ********************************************************
 *
 *                      WHAT THIS CLASSES DUTIES ARE
 *        *********************************************************
 *      *       Calculate and Display the                           *
 *      *       following information:                              *
 *      *                                                           *
 *      *        The total business expenses occurred               *
 *      *        by the businessman.                                *
 *      *                                                           *
 *      *         Calculate and display the totall                  *
 *      *        allowable expenses for the trip.                   *
 *      *                                                           *
 *      *        The excess that must be paid by the                *
 *      *        business person, if any.                           *
 *      *                                                           *
 *      *        The amount saved by the business person, if        *
 *      *        expenses are underneath the total allowed to       *
 *      *        the businessman.                                   *
 *        *********************************************************
 *
 *
 *
 *
 *


 */

public class TravelExpensesWindow extends JFrame {
    private JPanel mainPanel = new JPanel();
    private TripPanel tripPanel = new TripPanel();
    private JPanel btnPanel = new JPanel();
    private JButton calcBtn = new JButton("Calculate");
    private JButton exitBtn = new JButton("Exit");
    TravelExpensesWindow(){
        super("Travel Expenses");
        buildPanel();
        getContentPane().setBackground(Color.decode("#6B1A0E"));
        add(mainPanel,BorderLayout.NORTH);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void buildPanel(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setBackground(Color.decode("#B00A0A"));
        btnPanel.setLayout(new GridLayout(1,2));

        btnPanel.add(exitBtn);
        btnPanel.add(calcBtn);

        btnPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        mainPanel.add(tripPanel,BorderLayout.CENTER);
        mainPanel.add(btnPanel,BorderLayout.SOUTH);

        btnPanel.setBackground(Color.decode("#F55239"));
        exitBtn.addActionListener(new ExitBtnListener());
        calcBtn.addActionListener(new CalcBtnListener());

    }
    private class CalcBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            DecimalFormat df = new DecimalFormat("#,###.00");

            JOptionPane.showMessageDialog(null,
                    "\nTotal Expenses :$" + df.format(tripPanel.getTotalExpenses())
            + "\nTotal Allowed Expenses : $" + df.format(tripPanel.getTotalAllowedExpenses())
            + "\nExcess: $" + df.format(tripPanel.getSavedAmount())
            + "\nSaved Amount: $" + df.format(tripPanel.getSavedAmount())
                    + "\nExpenses : $" + JOptionPane.INFORMATION_MESSAGE);

        }
    }
    private class ExitBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new TravelExpensesWindow();
    }
}
