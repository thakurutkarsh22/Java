import java.util.Scanner;

public class assign2Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the numer:");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int row =1;
		int nsp=1;
		int val=1;
		while(row<=n)
		{
			// star
			int cst =1 ;
			
			System.out.print(val);
			
			if (row ==1){
			System.out.println("");}
			while(cst<=row-2)
			{
				
				System.out.print("0");
				cst++;
			}
			if (row!=1)
			{
			System.out.println(val);
			}
			
			row++;
			val=val+1;
		}
		
		
	}

}
