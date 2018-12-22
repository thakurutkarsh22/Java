import java.util.Scanner;

public class assignQ9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int row = 0;

		while (row < n) {
			int col = 0;
			int val = 1;

			while (col <= row) {
				System.out.print(val);
				val = (val * (row - col)) / (col + 1);
				col++;
			}

			System.out.println(" ");
			row++;
		}

	}

}
