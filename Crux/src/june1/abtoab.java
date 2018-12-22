package june1;

import java.util.Scanner;

public class abtoab {

	public static void main(String[] args) {
		// Any base to Any Base

		System.out.println("Value enter :");
		Scanner scn = new Scanner(System.in);

		long n = scn.nextInt();
		System.out.println("Given any Base :");
		long ab = scn.nextInt();

		long dec = 0;
		long abtp = 1;
		while (n != 0) {
			long rem = n % 10;
			n = n / 10;

			dec = dec + rem * abtp;
			abtp = abtp * ab;
		}

		System.out.println("Decima number" + " " + dec);

		System.out.println("Enter ab");
		long ab1 = scn.nextInt();
		// n1 is new base number
		long n1 = 0;
		long twtp = 1;
		while (dec != 0) {

			long rem = dec % ab1;
			dec = dec / ab1;

			n1 = n1 + rem * twtp;
			twtp = twtp * 10;
		}

		System.out.println(n1);
	}

}
