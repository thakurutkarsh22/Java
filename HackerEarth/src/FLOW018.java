    import java.util.*;
    import java.lang.*;
   
    
   public class FLOW018{
   
    	public static void main(String args[])
    	{
    		Scanner ob = new Scanner(System.in);
    		int t=ob.nextInt();
    		while(t-->0)
    		{
    			int d=ob.nextInt();
    			int n=ob.nextInt();
    			while (d-->0)
    			n=n*(n+1)/2;
    			System.out.println(n);
    		}
    	}

} 