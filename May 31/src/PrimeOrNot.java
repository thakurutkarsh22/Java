import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
		// Prime or not
		
		
		System.out.println("Value the number :");
		Scanner scn = new Scanner(System.in);

		int number = scn.nextInt();
		int counter = 2 ;
		while (counter * counter <= number)
		{
			if (number % counter == 0)
			{
				System.out.println("Bhai no prime nahi h");
				return;
			}
			 
				
			counter = counter +1;
		}
		System.out.println("Number is prime ");
	}

}
