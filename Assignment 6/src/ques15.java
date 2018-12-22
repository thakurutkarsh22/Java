
public class ques15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
	
	public static void selectionsort (int[] arr , int si , int li){
		
		if (arr[si] > arr[si+1]){
			
			
		}
		
	}
}
