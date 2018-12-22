import java.util.Scanner;

public class Ques12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Initial number :");
		int n1 = scn.nextInt();
		
		System.out.println("Final number :");
		int n2 = scn.nextInt();
		
		int answer1 = lcm(n1,n2);
//		int answer2 = product(n1,n2);
		
		System.out.println(answer1);	
//		System.out.println(answer2);
				
		
}
	
//	public static int gcd( int divident , int divisior)  
//	{
//		int rem =0;
//		
//		while (divident%divisior !=0)
//		{
//			rem = divident % divisior ;
//			divident = divisior ;
//			divisior = rem;
//			 
//			
//			
//		}
//		return (rem);
//	}
//	
//	public static int product (int divident , int divisior)
//	{
//		int c;
//		
//		c= divident*divisior;
//		
//		return c;
//	}

	
}
