package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ORDTEAMS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		Scanner scn = new Scanner(System.in);
		BufferedReader BF = new BufferedReader(is);
//		int T = Integer.parseInt(BF.readLine());
		int T = scn.nextInt();
		int personA[] = new int [3];
		int personB[] = new int [3];
		int personC[] = new int [3];
		
		
		while(T-- >0) {
			
//			String personA[] = BF.readLine().split(" ");
//			String personB[] = BF.readLine().split(" ");
//			String personC[] = BF.readLine().split(" ");
			
			for(int i=0;i<3;i++) 
				 personA[i]=scn.nextInt();
		         for(int i=0;i<3;i++) 
		         personB[i]=scn.nextInt();
		         for(int i=0;i<3;i++) 
		         personC[i]=scn.nextInt();
			
			
			if(!(compare(personA,personB)&&compare(personB,personC)
					&&compare(personC,personA)))
		           System.out.println("no");
	         else
	           System.out.println("yes");
			}
			
			
		}
	
	
	
	static  boolean compare(int a[],int b[])
    {
     if( (a[0]>=b[0]&&a[1]>=b[1]&&a[2]>=b[2]&&
    		 a[0]+a[1]+a[2]>b[0]+b[1]+b[2]) ||
    		 (b[0]>=a[0]&&b[1]>=a[1]&&b[2]>=a[2]&&
    		 a[0]+a[1]+a[2]<b[0]+b[1]+b[2]) )
       return true;
     return false;
    }
	
	static boolean compare(String a[] , String b[]) {
		
		if((a[0].compareTo(b[0])>=0) && (a[1].compareTo(b[1])>=0) 
	&&(a[2].compareTo(b[2])>=0) &&((a[0]+a[1]+a[2]).compareTo(b[0]+b[1]+b[2])>=0) 	
				) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
