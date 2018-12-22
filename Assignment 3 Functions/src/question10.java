import java.util.Scanner;

public class question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Initial number :");
		int n1 = scn.nextInt();
		
		System.out.println("Final number :");
		int n2 = scn.nextInt();
		
		int answer = fn(n1,n2);
		System.out.println(answer);
		
	}
	public static int fn(int initial , int fina){
		int newnumber=0;
		int init=initial;
		int counter= 1 ;
		while (initial <= fina)
		{
			
			while (initial!=0)
			{
				
				
				int rem = initial %10;
				newnumber = newnumber + (rem*rem*rem);
				initial = initial/10;
			}
			initial = init + counter;
			
			if ((initial-1)==newnumber)
			{
				System.out.println(newnumber);
			}
			newnumber = 0;
			
			
			counter++;
			
		}
		
		
		
		
		
		
		return 0;
	}

}
