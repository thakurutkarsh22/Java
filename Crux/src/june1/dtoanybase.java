package june1;

import java.util.Scanner;

public class dtoanybase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Value enter :");
		Scanner scn = new Scanner(System.in);

		int dec = scn.nextInt();

		int sb = 10;

		System.out.println("Enter destination base (db) :");
		int db = scn.nextInt();

		int ab = 0;
		int tnkp = 1;
		while (dec != 0) {
			int rem = dec % db;
			dec = dec / db;

			ab = ab + rem * tnkp;
			tnkp = tnkp * sb;

		}
		System.out.println(ab);
	}

}
