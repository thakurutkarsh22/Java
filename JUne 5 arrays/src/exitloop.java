
public class exitloop {

	public static void main(String[] args) {
	
		int[][] arr = {{0,0,1,0} ,
					   {1,0,0,1}, 
				       {0,0,0,0},
				       {1,0,1,0}};
		exitloops(arr);
		
	}
	
	public static void exitloops(int [][]array)
	{
		int row =0 ,col =0;
//		int rowmin=0; 
//		int rowmax= array.length;
//		int colmin = 0;
//		int colmax = array[0].length;
//		int i;
		int dir=0;
		while (true)
		{
			dir = (dir + array[row][col]) %4;
			
			if (dir==0){
							
				col++;
			}else if (dir==1) {
				row++;
			}else if (dir==2){
				col--;
			}else {
				row--;
			}
			
			if (row==-1)
			{
				System.out.println("0" + "" + col);
				break;
			}else if (row==array.length){
				System.out.println(array.length -1 + "" + col);
				break;
			}else if (col==-1)
			{
				System.out.println(row +"" + 0 );
				break;
			}else  if (col==array[0].length){
				
				System.out.println(row +"" + (array[0].length -1));
				break;
			}
			
		}
		
		
	}

}
