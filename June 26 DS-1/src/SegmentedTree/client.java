package SegmentedTree;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,5,-1};
		SegmentTree s = new SegmentTree(arr,"SUMMTREE");
		int[] a =s.segmentTree;
//		for(int i=0 ;i< a.length ;i++) {
//			System.out.print(a[i]+" ");
//		}
		System.out.println(s.rangeMinQuery(arr.length, 2, Integer.MAX_VALUE));
//		System.out.println(s.rangeSumQuery(arr.length-1,-2, 2));
//		s.updateValue(arr, 1, 2);
//		System.out.println(s.rangeSumQuery(arr.length-1, 0, 2));
		
		
	}

}
