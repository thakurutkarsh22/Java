package codechef;

import java.util.Scanner;

public class SINS {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		
		for(int i=0; i<T ; i++) {
			int X= scn.nextInt();
			int Y=scn.nextInt();
			
			int ans= 2*gcd(X, Y);
			System.out.println(ans);
		}
		
	}
	
	
	public static int gcd(int  a,int  b)
	{
	    if(a==0)
	        return b;
	    else
	        return gcd(b%a,a);
		
	}
	
	public static int gcd1(int a , int b) {
		
		while (a!=0) {
			if(a>=b) {
				a=a-b;
			}else {
				b=b-a;
			}
		}
		
		return b;
	}
	

}
