import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{

    // Fields
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // numbers from 0 to 9
    JButton[] functionButtons = new JButton[8];// symbols or
    JButton addButton, subButton , mulButton , divButton;
    JButton decimalButton , equalButton , deleeButton, clearButton;
    JPanel panel ;// store all the buttons

    Font myfont = new Font("Ink Free", Font.BOLD,30); // it can be change to any font

    double num1 = 0 , num2 = 0 , output =0;
    char operator ; // i will hold one of this + , - , * , \
    // Constructor
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,30,300,50);
        textField.setFont(myfont);
        textField.setEditable(false); // no one can type in the text field

        // Button Operators assignement
        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        mulButton = new JButton("*");
        deleeButton = new JButton("delete");
        clearButton = new JButton("clear");
        equalButton = new JButton("=");

        // add the buttons into the function button array

        functionButtons[0]= addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleeButton;
        functionButtons[7] = clearButton;


        //
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        // Button of numbers
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        deleeButton.setBounds(50,400,140,50);
        clearButton.setBounds(200,400,140,50);

        // panel set up -
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GREEN);

        //Add a grid of buttons to the panel

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equalButton);


        // add field to the frame
        frame.add(panel);
        frame.add(deleeButton);
        frame.add(clearButton);
        frame.add(textField);  // add the textfield to the frame

        frame.setVisible(true);

    }
    @Override
    // This method will be used to add functionality to the operators buttons
    public void actionPerformed(ActionEvent e) {

        // When clicking a button the value must be displayed in the text field
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // calculation
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    output = num1 + num2;
                    break;
                case '-':
                    output = num1 - num2;
                    break;
                case '*':
                    output = num1 * num2;
                    break;
                case '/':
                    output = num1 / num2;
                    break;
            } // end of switch case

            textField.setText(String.valueOf(output));
            num1 = output;

        } // end of if equal

        // clear button functionality
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == deleeButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < toString().length(); i++) {
                textField.setText(textField.getText() +  str.charAt(i));
            }
        }



    } // end of actionPerformed method


    public static void main(String[] args){
        Calculator cal = new Calculator();
    }


}
