import java.util.ArrayList;

public class nQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[][] arr = new boolean[4][4];

		System.out.println(PlacenQueensOnBoard(arr, 0, ""));

	}

	public static int PlacenQueensOnBoard(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return 1;
		}
		int count = 0;

		for (int col = 0; col < board.length; col++) {
			if (isitsafetoplacethequeen(board, row, col)) {

				board[row][col] = true;
				count += PlacenQueensOnBoard(board, row + 1, ans + "(" + row + "-" + col + ")");
				board[row][col] = false;
			}

		}

		return count;
		// PlacenQueensOnBoard(board, row+ 1 ,col);

	}

	public static boolean isitsafetoplacethequeen(boolean[][] board, int row, int col) {

		// for columns
		for (int i = row; i >= 0; i--) {

			if (board[i][col] == true) {
				return false;
			}

		}

		// for left diagonal

		int i = row - 1;
		int j = col - 1;

		while (i >= 0 && j >= 0) {

			if (board[i][j] == true) {
				return false;
			}

			i--;
			j--;
		}

		// for right diagonal

		int a = row - 1;
		int b = col + 1;

		while (a >= 0 && b < board.length) {

			if (board[a][b] == true) {
				return false;
			}

			a--;
			b++;
		}
		return true;

	}
	
	//public static ArrayList<String> PQOBanotherMethod(int boolean[][]board , int row)
}
