import java.util.Scanner;

public class linearsearch {
	
	 public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Main
	int value=32;
	int[] arr = takeinput();
	display(arr);
//	int max = maxval( arr);	
//	System.out.println(max);
//	
//	int search = linearsearch(arr,value);
//	System.out.println(search);
//	
//	reverse(arr);
	
	int [] inv = inverse(arr);
	display(inv);
	
	
	display(arr);
	int [] rot = rotate(arr ,2 );
	display(rot);
	}

	public static int[] takeinput()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Size of array");
		int n =scn.nextInt();
		int i;
		int[] rv = new int[n];
		for (i=0; i < rv.length; i++)
		{
			System.out.println("Enter the valur of" + i + "th element");
			rv[i]=scn.nextInt();
		}
		return rv;
	}
	
	public static void display(int[] array )
	{
		for (int i =0 ; i < array.length ; i++)
		{
			
			System.out.print(array[i] +"  " );
		}
		
	}
	
	public static int maxval(int[] array )
	{
		int i;
		int maxf = array[0];
		for (i=1;i<array.length;i++)
		{
			if ( array[i]> maxf)
			{
				maxf = swap(maxf, array[i] );
			}
		}
		System.out.println("The max val in array is " + " " + maxf);
	
		return maxf;
	}
	
	public static int swap(int maxval , int arrayval )
	{
		int temp = arrayval;
		arrayval = maxval;
		maxval = temp;
		
		return maxval;	
		
	}
	
	public static int linearsearch(int [] array , int data)

	{
		int rv =-1;
		int i;
		
		for(i=0 ; i < array.length ; i++)
		{
			if (array[i]== data)
			{
				rv = i; 
			}
		}
		
		return rv;
	}
	
	public static void reverse(int[] array)
	{
		
		int i ; 
		int leftindex =0 ; 
		int rightindex= array.length -1; 
		while (leftindex < rightindex)
		{
			int temp = array[rightindex];
			array[rightindex] = array[leftindex];
		    array[leftindex] = temp ;		

		    leftindex++;
		    rightindex--;
		}
		
		display(array);
	}

	public static int[] inverse(int [] array )
	{
		int i;
		int [] b = new int [array.length];
		for( i =0 ; i < array.length ; i++)
		{
			 b [array[i]] =i;
		}
		display(b);
		return ( b);
		
	}
	
	public static int[] rotate( int [] array , int k)
	{
		int[] rot = new int[array.length];

		k = k % array.length;
		
		if(k < 0){
			k = k + array.length;
		}
		
		int rotidx = 0;
		for(int i = array.length - k; i < array.length; i++){
			rot[rotidx] = array[i];
			rotidx++;
		}
		
		for(int i = 0; i <= array.length - 1 - k; i++){
			rot[rotidx] = array[i];
			rotidx++;
		}
		
		return rot;
	}

}
