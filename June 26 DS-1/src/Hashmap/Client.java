package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// HashMap<String , Integer> popmap = new HashMap<>();
		//
		// popmap.put("India", 120);
		// popmap.put("China", 200);
		// popmap.put("Pak", 80);
		// popmap.put("US", 25);
		// popmap.put("Utopia", null);
		//
		// Set <String> keys = popmap.keySet();
		// for(String key : keys) {
		// System.out.println(key + "\t");
		// }
		//
		// char ch = hcf("abcadddfghgh");
		// System.out.println(ch);
		//
		Integer[] ans = {2,12,9,16,10,5,3,20,25,11,1,8,6};
		Integer[] one = { 1, 1, 2, 2, 2, 3, 5 };
		Integer[] two = { 1, 1, 1, 2, 2, 4, 5 };
		ArrayList<Integer> k = continuity(ans);
		System.out.println(k);

	}

	public static Character hcf(String word) {

		// high character frequency return
		HashMap<Character, Integer> hcf = new HashMap<>();
		char ch;
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

	public static ArrayList<Integer> gec1(Integer[] one, Integer[] two) {

		HashMap<Integer, Integer> geca = new HashMap<>();
		// HashMap<Integer, Integer> gecb = new HashMap<>();

		// for one
		int ch;
		for (int i = 0; i < one.length; i++) {

			ch = one[i];
			if (geca.containsKey(ch)) {
				geca.put(ch, geca.get(ch) + 1);

			} else {
				geca.put(ch, 1);
			}
		}

		System.out.println(geca);

		ArrayList<Integer> kk = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {

			if (geca.containsKey(two[i])) {
				kk.add(two[i]);
				geca.remove(two[i]);

			}

		}

		// // for two
		// int ch2 ;
		// for (int i =0 ; i<two.length ; i++ ) {
		//
		// ch2 = two[i];
		// if (geca.containsKey(ch2)){
		// geca.put(ch2, geca.get(ch2) +1 );
		//
		// }else {
		// geca.put(ch2, 1);
		// }
		// }
		//
		// System.out.println(gecb);
		//
		return kk;

	}

	public static ArrayList<Integer> gec2(Integer[] one, Integer[] two) {

		HashMap<Integer, Integer> geca = new HashMap<>();

		int ch;
		for (int i = 0; i < one.length; i++) {

			ch = one[i];
			if (geca.containsKey(ch)) {
				geca.put(ch, geca.get(ch) + 1);

			} else {
				geca.put(ch, 1);
			}
		}

		System.out.println(geca);

		ArrayList<Integer> kk = new ArrayList<>();
		int ch2;

		for (int i = 0; i < two.length; i++) {

			ch2 = two[i];
			if (geca.containsKey(two[i]) && geca.get(two[i]) > 0) {
				kk.add(two[i]);
				geca.put(ch2, geca.get(ch2) - 1);

			}

		}

		return kk;

	}

	public static ArrayList<Integer> continuity(Integer[] one) {

		// O(n)

		HashMap<Integer, Boolean> conta = new HashMap<>();

		for (int val : one) {

			int valm1 = val - 1;
			int valp1 = val + 1;
			if (conta.containsKey(valm1)) {

				conta.put(val, false);

			} else {

				conta.put(val, true);
			}
			if (conta.containsKey(valp1)) {

				conta.put(valp1, false);

			}

		}
		
		ArrayList<Integer> largest = new ArrayList<>();

		Set<Integer> nums = conta.keySet();
		for (Integer num : nums) {
			if (conta.get(num) == true) {
				ArrayList<Integer> temp = new ArrayList<>();
				int sos = num;
				int los = 0;

				while (conta.containsKey(sos + los)) {

					temp.add(sos + los);
					los++;
				}

				if (temp.size() > largest.size()) {

					largest = temp;
				}

			}
		}

		return largest;
	}

}