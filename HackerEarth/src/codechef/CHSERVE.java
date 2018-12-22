package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CHSERVE {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		InputStreamReader is = new InputStreamReader(System.in);
		Scanner scn = new Scanner(System.in);
		BufferedReader BF = new BufferedReader(is);
//		int T = scn.nextInt();
		int T = Integer.parseInt(BF.readLine());
		
		while (T!=0) {
			String s[] = BF.readLine().split(" ");
			int P1 = Integer.parseInt(s[0]);
			int P2 = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
//			int P1 = scn.nextInt();
//			int P2 =  scn.nextInt();
//			int k = scn.nextInt();
						
			int temp = P1+P2 - ((P1+P2)%k);
			
			int count =0 ;
			while (temp!=0) {
				temp=temp/k;
				count++;
			}
			
			if(count%2!=0) {
				System.out.println("CHEF");
				
			}else {
				System.out.println("COOK");
			}
			
			
			
			
			T--;
		}
		
	}

}
