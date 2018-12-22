package codechef;

import java.util.Scanner;

public class H1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			int steps = 0;
			int N = scn.nextInt();
			if (isPOwerof2(N)) {
				System.out.println("1");
			} else {
				int k = power(N);
				System.out.println(k);
			}

		}
	}

	public static boolean isPOwerof2(int n) {
		if (n == 0)
			return false;

		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}
	private static class countclass {
		int c=0;
	}
	
	public static int power (int n ) {
		countclass c1 = new countclass();
		return power(n, c1);	
	}
	
	private static int power (int n , countclass c1) {
		
		if(n==0 ) {
			return c1.c;
		}if(n==1) {
			return c1.c+1;
		}
		int k = nearestpower(n);
		c1.c+=1;
		power(n-k, c1);
		
		return c1.c;
		
	}
	
	public static int nearestpower(int n) {
		if(n==1) {
			return 1;
		}

		int res = 0;
		for (int i = n; i >= 1; i--) {
			// If i is a power of 2
			if ((i & (i - 1)) == 0) {
				res = i;
				break;
			}
		}
		return res;
	}

}
