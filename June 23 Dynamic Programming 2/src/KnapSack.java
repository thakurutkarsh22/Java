
public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = {20, 10, 5, 8, 14} ;
		int [] b = {15,17,12,16,5} ; 
		System.out.println(knapSackfn(a , b , 50 , 0 , 0) );
	}

	public static int knapSackfn(int[] price , int[] weight , int capacity , int vidx ,int ans) {
		// without dynamic programming code +
		
		if(vidx ==weight.length) {   
		System.out.println(ans);	
			return ans;
		
		}
		
		int a =0,b =0;
		if(capacity >=weight[vidx]) {
		 a = knapSackfn(price, weight, capacity-weight[vidx], vidx+1 , ans + price[vidx] ); // yes 

		}
		 b = knapSackfn(price, weight, capacity, vidx+1 , ans  ); //no 
		
		 
		 return Math.max(a, b);
	
	
	
	}
	public static int knapSackfnbetter(int[] price , int[] weight , int capacity , int vidx ,int ans) {
		// without dynamic programming code +
		
		if(vidx ==weight.length) {   
		//System.out.println(ans);	 // refer codes     
			return ans;
		
		}
		
		int a =0,b =0;
		if(capacity >=weight[vidx]) {
		 a = knapSackfnbetter(price, weight, capacity-weight[vidx], vidx+1 , ans + price[vidx] ); // yes 

		}
		 b = knapSackfnbetter(price, weight, capacity, vidx+1 , ans  ); //no 
		
		 
		 
		 return Math.max(a, b);
	
	
	
	}
	
//	public static int knapSackIterative (int[] price , int[] weight , int capacity , int vidx ,int ans) {

		
		
		
		
	}
