import java.util.Scanner;

public class Assign2Ques7 {

	public static void main(String[] args) {
		// Assignment 2 Question no 7 

		
		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int row =1;
		int nst=1;
		int cst =1 ;
		int val = 1;
				
		while (row<=n)
		{
			// for stars
						cst = 1;
						
							while(cst <= row)
						
						{
								
							System.out.print(val);
							val=val+1;
							cst = cst + 1;
						}
					System.out.println("");	
			row++;			
		}
	}

}
