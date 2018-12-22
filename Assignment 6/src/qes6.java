
public class qes6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {1,2,3,8,6};
		boolean ans = isSorted(arr, 0);
		System.out.println(ans);
		
	}

	
	public static boolean isSorted(int[] arr, int idx) {
		if(idx == arr.length - 1){
			return true;
		}
		
		if(arr[idx] > arr[idx + 1]){
			return false;
		}
		
		boolean issasorted = isSorted(arr, idx + 1);
		return issasorted;
	}
}
