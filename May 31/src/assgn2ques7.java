import java.util.Scanner;

public class assgn2ques7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the term :");
		Scanner scn = new Scanner(System.in);

		int term = scn.nextInt();
		int i=0;
		int j=0;
		while (i<term)
		{
			while (j<2*i+1  )
			{
				System.out.println("*");
				j++;
			}
			
			
			i++;
		}
	}

}
