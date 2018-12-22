
public class FunctionOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 3 ;
		int b = 5 ;
		int p = power(5 , 3);
		System.out.println(p);
		
		int l = log(3,243);
		System.out.println(l);
		
	}
	
	public static int power(int x , int n)
	{
		int im = 0;
		im = (int)Math.pow(x, n);
		return im;
		
		
	}
	public static int log(int x , int n )
	{
		int n1;
		int n2 = (int)Math.pow(x, n);
		return n2;
		
	}

}
