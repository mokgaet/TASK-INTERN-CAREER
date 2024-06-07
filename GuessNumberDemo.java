import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumberDemo extends JFrame {
    private int targetNumber;
    private int attempts;
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
        setLayout(new FlowLayout());
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

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleGuess();
        }
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessInput.getText());
            attempts++;

            if (guess < targetNumber) {
                feedbackLabel.setText("Too low! Try again.");
            } else if (guess > targetNumber) {
                feedbackLabel.setText("Too high! Try again.");
            } else {
                feedbackLabel.setText("Correct! You guessed it in " + attempts + " attempts.");
                guessButton.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a valid number.");
        }
    }

    private void resetGame() {
        targetNumber = new Random().nextInt(10) + 1;
        attempts = 0;
        guessInput.setText(" ");
        feedbackLabel.setText("Guess a number between 1 and 100");
        guessButton.setEnabled(true);
    }

    public static void main(String[] args) {
        GuessNumberDemo demo = new GuessNumberDemo();
        //SwingUtilities.invokeLater(GuessNumberDemo::new);
    }
}
