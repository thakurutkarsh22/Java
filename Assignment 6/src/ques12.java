
public class ques12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {1,2,3,5,6,8,7};
		reverse(array, 0 , array.length-1 );
	//	System.out.println(ans);
	}
	
	public static void reverse (int[] arr , int si , int li ){
		
		
		if (li==si){
			System.out.println(arr[si]); 
			return;
		}
		
			
			int temp = arr[si];
			arr[si] = arr[li];
			arr[li] = temp ;
			System.out.println(arr[si]);	
		 reverse(arr , si +1 , li -1);
		System.out.println(arr[li]);
		
	}

}
