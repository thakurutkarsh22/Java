
public class Ques5 {


	
	public static void main(String[] args) {
	
			
	int p = nthtriangle(4);
	System.out.println(p);
	
	}
	
	public static int nthtriangle(int n){
		if (n==1){
			return 1;
		}
		
		
		
		int ans = n+  nthtriangle(n-1);
		
		
		return ans ;
	}
}
