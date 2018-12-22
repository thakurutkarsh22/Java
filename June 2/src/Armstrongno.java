import java.util.Scanner;

public class Armstrongno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter he numer:");
		Scanner scn = new Scanner(System.in);
		
		int number = scn.nextInt();
		while ( number >0)
		{
			int sum =0;
			int d = number % 10 ;
			sum = sum + (d * d * d );
			 d= number/10;
		}
		
			System.out.println(sum);
			
		if (sum == number)
		{
			System.out.println("This is armstrong number");
			
		}
		else 
		{
			System.out.println("Not armstrong number");
		}
		
//		int answer = arm(number);
//		System.out.println(answer);
		
	//}

/*	public static int arm( int number ){
	while (int number >0)
	{
		int sum =0;
		int d = number % 10 ;
		sum = sum + (d * d * d );
		 d= number/10;
	}
	return (sum) ;
*/
	}
}

