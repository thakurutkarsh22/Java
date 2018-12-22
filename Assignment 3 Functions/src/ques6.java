import java.util.Scanner;

public class ques6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("A number :");
		int n = scn.nextInt();
		System.out.println("A digit");
		int d = scn.nextInt();
		
		int answer= fn(n , d);
		System.out.println(answer);
		
	}
	public static int fn(int number , int digit ){
		int counter=0;
		while (number!=0)
		{
			int rem = number % 10;
				if (rem==digit)
				{
					counter++;
				}
			number=number/10;
		}
		
		
		return counter;
	}

}
