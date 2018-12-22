import java.util.Scanner;

public class Asign2ques6 {

	public static void main(String[] args) {
		// Take N as input. Print the sum of its odd placed digits and sum of its even placed digits. 
		
		System.out.println("Enter the number :");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int counter = 0;
		int sumodd =0;
		int sumeven =0; 
/*		while (n!=0)
		{
			 
			int rem = n%10;
			System.out.println(rem);
			if (rem % 2 == 0) {
				sumeven += rem;
			} else {
				sumodd += rem;
			}
			
			 n=n/10;
			
		}
*/		
// System.out.println(sumodd + " " +  + sumeven);

System.out.println("NOw we do digits");

       while (n!=0)
       {
    	   int rem = n%10 ;
    	   if (counter % 2 ==0)
    	   {
    		      
    		   sumodd = sumodd + rem ;
    		   
    		   
    	   }
    	   else 
    	   {
    		   sumeven = sumeven + rem ;
    	   }
    	   n=n /10 ;
    	   counter ++ ;
       }
System.out.println(sumeven + " " + sumodd);

	}


}
