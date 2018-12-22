import java.util.Scanner;

public class hackerblocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int a = 0 ; 
//		int b = 1; 
//		
//		for (int i = 0  ; i <n ; i++) {
//			for (int j = 0 ; j < i+1 ; j++) {
//				
//				System.out.print(a + " ");
//				
//				int c = a+b;
//				a=b;
//				b=c;
//				
//			}
//			System.out.println();
//			
//			
//			
//		}
//		
//	}
	
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		long a = 0 ;
		long b = 1 ; 
		long c ;
		
		for (int i = 0 ; i < n ; i++) {
			
			System.out.println(a);
			c = a+b;
			a=b ;
			b=c;
		}
		
		
	}
}
