import java.util.Scanner;

public class qes13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("First number :");
		int x = scn.nextInt();
		
		System.out.println("second number :");
		int n = scn.nextInt();
		
//		int answer =  power(x,n);
//		System.out.println(answer);
		
		int answer1 = log (x,n);
		System.out.println(answer1);
	}

	
	public static int power(int n1 , int n2)
	{
		int mult =1;
		int i;
		for (i=1;i<=n2;i++)
		{
			 mult = mult *n1;
		}
		return mult;
	}
	public static int log (int n1 , int n2){
		int ans;
		while(n1!=ans){
			power();
			
			if (n1 = ans)
		}
		
		return 0;
	}
}
