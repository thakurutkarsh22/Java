import java.util.Scanner;

public class PRintingCross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// isp initial space
		// bsp between space
		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int row = 1 ;
		int nisp=0;
		int nbsp= (n-2);
		int cisp = 1;
		int cbsp = 1;
		
		while (row<=n)
		{
			// for spaces
			cisp = 1;
			while (cisp <= nisp )
			{
				System.out.print(" ");
				cisp++;
			}
			
			System.out.print("*");
			
			//for between space 
			cbsp = 1;
			while (cbsp <= nbsp )
			{
				System.out.print(" ");
				cbsp++;
			}
			
			if (row != ((n/2) + 1) )
				System.out.println("*");
			
			if (row<=n/2)
			{nisp++;
			nbsp-=2;
			}
			
			else {
				nisp--;
				nbsp+=2;
						
			}
			System.out.println();
			row++;
		}
				
		
	}

}
