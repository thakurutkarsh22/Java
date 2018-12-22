import java.util.Scanner;

public class Assign3Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Initial temp :");
		int init = scn.nextInt();
		System.out.println("Final temp");
		int fina = scn.nextInt();
		System.out.println("Enter the increment");
		int inc = scn.nextInt();
		
		
		int ans = conversion( init , fina , inc );
		System.out.println();
		
	}
	public static int conversion(int i , int f , int c   ){
		
		int counter =i;
		
		while(counter<=f)
		{
	
			int farenhite= (int)(((float)5/9)*(counter-32));
			System.out.println(counter +" " + farenhite);
			
			counter=counter+c ;
		}
		return 0;
		
	}
}
