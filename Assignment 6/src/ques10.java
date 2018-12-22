import java.util.ArrayList;

public class ques10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {1,2,3,18,6,4,6,7,6,7,6,8,6,9,1,2,6};
		int [] ans = Mcontainedallindices(array, 6 ,0 , 0);
		for(int i =0 ; i<ans.length;i++) {
			System.out.println(ans[i]);	
		}
		
//		ArrayList<Integer> k = allindices(array, 6 ,0 , 0);
//		System.out.println(k);
	}
	
	public static int []  Mcontainedallindices(int [] arr , int data , int vidx ,int fsf )
	{
		if (vidx== arr.length ){
			
			return new int [fsf];
		}
		
		
		int [] a = null ;
		if (arr[vidx] == data)
		{
			
			a = Mcontainedallindices(arr, data, vidx +1, fsf +1);
			a[fsf] = vidx;
			
		}else
		{
			a = Mcontainedallindices(arr, data, vidx+1, fsf);
			
			
		}
		return a;
	}
	
	public static ArrayList<Integer> allindices(int [] arr , int data , int vidx ,int fsf ){
		
			if (vidx== arr.length ){
			
			return  new ArrayList<>(fsf);
		}
		
		ArrayList<Integer> a = new ArrayList<>();
		if (arr[vidx] == data)
		{
			
			 a = allindices(arr, data, vidx +1, fsf +1);
			 a.add(vidx);
			
		}else
		{
			a = allindices(arr, data, vidx+1, fsf);
			
			
		}
		
		return a;
		
	}
}
