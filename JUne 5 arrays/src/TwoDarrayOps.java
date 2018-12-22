import java.util.Scanner;

public class TwoDarrayOps {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][]arr1 = takeinput();
		int [][]arr2 = takeinput();
	//	display(arr);
	//	wavedisplay(arr1);
	//	display(arr1);
		int [][] multiply = mult(arr1,arr2);
		display(multiply);
		
		
	}
	
	public static int[][] takeinput(){
		
		int[][] rv =null;
		System.out.println("Rows...?");
		int rows = scn.nextInt();
		
		rv = new int[rows][];
		for (int row=0; row < rv.length ;row++)
		{
			System.out.println("Columns for row - " + row);
			int cols =scn.nextInt();
			rv[row] = new int[cols];
			for(int col=0; col<rv[row].length;col++)
			{
				System.out.println("Value for cell ("+ row + "-" + col +")");
				rv [row][col]=scn.nextInt();
			}
			
		}
		return rv;
	}
	public static void display(int[][] arr)
	{
		for (int row =0; row < arr.length; row++)
		{
			for (int col=0; col < arr[row].length;col++)
			{
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
			
	}
	
	public static int[][] mult(int [][] arr1 , int[][] arr2 )
	{
		
		int [][] b = null;
		b= new int [arr1.length][arr2[0].length];
		int col = 0 ; 
		int row = 0;
		
		for ( row=0 ; row < arr1[0].length ; row++ )
		{
			
			for(col =0 ; col< arr2.length ; col++)
			{
				int sum =0;
				for (int i=0 ; i<arr1.length ; i++ ){
				sum = sum + arr1 [row][i] * arr2[i][col];
				}
				b[row][col]= sum;  
				
			}
	
		}
	
		
		
	
		return b;
	}

	public static void wavedisplay(int [][] array)
	{
		for (int col =0 ; col < array[0].length;col++)
		{
			
			for (int row = 0 ; row<array.length;row++)
			{
				if (col%2==0)
				{
					System.out.println(array[row][col] );
				}else
				{
					System.out.println(array[array.length -1 -row][col]);
				}
			}
		}
		
	}

	public static void spiralisplay(int [][] array){
		
		
		
				
		
		
	}


}
