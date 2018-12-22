
public class RecursionDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		pdiskips(5);
//		System.out.println(" ");
//		pdiskips(6);
//		System.out.println(" ");
//		pdiskips(7);
//		int p = power(5, 3);
//		System.out.println(p);
//		int k = powerwithtimeoflog(2,5);
//		System.out.println(k);
//		int f =fibonacci(5);
//		System.out.println(f); 
  	printcolumns(1,5);
		System.out.println("");
//		printrows(1,5);
//		printbox(2,2,5);		
//	printtri(1,1,5);
//		int [] array = {6,2,3,4,5,1};
//		int f= find(array , 2 );
//		System.out.println(f);
//		int maxval = max(array , 0);
//		System.out.println(maxval);
		
	}

	public static void printdereasing(int num) {
		if (num == 0) {
			return; 
		}
		System.out.println(num);
		printdereasing(num - 1);

	}

	public static void printincreasing(int num) {
		if (num == 0) {
			return;
		}

		printincreasing(num - 1);
		System.out.println(num);

	}

	public static void printincreasngdecreasing(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		printincreasing(num - 1);
		System.out.println(num);
	}

	public static void pdiskips(int num) {
		if (num == 0) {
			return;
		}

		if (num % 2 != 0) {
			System.out.println(num);
		}
		pdiskips(num - 1);
		if (num % 2 == 0) {

			System.out.println(num);
		}
	}

	public static int factorial(int num) {

		if (num == 0) {
			return 1;
		}

		int num1 = factorial(num - 1);
		int number = num * num1;
		return number;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int rv = x * power(x, n - 1);
		return rv;
	}

	public static int fibonacci(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;   // efficient version in 19th june class
		}
		
		
		int num1= fibonacci(num-1);
		int num2= fibonacci(num-2);
		int rv = num2 + num1;
		return rv;
	        	 // not efficient code because every one of the number in fibbonacci
		// is making a tree and fibbo of number is calculated multiple times 
	}
	public static int powerwithtimeoflog (int x , int n)
	{ 
		if (n == 0) {
			return 1;
		}
		int rv1 = powerwithtimeoflog(x,n/2);
		int rv = rv1*rv1;
		
		if (n%2==1)
		{
			 rv= rv*x;
			
		}
	return rv;	
	
	}
	
	public static void printcolumns(int col , int n)
	{
		if(n<col)
		{
			return;
		}
		
		System.out.print("2");
		printcolumns(col+1, n);
		
	}
	public static void printrows(int row , int n)
	{
		if(row>n)
		{
			return;
		}
		
		System.out.println("111111");
		printrows(row+1, n);
		
	}

	public static void printbox( int row , int col , int n)

	{
		if (row>n)
		{
			return;
		} if (col>n)
		{
			System.out.println();
		
			printbox(row+1 , 1 , n);
			return;
			
		}
		System.out.print("*");
		printbox(row ,col+1 , n  );
		
		
	}
	
	public static void printtri( int row , int col , int n)

	{
		if (row>n)
		{
			return;
		} if (col>row)
		{
			System.out.println();
		//	System.out.println("1 ");
			printtri(row+1 , 1 , n);
			return;
			
		}
		System.out.print("*");
		printtri(row ,col+1 , n  );
		
		
	}
	public static void printinverttri( int row , int col , int n)

	{
		if (row>n)
		{
			return;
		} if (col>row)
		{
			
		//	System.out.println("1 ");
			printinverttri(row+1 , 1 , n);
			System.out.println();
			return;
			
		}
	//	System.out.print("*");
		printinverttri(row ,col+1 , n  );
		System.out.print("*");
		
		
	}
	public static int find (int [] arr , int data )
	{
		if (arr.length ==0){
			return -1;
		}
		
		if (arr[0]==data )
		{
			return 0;
		}
		
		int [] b = new int [arr.length-1];
		for (int i = 0 ; i < b.length ; i++)
		{
			b[i]= arr[i+1];
			
		}
		int isinsmallerarray = find (b , data);
		
		if (isinsmallerarray == -1)
		{
			return -1;
		}else {
			return isinsmallerarray+1;
		}
	}
	public static void display (int [] arr , int vidx)
	{
		if (vidx==arr.length){
			return ;
		}
		
		System.out.println(arr[vidx]);
		display(arr , vidx+1);
	}
	public static int max (int [] arr , int vidx)
	{
		if (vidx == arr.length - 1){
			return arr[vidx];
		}
		
		int ans =max(arr,vidx+1);
		if (arr[vidx]> max(arr , vidx+1))
		{
			return arr[vidx] ; 
			
		} else{
			
		
			return ans;
		}
		
	}
	
}
