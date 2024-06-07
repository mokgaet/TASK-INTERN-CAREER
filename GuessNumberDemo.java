// Owner: Mmakola Mokgaetsi
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumberDemo extends JFrame {

    private int targetNumber;
    private int attempts;
    // UI Components
    private JTextField guessInput;
    private JLabel feedbackLabel;
    private JButton guessButton;

    public GuessNumberDemo() {


        // Initialize game variables
        guessInput = new JTextField(10);
        guessInput.setToolTipText("Enter your guess (1-10)");

        feedbackLabel = new JLabel("Guess a number between 1 and 10");

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());


        // Arrange components in a layout
        setLayout(new FlowLayout()); //Simple horizontal row
        add(guessInput);
        add(guessButton);
        add(feedbackLabel);
        add(resetButton);

        // Set up the frame
        setTitle("Guess the Number Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create UI components
        resetGame();

    }

 // * GuessButtonListener implements ActionListener to handle the guess button click.


    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleGuess();
        }
    }
//  * handleGuess() processes the user's guess, compares it with the target number, and updates the feedback label.
    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessInput.getText());
            attempts++;
            if (attempts > 5){
                feedbackLabel.setText("You've reached your attempts for this round, Reset the game!");
            }

            if (guess < targetNumber) {
                feedbackLabel.setText("Too low! Try again.");
            } else if (guess > targetNumber && guess <=10) {
                feedbackLabel.setText("Too high! Try again.");
            } else if (guess > 10 ) {
                feedbackLabel.setText("Guess out of bound! ");

            } else {
                    feedbackLabel.setText("Correct! You guessed it in " + attempts + " attempts.");
                    guessButton.setEnabled(false);
            }

        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a valid number.");
        }
    }
/*
 resetGame() -- initializes the target number and attempts, and resets the UI components.
 */
    private void resetGame() {
        targetNumber = new Random().nextInt(10) + 1;
        attempts = 0;
        guessInput.setText(" ");
        feedbackLabel.setText("Guess a number between 1 and 100");
        guessButton.setEnabled(true);
    }

     public static void main(String[] args) {
        GuessNumberDemo demo = new GuessNumberDemo(); // direct instantiation instead of using SwingUtilities.invokeLater
        //SwingUtilities.invokeLater(GuessNumberDemo::new);
    }
}
