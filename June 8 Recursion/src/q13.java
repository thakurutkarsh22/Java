
public class q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int [] bubblesort(int[]arr , int si , int li  ){
		
		if (si==li)
			
		if (arr[si] > arr[si+1] ){
			
			int temp = arr[si];
			arr[si] = arr[si+1];
			arr[si+1] =temp ;
		}
		
		bubblesort(arr, si+1, li);
	}
}
