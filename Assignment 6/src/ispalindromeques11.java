
public class ispalindromeques11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {1,2,3,5,3,2,1};
		boolean ans = ispali(array, 0 , 6);
		System.out.println(ans);
		
	}
	
	public static boolean ispali (int[] arr , int si , int li)
	{
		if (si==li){			// not for even digits 
			
			return true ;
		}
		
		
		
		
		if (arr[si]==arr[li])
		{
			 ispali(arr , si+1 , li-1);
			return true;
			
		}else
		{
			return false ; 
		}
		
		
		
	}
}
