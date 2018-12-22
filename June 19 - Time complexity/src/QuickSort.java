
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]  array=  {8 , 16 ,3,7,2,14};
		int [] arr = {10 , 20};
		int[] arr1 = {50,10,30,40,20};
		quicksort(array, 0, array.length-1);
		quicksort(arr1, 0, arr1.length-1);
		quicksort(arr, 0, arr.length-1);
		for(int val : array) {
			System.out.print(val + " ");
		}
		for(int val : arr) {
			System.out.println();
			System.out.println(val + " ");
		}
		
		for(int val : arr1) {
			System.out.println(val + " "); // yaha zehar macha raha h ye code 
		}
	}
	public static void quicksort(int[] arr , int lo , int hi ) {
	
		if(lo>=hi) {
			return;
		}
		
		int mid = (hi + lo)/2;
		//System.out.println(mid);
		int piviot = arr[mid];
		//System.out.println(piviot);
		
		int left = lo ;
		int right = hi ;
		
		while (left<=right) {
			while(arr[left]<piviot) { // {2,3,16,,7,8,14} check for this with = 
				left++;
				
			}
			while(arr[right]>piviot) {
				right--;
				
			}
					
		
		
		if (left<=right) {
			
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
			
				}
			}
		quicksort(arr, lo, right); // for left 
		quicksort(arr, left, hi); // for right 
		
	}

}
