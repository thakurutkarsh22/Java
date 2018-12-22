import java.util.Scanner;

public class Fibinacchi {

	public static void main(String[] args) {
		// Fibbonacci to N

		
		System.out.println("Term till you want fibonnachi :");
		Scanner scn = new Scanner(System.in);

		int term = scn.nextInt();
		
		int a = 0;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		int counter = 2;
		while (counter < term)
		{
			int c= a+b ;
			System.out.println(c);		
			a=b;
			b=c;
			
			counter = counter + 1;
			
		}
	}

}
