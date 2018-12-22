package june1;

import java.util.Scanner;

public class octal2decimal {

	public static void main(String[] args) {
		// Octal to decimal
		System.out.println("Value Octal enter :");
		Scanner scn = new Scanner(System.in);
		
		int octal = scn.nextInt();

		// decimal number 
		
		int decimal = 0;
		int mult = 1;		
		while (octal != 0)
		{
			int  rem = octal % 10;
			octal = octal / 10 ;
			
			decimal = decimal + rem * mult ;
			mult = mult * 8;
		}
		System.out.println("This is the required number");
		System.out.println(decimal);
	}

}
