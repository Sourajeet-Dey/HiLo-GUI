package example;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private JButton btnGuess;
	private JLabel lblGuessCount;
	private int theNumber;
	private int guessCount;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			guessCount++;
			if (guess < theNumber) {
				if (theNumber - guess > 25)
					message = guess + " is too low. Try again.";
				else
					message = guess + " is slightly low. Try again.";
			} else if (guess > theNumber) {
				if (guess - theNumber > 25)
					message = guess + " is too high. Try again.";
				else
					message = guess + " is slightly high. Try again.";
			} else {
				message = guess + " is correct. You win!";
				if (guessCount <= 10)
					lblGuessCount.setText("It took you only " + guessCount + " tries. Good job!");
				else
					lblGuessCount.setText("It took you " + guessCount + " tries. Can you do better?");
				txtGuess.setEditable(false);
				btnGuess.setVisible(false);
				btnPlayAgain.setVisible(true);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 1000";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocusInWindow();
			txtGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int) (Math.random() * 1000 + 1);
		lblOutput.setText("Enter a number and click Guess!");
		txtGuess.setEditable(true);
		guessCount = 0;
		lblGuessCount.setText(null);
	}

	public GuessingGame() {
		setForeground(new Color(128, 64, 0));
		setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sourajeet's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Sourajeet's Hi-Lo Guessing Game");
		lblNewLabel.setBounds(116, 51, 254, 19);
		lblNewLabel.setForeground(new Color(64, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 1000:");
		lblNewLabel_1.setBounds(75, 120, 235, 15);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(320, 108, 75, 39);
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setText(null);
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(177, 187, 132, 25);
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(0, 263, 486, 25);
		getContentPane().add(lblOutput);

		btnPlayAgain = new JButton("Play Again!");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
				btnPlayAgain.setVisible(false);
				btnGuess.setVisible(true);
				txtGuess.setText(null);
			}
		});
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPlayAgain.setBounds(177, 187, 132, 25);
		btnPlayAgain.setVisible(false);
		getContentPane().add(btnPlayAgain);

		lblGuessCount = new JLabel();
		lblGuessCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuessCount.setBounds(0, 291, 486, 25);
		getContentPane().add(lblGuessCount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(500, 400));
		theGame.setVisible(true);
	}
}
