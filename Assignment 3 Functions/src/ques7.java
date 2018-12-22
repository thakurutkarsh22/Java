import java.util.Scanner;

public class ques7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scn = new Scanner(System.in);
		System.out.println("Initial number :");
		int n = scn.nextInt();
		int answer = fn(n);
		System.out.println(answer);
		
		boolean equal = true ;
		if ( answer==n)
		{
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
	}

	public static int fn(int number){
		int counter = 0;
		int newnumber =0 ;
		while (number!=0)
		{
			counter = counter+1;
			int rem = number %10;
			newnumber = newnumber + counter*(int)Math.pow(10, (rem-1));
			
			
			number = number / 10;
			
			
		}
		System.out.println(number + " " + newnumber);
		
		
		
		return newnumber;
	}
}
