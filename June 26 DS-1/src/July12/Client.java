package July12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// HashMap<String , Integer > popmap = new HashMap<>() ;

//		System.out.println(highestfreqchar("dmoneyd"));

		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 1, 2, 2, 2, 4, 5 };
		int[] minNoofop = {1,5,5,10,10};
		int[]arr = {1,2,3,5,8,9,10,11,12,15,20,21,22,25};
		ArrayList<Integer> kk = continuituQ3(arr);
		System.out.println(kk);
//		System.out.println(minnoofOperations(minNoofop));
//		ArrayList<Integer> p = gce1(one, two);
//		System.out.println(p);
//		ArrayList<Integer> k = gce2(one, two);
//		System.out.println(k);
	}

	public static Character highestfreqchar(String word) {

		HashMap<Character, Integer> hcf = new HashMap<>();
		Character ch; //
		for (int i = 0; i < word.length(); i++) {

			ch = word.charAt(i);
			if (hcf.containsKey(ch)) {
				hcf.put(ch, hcf.get(ch) + 1);

			} else {
				hcf.put(ch, 1);
			}
		}

		Character maxc = ' ';
		int maxF = 0;

		Set<Character> keys = hcf.keySet();
		for (Character key : keys) {
			int freq = hcf.get(key);
			if (freq > maxF) {
				maxF = freq;
				maxc = key;
			}

		}

		return maxc;

	}

	public static Integer minnoofOperations(int[] arr) {
		// [1,5,5,10,10] == no of operations = 7 to make all the numbers equal
		HashMap<Character, Integer> hcf = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 5) {
				int k = arr[i] % 5;
				arr[i] -= k*5;
				
			}
		
			HashMap<Integer, Integer> max = new HashMap<>() ;

		}
		for (int i= 0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		return 0;
		
		

	}

	public static ArrayList<Integer> gce1(int[] one, int[] two) {

		HashMap<Integer, Integer> chk = new HashMap<>();

		// for one
		int k;
		for (int i = 0; i < one.length; i++) {
			k = one[i];
			if (chk.containsKey(k)) {
				chk.put(k, chk.get(k) + 1);

			} else {
				chk.put(k, 1);
			}

		}

		System.out.println(chk);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {

			int p = two[i];
			if (chk.containsKey(p)) {
				list.add(p);
				chk.remove(p);
			} else {

			}
		}
		return list;

	}

	public static ArrayList<Integer> gce2(int[] one, int[] two) {

		HashMap<Integer, Integer> chk = new HashMap<>();
		int k;
		for (int i = 0; i < one.length; i++) {
			k = one[i];
			if (chk.containsKey(k)) {
				chk.put(k, chk.get(k) + 1);

			} else {
				chk.put(k, 1);
			}

		}

		System.out.println(chk);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {

			int p = two[i];
			if (chk.containsKey(p) && chk.get(p) > 0) {

				list.add(p);
				chk.put(p, chk.get(p) - 1);

			}

		}
		return list;

	}
	
	public static ArrayList<Integer> continuituQ3(int[] arr){
		
		HashMap<Integer, Boolean> conta =new HashMap<>() ;
		
		for (int val : arr) {
			
			int valm1 = val-1; 
			int valp1 = val+1 ;
			if (conta.containsKey(valm1)) {
				
				conta.put(val, false);
			}else {
				
				conta.put(val, true);
			}
			
			if(conta.containsKey(valp1)) {
				
				conta.put(valp1, false);
			}
			
		}
		
		System.out.println(conta);
		
		
		
		ArrayList<Integer> largest = new ArrayList<>();

		Set<Integer> nums = conta.keySet();
		System.out.println(nums);
		
		
		for (Integer num : nums) {
			if (conta.get(num) == true) {
				ArrayList<Integer> temp = new ArrayList<>() ;

				System.out.println(num + "needed true");
				
				int count= 0 ;
				while (conta.containsKey(num + count)) {
					temp.add(num + count);
					count++;
				}
				
				if (temp.size() > largest.size()) {
					
					largest = temp ; 
				}
				
				
				

			}else {
				continue;
			}
		}

		return largest;
	}
		
		
	

}
