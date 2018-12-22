
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {16,9,19,18,1,22,55,0};
	
		TosDemos.startWatch();
		int []sorteds = mergeSort(arr, 0, arr.length-1);
		TosDemos.endWatch("MergeSort", 10000000);
	//System.out.println(sorteds);
		for(int val : sorteds) {
			System.out.println(val);
		}
	}
	
	public static int[] mergeTwoSortedArrays(int [] one , int [] two) {
		
		
		int i =0 , j=0 , k =0 ;
		int[] sorted = new int[one.length + two.length];
		
		while(i<one.length && j<two.length) {
			
			if(one[i] < two[j])
			{
				sorted[k] = one[i];
				i++;
				k++;
			}else {
				sorted[k] = two[j];
				j++;
				k++;
			}
			
				
		}
		if(i==one.length) {
			while(j<two.length) {
			sorted[k] = two[j];
			j++;
			k++;
		}
		}
		
		if(j==two.length) {
			while(i<one.length ) {
			sorted[k] = one[i];
			i++;
			k++;
		}
		}
	
	return sorted;
	}

	public static int[] mergeSort(int[] arr , int lo , int hi) {
		
		if(lo==hi) {
			
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		
		int mid = (lo+hi)/2;
		
		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid+1, hi);
		int[] twoshorted = mergeTwoSortedArrays(fh, sh);
		
		return twoshorted;
		
	}
}
