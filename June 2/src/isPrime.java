import java.util.Scanner;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// is prime 
		
		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);
		
		int number = scn.nextInt();
		boolean p = isprime( number );
		System.out.println(p);
		
	}

	public static boolean isprime( int n )
	{
		int a = n;
		int counter = 2; 
		while (counter * counter <= a )
		{
			if (a % counter == 0)
			{
				
				return false;
			}
			counter = counter +1;
		}
		return true; 
		}
	}

