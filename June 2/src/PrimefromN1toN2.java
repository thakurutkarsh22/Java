import java.util.Scanner;

public class PrimefromN1toN2 {

	public static void main(String[] args) {
		// Prime number from N1 to N2 

		//Entring the number
		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);
		
		int number = scn.nextInt();
		int result = () isprime(number);
		System.out.println(result);
		
	}
	
	public static void isprime(int n )
	{
		int counter = 2; 
		while (counter * counter <= n )
		{
			if (n % counter == 0)
			{
				
				break;
			}
			counter = counter +1;
		}

	System.out.println(counter);
	
	}

}
