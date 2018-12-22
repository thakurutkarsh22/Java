import java.util.Scanner;

public class Assign3_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Value enter :");
		long a = scn.nextInt();

		
		System.out.println("Given any Base :");
		long b = scn.nextInt();
		System.out.println("Enter ab");
		long c = scn.nextInt();

		long ans = conversion(a,b,c);
		System.out.println(ans );
			
	}

	
	public static long conversion(long n , long ab , long ab1 ){
		
		long dec = 0;
		long abtp = 1;
		while (n != 0) {
			long rem = n % 10;
			n = n / 10;

			dec = dec + rem * abtp;
			abtp = abtp * ab;
			int yo;
		}

		

		
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
		return n1;
		
	}
}
