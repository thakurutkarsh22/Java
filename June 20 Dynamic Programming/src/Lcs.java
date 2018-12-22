import java.util.ArrayList;

public class Lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lcs("abefgf", "aefdgf"));
		System.out.println(lcs("tab","ayb"));
		System.out.println(lcsIteration("GXTXAYB", "AGGTAB"));
		System.out.println(lcsIteration("abefgf", "aefdgf"));
		
	}

	public static int lcs (String s1 , String s2) {
		
	
		if (s1.length()==0){
	
			return 0;
		}
		if (s2.length()==0){
		
			return 0;
		}
		
		
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		
		
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);
		
		int rv=0;
		
		if (ch1==ch2) {
			rv = 1+lcs(ros1 , ros2);
		}else {
			int f1 = lcs(s1, ros2);
			int f2 = lcs(ros1, s2);
			
			rv=Math.max(f1,f2);
		}
		return rv ;
		

		
	}
	
public static int lcsIteration (String s1 , String s2) {
		
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		// initialising 0 in all the outeer 
		
		
		
		
		
		
		for(int row = s1.length()-1 ; row >=0 ; row--) {
			for(int col=s2.length()-1; col>=0 ; col--) {
				
				if(s2.charAt(col)==s1.charAt(row)) {
					
					int r = strg[row + 1][col];
					int k = strg[row][col + 1];
					
					strg[row][col] = strg[row+1][col+1] +1;
					
					
//					strg[row][col] = 1 + ;
					continue;
				}else {
					
					int r = strg[row + 1][col];
					int k = strg[row][col + 1];
					
					strg[row][col] = Math.max(r, k);
					
					
				}
			}
		}
		
		return strg[0][0];
		
	
		
		
		
		
		
	}
}