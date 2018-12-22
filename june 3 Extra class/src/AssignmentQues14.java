import java.util.Scanner;

public class AssignmentQues14 {

	public static void main(String[] args) {
		// Assigment question 14

		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int row = 1;

		int nsp = (n - 1);
		int nst = 1;
		int csp = 1; // counter spaces
		int cst = 1; // counter stars
		int val = 1;
		while (row <= (2 * n - 1)) {
			// spaces

			csp = 1;

			while (csp <= nsp)

			{
				System.out.print(" ");
				csp = csp + 1;
			}

			// stars

			if (row <= n) {
				val = row;
			} else {
				val = 2 * n - row;
			}

			cst = 1;

			while (cst <= nst)

			{
				System.out.print(val);

				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
				cst++;
			}

			if (row < n) {
				nsp--;
				nst +=2;
			} else {
				nsp++;
				nst -= 2;

			}
			System.out.println();
			row++;
		}
	}

}
