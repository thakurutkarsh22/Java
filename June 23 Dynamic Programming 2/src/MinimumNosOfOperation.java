
public class MinimumNosOfOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ecfjk" ; 
		String s2 = "bcdfk" ; 
		int k=fnIterative("ecgfhjkl", "bcgdfhkl");
		System.out.println(k);
		System.out.println(fnIterative(s1, s2));
	}
	
	public static int fn(String s1, String s2) {
	
		if(s2.length()==0) {  // you can add , replace , and subtrace at only once place 
			
			return s1.length();
		}
		if(s1.length()==0) {  
			
			return s2.length();
		}

		
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 =s1.substring(1);
		String ros2 = s2.substring(1);
		int count = 0;
		if((ch1==ch2) ) {
			
		return fn(ros1, ros2);
			
			
		}
		

		else if ( (ch1!=ch2)) {
			
			int a = fn(ros1 , s2) +1; // add 
		// int a = fn(s1 , ch1 + s2) +1; 	
			
			int b = fn(ros1 , ros2)+1;			// replace
		// int b = fn(s1 , ch1 + ros2)+1;	
			
			int c = fn(s1 ,ros2) +1; 	// remove
			
			count+= Math.min(a , Math.min(b, c) ) ;
			
			
		}
		
		
		
		return count ;
		
		
	}

	public static int fnIterative (String s1 ,  String s2) {
	
		
		int[][] strg = new int[s1.length()+1][s2.length()+1];

		//strg[er][ec] = 1;

		int count =0 ;
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {

				if (row==s1.length()) {
					strg[row][col] = s2.length()-col;
					continue;
				}
			//	strg[row][col] = strg[row + 1][col] + strg[row][col + 1]+ strg[row+1][col+1];

				 if (col==s2.length()) {
						strg[row][col] = s2.length()-row;
						continue;
					}
				 
				 if (s1.charAt(row)== s2.charAt(col)) {
					 strg[row][col] = strg[row+1][col+1];
				 }else {
					 
					 int n = strg[row+1][col];
					 int p =strg [row+1][col+1];
					 int k =strg [row][col+1];
					 
					 strg[row][col] = Math.min(n, Math.min(p, k));
				 }
				 
			
			
			}

		}
		return strg[0][0];

	}
}




