package example;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
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
		txtGuess.setBounds(320, 108, 75, 39);
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setText("1000");
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setBounds(205, 187, 75, 25);
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(btnGuess);
		
		JLabel lblOutput = new JLabel("Enter a number and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(0, 263, 486, 47);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
