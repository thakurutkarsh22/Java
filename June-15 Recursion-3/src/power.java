import java.util.Scanner;

public class power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();
		
		
		System.out.println(power(N1));
	}

	public static int power(int n) {
		if (n == 0)
            return 0;
		else {
			int i = n%10;
			int k = power(n/10);
			return i+k;
		}
		}
	}

	/* Program to test function power */

