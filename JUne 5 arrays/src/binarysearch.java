import java.util.Scanner;

public class binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = takeinput();
		
		int answer = bst(arr , 80);
		System.out.println(answer);
		
	}
	public static int[] takeinput()
	{
		Scanner scn = new Scanner(System.in);
//		System.out.println("Size of array");
		int n =scn.nextInt();
		int i;
		int[] rv = new int[n];
		for (i=0; i < rv.length; i++)
		{
//			System.out.println("Enter the valur of" + i + "th element");
			rv[i]=scn.nextInt();
		}
		return rv;
	}

	
	public static int bst(int [] array , int data)
	{
		int left =0;
		int right = array.length -1 ;
		while (left<=right)
		{
			int mid = (right+left) /2 ; 
			if ( data < array[mid] )
			{
				right = mid-1;
			}else 
				if (data > array[mid]){
				left=mid+1;
			}else{
				return mid;
			}
		  
		}
		
		return -1;
	}
}
