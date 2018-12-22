import java.util.Scanner;

public class Primeni2toN {

	public static void main(String[] args) {
		// Entering the number
		
		System.out.println("Enter the number :");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		
	// 	
		int count = 2;
		while  (count <= n)
		{
			int counter =2 ;
			while ( counter< count)
			{
				if (n % counter ==0)
				{
					System.out.println("Not prime");
					return;
				}
				counter =counter + 1;
				
			}
					
			System.out.println(n);
					
					
			
		}

		count = count + 1 ;
	}
}

