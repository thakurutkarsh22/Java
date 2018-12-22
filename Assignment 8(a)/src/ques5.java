
public class ques5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		toh("s" , "D" , "H" , 3);
		//int r= tohCount("s" , "D" , "H" , 3);
		System.out.println(tohCount("s" , "D" , "H" , 3));
	}

	public static void toh(String src , String dest , String helper , int n ) {
		
		if (n==0) {
			return ;
		}
		
		toh(src , helper , dest , n-1);
		System.out.println("Move" + n +"th disk from" + src + "to" +dest);
		toh(helper , dest , src , n-1 );
	}
	
	public static int tohCount(String src , String dest , String helper , int n ) {
	
		if (n==0) {
			return 0; // count steps 
		}
		
		int k = tohCount(src , helper , dest , n-1);
		int p =tohCount(helper , dest , src , n-1 );
		
		return k+p+1;
		
	}
	
}
