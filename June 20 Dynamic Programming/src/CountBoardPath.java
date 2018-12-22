
		public class CountBoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(CountBoardPath(0, 10));
		System.out.println(CountBoardPathBetter(0, 10 , new int [11]));
		
		System.out.println(CountBoardIterative(0, 10));
		System.out.println(CountBoardIterativeBetter(0, 10));
	}

	public static int CountBoardPath( int curr , int end) {
		
		if(curr>end) {
			return 0;
			
		}
		if(curr==end) {
			return 1;
		}
		
		
		
		int count =0; 
		
		for (int dice =1 ; dice <=6 ;dice++) {
			
			int cdice = CountBoardPath(curr+dice, end);
			count+=cdice;
		}
		
		
		return count ; 
	}
	
	public static int CountBoardPathBetter( int curr , int end , int[] strg) {
		
		if(curr>end) {
			return 0;
									// strg is the temp storage array
		}
		if(curr==end) {
			return 1;
		}
		if(strg[curr]!=0) {
			return strg[curr];
		}
		
		
		
		
		int count =0; 
		
		for (int dice =1 ; dice <=6 && dice<=end ;dice++) {
			
			int cdice = CountBoardPathBetter(curr+dice, end , strg);
			count+=cdice;
		}
		
		strg[curr] = count; // storage [question] = answer ;
		return count ; 
	}

	public static int CountBoardIterative(int curr , int end ) {
	
	int [] strg = new int [end + 6];
	
	strg[10]= 1 ;
	
	
	
	for (int i = end-1 ; i>=0 ; i--) {
		
		for(int j =1 ; j<=6 ;j++ ) {
			
			strg[i]+= strg[i+j];
			
		}
		
	}
	return strg[0];
	
	
}



	public static int CountBoardIterativeBetter(int curr , int end ) {
	
	int [] strg = new int [6];

	
	strg[0]= 1 ;
	
	
	
	for (int i = 1 ; i<=end; i++) {
		int nv = strg[0]+strg[1]+strg[2]+strg[3]+strg[4]+strg[5];
		for(int j =5 ; j>=1 ;j-- ) {
			
			strg[j] = strg[j-1];
			
		}
		strg[0]=nv;
		
	}
	return strg[0];
	
	
}
	

}
