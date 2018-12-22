
public class Polynimial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(setPolyVal(3, 3));
		
	}
	
	public static int setPolyVal(int x ,int n) {
		
		int sum =0 ;
		int temp =1;
		for (int c =n ; c>0 ; c--) {
			
			temp= temp *x;
			sum= sum +  c *temp ;
		
		}
		
		return sum; 
	}
	
	//public static // by recursion 

}
