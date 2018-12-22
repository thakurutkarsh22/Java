import java.util.Scanner;

public class ques15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("First number :");
		int n10 = scn.nextInt();
		
		System.out.println("second number :");
		int n20 = scn.nextInt();
		fn(n10,n20);
		
		
		
		}
	
	public static void fn(int n1 , int n2)
	{
		int i;
		boolean answer;
		int formula ;
		for (i=1 ; i<=n1 ; i++)
		{
			formula = 3*i + 2;
//			System.out.println("makka"+ formula);
			answer = notmultiplier (formula , n2);
			
			if (answer)
			{
				System.out.println(formula);
			}
			
		
		}
			
	}
	
	public static boolean notmultiplier (int f , int f2)
	{
		boolean rv =true;
		
		if (f%f2==0)
		{
			rv =false;
		}
		
		
		return rv;
	}

}
