
public class FibonaciBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println(fibonacci(8,new int[8+1]));
		
	}
	
	public static int fibonacci(int num , int[] strg) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		
		if(strg[num]!=0) {
			return strg[num];
		}
		
		int num1= fibonacci(num-1, strg);
		int num2= fibonacci(num-2, strg);
		int fibo = num2 + num1;
		
		strg[num] = fibo; // saves time but takes space
		
		return fibo;

	}
	
	public static int FibonacciIterative (int n) {
		int[]strg =new int [n+1];
		
		//init						//saves recursion space only 
		strg[0]=0;
		strg[1]=1;
		
		for (int i =2 ; i <strg.length ; i++) {
			
			strg[i] = strg[i-1] + strg[i-2];
		}
		return strg[n];
	}
	public static int FibonacciIterativesmaller (int n) {
		int[]strg =new int [n+1];
		
		//init
		strg[0]=0; // save time and space both 
		strg[1]=1;
		
		for (int i =1 ; i <=n-1; i++) {
			int nv = strg[0] + strg[1];
			strg[0] = strg[1]; 
			strg[1]= nv ;
			
		}
		return strg[1];
	}
	
	
	
	
}
