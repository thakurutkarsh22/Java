 
public class allindices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		int[] array = {2 ,19,9,10,27,18,10,26,10,15 };
		int [] p = allindix(array , 10 , 0 ,0);
		display(p);
//		System.out.println("");
//		bubblesort(array , 0 , array.length-1);
//		display(array );
		
	}
	
	public static int[] allindix(int [] arr , int data , int si , int fsf)
	{
		 // found so far
		if (si==arr.length)
		{
			
			return new int [fsf];
		}
		
		int [] a =null;
		
		if ( arr[si] == data )
		{
			
			
		a=	allindix(arr , data ,si +1 , fsf+1);
		a[fsf] = si;
			
			
		}else {
			
			a=allindix(arr , data ,si +1 , fsf);
			
		}
		
		return a;
		
	}

	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + "  ");
		}

	}
 
	public static void bubblesort (int [] arr , int si , int li )
	{
		if (li == 0)
		{
			return ; 
		}
		if (si==li){
			li--; 
			si=0;
			
			
		}
		
		if (arr[si] > arr[si+1]){
			int temp = arr[si];
			arr[si] = arr[si+1];
			arr[si+1] =temp ;
			
		}
		bubblesort (arr , si+1 , li);
		
	}
}
