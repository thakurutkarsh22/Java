package june1;

import java.util.Scanner;

public class Replace {

	public static void main(String[] args) {
		// inverse concept

		System.out.println("Value enter :");
		Scanner scn = new Scanner(System.in);

		int number = scn.nextInt();
		int newnumber = 0;	
		int counter = 0 ;
		while (number != 0)
		{
			counter =counter + 1;
			int rem = number % 10 ;
			newnumber = newnumber + counter * (int)Math.pow(10, (rem-1));
			number = number / 10 ;
			System.out.println(newnumber);
		}
		System.out.println("New number is "+ newnumber);
	
		System.out.println(newnumber);
	}

}
