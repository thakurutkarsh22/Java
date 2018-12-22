import java.util.Scanner;

public class HoloRhombus {

	public static void main(String[] args) {
		// Holo rhombus
		
		
		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		
		
		
		int row = 1;
		int cstars = n / 2;
		int cspaces = 1;
		int cst = 1;
		int csp = 1;
		
		while(row <= n){
			// for stars
			cst = 1;
			
				while(cst <= cstars)
			
			{
				System.out.print("*");
				cst = cst + 1;
			}
			
			// for spaces
			
			csp = 1;
			
				while(csp <= cspaces)
			
			{
				System.out.print(" ");
				csp = csp + 1;
			}
			
			// for stars
			
			
			cst = 1;
			
				while(cst <= cstars)
			
			{
				System.out.print("*");
				cst = cst + 1;
			}
			
			if(row <= n / 2)
			
			{
				cstars = cstars - 1;
				cspaces = cspaces + 2;
			} else 
			
			
			{
				cstars = cstars + 1;
				cspaces = cspaces - 2;
			}
			
			System.out.println();
			row = row + 1;
			
		}
		
	}

}
