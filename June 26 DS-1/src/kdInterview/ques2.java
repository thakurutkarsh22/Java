package kdInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class ques2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		int arr[] = {1,1,0,0};
//		System.out.println(function(arr));	
		
		int arr1[] = {0,1,2,3}; // 9
//		for(int i : fun2(arr1)) {
//			System.out.print(i+" ");
//		}
		ArrayList<Integer> v = new ArrayList<>();
		for(int i : arr1) {
			v.add(i);
		}
		System.out.println(fun2(arr1,arr1.length,2));
	}
	
	static int mod = 1000000007;
	
	private static int function(int[] arr) {
		int n = arr.length;
		int count =0;
		int unplacedZeros = 0;
		
		for(int i=n-1;i>=0;i--) {
			if((arr[i] & 1) == 0) {
				unplacedZeros = (unplacedZeros + 1)%mod;
			} else {
				count = (count + unplacedZeros)%mod;
			}
		}
		
		return count;
		
	}
	
	public static int fun2(int A[], int n, int K) {
		int count = 0;
        for(int a_i=0; a_i < n; a_i++){
            int number = A[a_i];
            number = number % K;
            int complement = number == 0 ? K : number;
            count += A[K-complement];
            A[number] += 1;
        }
        return count;
    }

//    public static int sum(int Ai, int Aj, int i, int j) {
//        return Math.abs(Ai-Aj) + Math.abs(i-j);
//    }
	
	
	
//	  max( f(j, k - 1) + Aj - Ai )
//	  = -Ai + max(f(j, k - 1) + Aj)
//
//	  when Ai < Aj
	
//	count = 0
//		    num_unplaced_zeros = 0
//		       
//		    for index in range(len(arr)-1,-1,-1): 
//		        if arr[index] == 0: 
//		            num_unplaced_zeros += 1
//		        else: 
//		            count += num_unplaced_zeros 
//		    return count 
//		   
//		arr = [0, 0, 1, 0, 1, 1, 0, 1, 1]  
//		print(minswaps(arr)) 

}
