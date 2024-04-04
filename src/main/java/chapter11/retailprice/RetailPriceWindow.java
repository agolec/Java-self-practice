package chapter11.retailprice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class RetailPriceWindow extends JFrame {
    private JLabel wholesalePriceLabel;
    private JLabel markupPercentLabel;
    private JTextField wholesalePriceTextField;
    private JTextField markupPercentTextField;
    private JButton calculateButton;
    private JButton someOtherButton;
    private JButton exitButton;

    private JPanel panel;
    private JPanel wholesalePricePanel;
    private JPanel markupPercentPanel;
    private JPanel operationsPanel;

    /**
     * Class Constructor.
     */
    public RetailPriceWindow(){
        super("Retail Price Window");

        final int WINDOW_WIDTH = 320;
        final int WINDOW_HEIGHT = 480;

        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        //add(panel);
        add(wholesalePricePanel,BorderLayout.WEST);
        add(markupPercentPanel, BorderLayout.EAST);
        add(operationsPanel,BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    private void buildPanel(){

        wholesalePriceLabel = new JLabel("Enter a wholesale price: ");
        wholesalePriceTextField = new JTextField(4);
        markupPercentLabel = new JLabel("Enter markup percent: ");
        markupPercentTextField = new JTextField(3);
        calculateButton = new JButton("Calculate");
        someOtherButton = new JButton("Nyahaha! I'm not the calculate button.");
        exitButton = new JButton("Exit");

        //Add Action Listener to the button.
        calculateButton.addActionListener(new CalcButtonListener());
        someOtherButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());


        panel = new JPanel();
        wholesalePricePanel = new JPanel();
        markupPercentPanel = new JPanel();
        operationsPanel = new JPanel();

        setLayout(new BorderLayout());

        //add the label, text fields, buttons, to the panel.
        wholesalePricePanel.add(wholesalePriceLabel);
        wholesalePricePanel.add(wholesalePriceTextField);
        markupPercentPanel.add(markupPercentLabel);
        markupPercentPanel.add(markupPercentTextField);
        operationsPanel.add(calculateButton);
        operationsPanel.add(someOtherButton);
        operationsPanel.add(exitButton);


    }
    //Private inner class CalcButtonListener implements the ActionListener class.
    private class CalcButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double wholeSalePrice = Double.parseDouble(wholesalePriceTextField.getText());
                double markupPercent = Double.parseDouble(markupPercentTextField.getText());

                double retailPrice = calculateRetailPrice(wholeSalePrice, markupPercent);
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                if(e.getSource() == calculateButton){
                    JOptionPane.showMessageDialog(null,"Welcome to the calculate button. " +
                                                                                "\nAction command: \'" + e.getActionCommand() + "\'");
                } else {
                    JOptionPane.showMessageDialog(null,"You clicked some other button " +
                            "\nAction command: \'" + e.getActionCommand() + "\'");
                }

                JOptionPane.showMessageDialog(null, "Retail price is : " + formatter.format(retailPrice));
            } catch(NumberFormatException er){
                System.out.print("ERROR: Input for wholesale price or markup percent could not be parsed out.\n");
                if(er.getMessage() == "empty String"){
                    System.out.println("String was empty.");
                }
                System.out.print(er.getMessage() + "\n");
            }
        }

        private double calculateRetailPrice(double wholesalePrice, double markupPercent){
            return (wholesalePrice + wholesalePrice * (markupPercent / 100));
        }
    }
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"Exiting program");
            System.exit(0);
        }
    }
    public static void main(String[] args){
        //Create an instance of the RetailPriceWindow class.
        RetailPriceWindow window = new RetailPriceWindow();
    }
}
