	import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {

		
		int[] arr1 = takeinput();
		int[] arr2 = takeinput();
		display(arr1);
		display(arr2);
//		boolean check = inverse(arr1 , arr2);
//		System.out.println(check);
		int [] answer = intersection(arr1 ,arr2);
		display(answer);
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
	public static boolean inverse(int [] array1 , int[] array2)
	{
		int i;
		if (array1.length==array2.length )
		{
		
		for( i =0 ; i < array1.length ; i++)
		{
			 if(array2 [array1[i]] ==i)
			 {
				 return true;
			 }
		}
	
		}else {
			System.out.println("Bhai sahi number daalo");
		}
		
		
		return false;
	}
//	public static int [] intersection(int[] array1 , int[] array2)
//	{
//		int[] b = new int[array1.length];
//		for (int i=0;i<array1.length;i++)
//		{
//			for (int j=0;j<array2.length;j++)
//			{
//				if(array1[i]==array2[j])
//				{
//					
//				}
//				
//			}
//		}
//		
//		
//	}
	
}
