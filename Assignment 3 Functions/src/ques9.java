import java.util.Scanner;

public class ques9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Initial number :");
		int n = scn.nextInt();
		
		int answer = fn(n);
		System.out.println(answer);
		
		
	}
	
	public static int fn(int number )
	{
		int ress=number;
		int arm =0;
		while (number!=0){
		int rem = number % 10;
		
		arm = arm + (rem*rem*rem);
		
		number = number /10 ;
		}
		if (arm==ress)
		{
			return arm;
		}else
		return (0);
	}

}
