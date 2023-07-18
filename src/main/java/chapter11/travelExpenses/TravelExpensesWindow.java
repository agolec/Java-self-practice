package chapter11.travelExpenses;

import javax.swing.*;

/**
 * Create a GUI application that calculates and displays the total travel expenses of a business person on a trip.
 * Here is the information the user must provide:
 *
 *        *********************************************************
 *      *                                                           *
 *      *   Number of days on the trip.                             *
 *      *   Amount of airfare, if any.                              *
 *      *   Amount of car rental fees, if any.                      *
 *      *   Number of miles driven, if private vehicle was used.    *
 *      *   Amount of parking fees, if any.                         *
 *      *   Amount of taxi charges,if any.                          *
 *      *   Conference or Seminar registration fees, if any         *
 *      *   Lodging charges, per night.                             *
          *********************************************************
 *
 *                              BUSINESS RULES
 *         ********************************************************
 *       *  The company reinburses travel expenses according to     *
 *       *      the following policy:                               *
 *       *                                                          *
 *       *  $37 Dollars per day for meals                           *
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
    JPanel
    TravelExpensesWindow(){

    }
    public static void main(String[] args){
        TravelExpensesWindow window = new TravelExpensesWindow();
    }
}
