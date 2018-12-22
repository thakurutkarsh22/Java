import java.util.Scanner;

public class PrimeNoN1toN2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scn = new Scanner(System.in);
		System.out.println("Initial number :");
		int n10 = scn.nextInt();
		
		System.out.println("Final number :");
		int n20 = scn.nextInt();
		
		 printprime(n10,n20);
			
		
		
		
	}
	
	public static int printprime(int n1 , int n2 )
	{
		int i;
		boolean result;
		for (i = n1 ; i <= n2 ; i++)
		{
			 result = isprime(i);
			 if (result)
				{
					System.out.println(i);
				}
			 
		}
		
		return 0;
	}

	public static boolean isprime(int k)
	{
		boolean rv = true;
		int div =2;
		while (div*div<=k)
		{
			if (k % div==0)
			{
				rv = false;
			}
			
			div++;
		}
		
		return rv;
	}
}
