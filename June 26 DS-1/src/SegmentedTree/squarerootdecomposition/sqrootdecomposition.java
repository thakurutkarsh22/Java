package SegmentedTree.squarerootdecomposition;

public class sqrootdecomposition {

	static int[] array;
	static int[] block ;
	static int index =-1;
	static int blockSize;
	public static void main(String[] args)  {
		int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10}; 
	    int n = input.length; 
	    blockPreprocessing(input);
	    System.out.println(query(3, 8));
	    System.out.println(query(1, 6));
	    Update(8, 0); 
	    System.out.println("query(8, 8) : " +  
	                        query(8, 8)); 
	}
	
	private static void blockPreprocessing(int[] input) {
		array= new int[input.length];
		
		int index=-1;
		blockSize = (int)Math.sqrt(input.length);
		block = new int[(int) Math.ceil(Math.sqrt(input.length))];
				
		for(int i=0;i<input.length;i++) {
			array[i] = input[i];
			if(i%blockSize==0) {
				index++;
			}
			block[index] +=array[i];
		}
	}
	
	public static void Update(int index, int val) {
		int blockNo = index/blockSize;
		block[blockNo] += val-array[index];
		array[index] = val;
	}
	
	public static int query(int l , int r) {
		int sum =0;
		while (l < r && l % blockSize != 0 && l != 0) 
		    { 
		        // traversing first block in range 
		        sum += array[l]; 
		        l++; 
		    } 
		    while (l+blockSize <= r) 
		    { 
		        // traversing completely 
		        // overlapped blocks in range 
		        sum += block[l / blockSize]; 
		        l += blockSize; 
		    } 
		    while (l <= r) 
		    { 
		        // traversing last block in range 
		        sum += array[l]; 
		        l++; 
		    } 
		    return sum; 
	}

	
}
