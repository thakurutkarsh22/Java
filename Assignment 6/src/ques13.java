
public class ques13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void invert(int[] arr , int vidx){
		
		if(vidx==arr.length){
			return;
		}
		
		int temp = arr[vidx];
		invert(arr , vidx+1);
		arr[temp] = vidx;
		
	}

}
