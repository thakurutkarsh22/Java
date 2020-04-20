package SegmentedTree;

import java.util.Arrays;

public class SegmentTree {

	int[] segmentTree;
	
	SegmentTree(int[] arr,String s){
		int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2))); 
		 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
  
        segmentTree = new int[max_size];
        if(s.equals("MINTREE"))
        	Arrays.fill(segmentTree, Integer.MAX_VALUE);
        else if(s.equals("MINTREE"))
        	Arrays.fill(segmentTree, Integer.MIN_VALUE);
        else if(s.equals("SUMMTREE"))
        	Arrays.fill(segmentTree, 0);
      
        
      // there is no need of S as per say 
        	constructTree(arr,segmentTree,0,arr.length-1,0,s);
        
	}

	private void constructTree(int[] arr, int[] segmentTree, int low, int high,int pos,String s) {
		if(low==high) {
			segmentTree[pos] = arr[low];
			return;
		}
		
		int mid = (high+low)/2;
		constructTree(arr, segmentTree, low, mid, (2*pos)+1,s);
		constructTree(arr, segmentTree, mid+1, high, (2*pos)+2,s);
		if(s.equals("MINTREE"))
			segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
		else if(s.equals("MAXTREE"))
			segmentTree[pos] = Math.max(segmentTree[2*pos+1], segmentTree[2*pos+2]);
		else if(s.equals("SUMMTREE"))
			segmentTree[pos] = segmentTree[2*pos+1] + segmentTree[2*pos+2];
		else if(s.equals("XORTREE"))
			segmentTree[pos] = segmentTree[2*pos+1] ^ segmentTree[2*pos+2];
	}
	
	
	public int rangeMinQuery(int n, int qlow, int qhigh) {
		return rangeMinQuery(segmentTree,qlow,qhigh,0,n,0);
	}
	
	private int rangeMinQuery(int[] segmentTree, int qlow, int qhigh 
			,int low, int high, int pos) {
		// no overlap
		if(qlow>high || qhigh<low) {
			return Integer.MAX_VALUE;
		}
		//Total Overlap
		if(qlow<=low && qhigh>=high) {
			return segmentTree[pos];
		}
		
		int mid = (low+high)/2;
		int left = rangeMinQuery(segmentTree,qlow,qhigh,low,mid,(2*pos)+1);
		int right = rangeMinQuery(segmentTree,qlow,qhigh,mid+1,high,2*pos+2);
		return Math.min(left, right);
	}
	
	public int rangeMaxQuery(int n, int qlow, int qhigh) {
		return rangeMaxQuery(segmentTree,qlow,qhigh,0,n,0);
	}
	
	private int rangeMaxQuery(int[] segmentTree, int qlow, int qhigh 
			,int low, int high, int pos) {
		// no overlap
		if(qlow>high || qhigh<low) {
			return Integer.MIN_VALUE;
		}
		//Total Overlap
		if(qlow<=low && qhigh>=high) {
			return segmentTree[pos];
		}
		
		int mid = (low+high)/2;
		int left = rangeMaxQuery(segmentTree,qlow,qhigh,low,mid,(2*pos)+1);
		int right = rangeMaxQuery(segmentTree,qlow,qhigh,mid+1,high,2*pos+2);
		return Math.max(left, right);
	}
	
	public int rangeSumQuery(int n, int qlow, int qhigh) {
		return rangeSumQuery(segmentTree,qlow,qhigh,0,n,0);
	}
	
	private int rangeSumQuery(int[] segmentTree, int qlow, int qhigh 
			,int low, int high, int pos) {
		// no overlap
		if(qlow>high || qhigh<low) {
			return 0;
		}
		//Total Overlap
		if(qlow<=low && qhigh>=high) {
			return segmentTree[pos];
		}
		
		int mid = (low+high)/2;
		int left = rangeSumQuery(segmentTree,qlow,qhigh,low,mid,(2*pos)+1);
		int right = rangeSumQuery(segmentTree,qlow,qhigh,mid+1,high,2*pos+2);
		return left+right;
	}
	
	public int rangeXorQuery(int n, int qlow, int qhigh) {
		return rangeXorQuery(segmentTree,qlow,qhigh,0,n,0);
	}
	
	private int rangeXorQuery(int[] segmentTree, int qlow, int qhigh 
			,int low, int high, int pos) {
		// no overlap
		if(qlow>high || qhigh<low) {
			return 0;
		}
		//Total Overlap
		if(qlow<=low && qhigh>=high) {
			return segmentTree[pos];
		}
		
		int mid = (low+high)/2;
		int left = rangeXorQuery(segmentTree,qlow,qhigh,low,mid,(2*pos)+1);
		int right = rangeXorQuery(segmentTree,qlow,qhigh,mid+1,high,2*pos+2);
		return left^right;
	}
	
	
	public void updateValue(int[] arr,int i , int val) {
		if(i<0||i>arr.length-1)
			return;
		
		int diff = val - arr[i];
		UpdateValue(0,arr.length-1,i,diff,0);
	}
	
	private void UpdateValue(int low, int high, int i, int diff ,int pos) {
		if(low==high)
			return;
		if(i<low || i>high) {
			return;
		}
		
		segmentTree[pos] += diff;
		int mid = (low+high)/2;
		UpdateValue( low,  mid,  i,  diff , 2*pos+1);
		UpdateValue( mid+1,  high,  i,  diff , 2*pos+2);
	}
}
