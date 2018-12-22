package TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {
	public static final int BOARD_SIZE = 3;
	public static final int X_WINS = 1;
	public static final int Z_WINS = 2;
	public static final int INCOMPLETE = 3;
	public static final int TIE = 4;
	private boolean crossTurn;
	private JButton[][] buttons;

	public TTT() {
		super.setTitle("Tic Tac Toe");

		super.setResizable(false);
		super.setSize(600, 600);

		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);

		this.buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton();

				button.setFont(new Font("Times New Roman", 1, 225));
				button.addActionListener(this);

				this.buttons[row][col] = button;
				super.add(button);
			}
		}

		super.setVisible(true);
	}

	public void startGame() {
		this.crossTurn = true;
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();

		if (source.getText().equals("")) {
			this.makeMove(source);
			int gameStatus = this.getGameStatus();

			if (gameStatus == INCOMPLETE) {
				this.crossTurn = !this.crossTurn;
			} else {
				this.declareWinner(gameStatus);
				super.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid move.");
		}
	}

	private void declareWinner(int gameStatus) {
		if(gameStatus == TIE){
			JOptionPane.showMessageDialog(null, "Tie.");
		}
		else if(gameStatus == X_WINS){
			JOptionPane.showMessageDialog(null, "X wins.");
		}
		else {
			JOptionPane.showMessageDialog(null, "0 wins.");
		}
	}

	public void makeMove(JButton button) {
		if (this.crossTurn) {
			button.setText("X");
		} else {
			button.setText("0");
		}
	}

	public int getGameStatus() {
		int row = 0, col = 0;
		String text1 = "", text2 = "";

		// rows
		for (row = 0; row < BOARD_SIZE; row++) {
			col = 0;

			while (col < BOARD_SIZE - 1) {
				text1 = this.buttons[row][col].getText();
				text2 = this.buttons[row][col + 1].getText();

				if (text1.length() == 0 || !text1.equals(text2)) {
					break;
				}

				col++;
			}

			if (col == BOARD_SIZE - 1) {
				return text1.equals("X") ? X_WINS : Z_WINS;
			}
		}

		// cols
		row = 0;
		col = 0;
		for (col = 0; col < BOARD_SIZE; col++) {
			row = 0;

			while (row < BOARD_SIZE - 1) {
				text1 = this.buttons[row][col].getText();
				text2 = this.buttons[row + 1][col].getText();

				if (text1.length() == 0 || !text1.equals(text2)) {
					break;
				}

				row++;
			}

			if (row == BOARD_SIZE - 1) {
				return text1.equals("X") ? X_WINS : Z_WINS;
			}
		}

		// diagonal 1
		row = 0;
		col = 0;
		while (row < BOARD_SIZE - 1) {
			text1 = this.buttons[row][col].getText();
			text2 = this.buttons[row + 1][col + 1].getText();

			if (text1.length() == 0 || !text1.equals(text2)) {
				break;
			}

			row++;
			col++;
		}

		if (row == BOARD_SIZE - 1) {
			return text1.equals("X") ? X_WINS : Z_WINS;
		}

		// diagonal 2
		row = 0;
		col = BOARD_SIZE - 1;
		while (row < BOARD_SIZE - 1) {
			text1 = this.buttons[row][col].getText();
			text2 = this.buttons[row + 1][col - 1].getText();

			if (text1.length() == 0 || !text1.equals(text2)) {
				break;
			}

			row++;
			col--;
		}

		if (row == BOARD_SIZE - 1) {
			return text1.equals("X") ? X_WINS : Z_WINS;
		}

		// INCOMPLETE
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				if(this.buttons[row][col].getText().length() == 0){
					return INCOMPLETE;
				}
			}
		}

		// TIE
		return TIE;
	}

}