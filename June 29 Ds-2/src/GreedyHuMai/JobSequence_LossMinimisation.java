package GreedyHuMai;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequence_LossMinimisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int L[] = { 1, 2, 3, 5, 6 };
//	    int T[] = { 2, 4, 1, 3, 2 };
	    int L[] = {3,1,2,4};
	    int T[] = {4,1000,2,5};
//	    
	    ar[] a = new ar[L.length];
	    for(int i=0 ; i<L.length ; i++) {
	    	a[i] = new ar(i+1,L[i],T[i]);
	    }
	    Arrays.sort(a, new jobcomparatoe());
	    for(int i=0 ; i <L.length ; i++) {
	    	System.out.println(a[i].N);
	    }
	    
		
	}
	
	public static class ar {
		public ar(int n ,int i, int j) {
			this.N = n;
			this.L =i;
			this.T =j;
		}
		int N ;
		int L ;
		int T ;
	}
	
	public static class jobcomparatoe implements Comparator<ar>{

		@Override
		public int compare(ar o1, ar o2) {
			ar a= (ar)o1;
			ar b = (ar)o2;
			
			int a_li =  a.L;
			int a_ti = a.T;
			int b_li = b.L;
			int b_ti = b.T;
			
			return ((a_li * b_ti) > (b_li * a_ti)) ? -1 : 1;
//			return (a.L>b.L) ? -1 :1;
		}
		
	}
	
	
	

}
