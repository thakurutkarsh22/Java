import java.util.Scanner;

public class PrintfibbolessthenN {

	public static void main(String[] args) {
		// Printing fibbonacchi less then n

		System.out.println("Enter the number :");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		
		int sum =0 ;
		int a = 0;
		int b = 1;
		int counter = 2;
		while (counter <= n)
		{  sum = a+b ; 
		a=b;
		b=sum;
		
		 sum = a+b ;
		
		
		counter = counter + 1;
		
	}
	System.out.println(sum);

}
}
