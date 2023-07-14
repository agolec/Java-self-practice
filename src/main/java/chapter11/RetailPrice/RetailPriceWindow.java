package chapter11.RetailPrice;

import javax.swing.*;

public class RetailPriceWindow extends JFrame {
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField markupPercentTextField;
    private JTextField retailPriceTextField;
    private JButton okayButton;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 300;

    //constructor
    public RetailPriceWindow(){
        super("Retail Price Converter.");

        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }
    private void buildPanel(){
        messageLabel = new JLabel("Enter retail price and markup percent.");
        markupPercentTextField = new JTextField(3);
        retailPriceTextField = new JTextField(4);
        okayButton = new JButton("Okay");

        panel = new JPanel();

        panel.add(messageLabel);
        panel.add(markupPercentTextField);
        panel.add(retailPriceTextField);
        panel.add(okayButton);

    }
}
