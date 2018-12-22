import java.util.Scanner;

public class ques7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int [] array1 = {1,2,3,18,6,4,6,7,6};

		int n = scn.nextInt();
        int[] array = new int[n];
        for(int i=0 ;i<array.length;i++){
           array[i]=scn.nextInt();
        }
        int k = scn.nextInt();
        int  ans = Mcontainedlast(array, k ,0);
		System.out.println(ans);
		
//		boolean ans = Mcontained(array, 1 ,0);
//		System.out.println(ans);
	}
	
	public static boolean Mcontained (int [] arr , int n , int indx){
		
		if (indx==arr.length-1){
			return false;
		}
		if (arr[indx] == n)
		{
			return true;
		}
		
		boolean ans = Mcontained(arr, n, indx+1);
		return ans;
		
		
	}
	public static int Mcontainedfirst (int [] arr ,int n , int indx){
		
		if (indx==arr.length-1){
			return -1;
		}
		
		if (arr[indx] == n)
		{
			return indx;
		}
		int ans = Mcontainedfirst(arr, n, indx+1);
		return ans;
		
	}

public static int Mcontainedlast (int [] arr ,int n , int indx){
		
//	int[] k = arr;
		if (indx==arr.length-1){
			return -1;
		}
		
		if (arr[arr.length -indx -1 ] == n)
		{
			return arr.length -indx -1;
		}
		int ans = Mcontainedlast(arr, n, indx+1) ;
		return ans;
		
	}

}
