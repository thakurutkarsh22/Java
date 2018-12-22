package ExtraClassesForDs.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashmapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(highestfreq("ababcab"));
		int[] one = {1,1,2,2,2,3,5};
		int[] two = {1,1,1,2,2,4,5};
		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
		ArrayList<Integer> k = gec2(one, two);
		System.out.println(k);
		ArrayList<Integer> kp = consequitive(arr);
		System.out.println(kp);
		
		

	} 

	public static Character highestfreq(String word) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (map.containsKey(ch)) {
				// update
				int k = map.get(ch);
				++k;
				map.put(ch, k);

			} else {
				map.put(ch, 1);
			}

		}

		Character ch = ' ';
		Integer freq = 0;

		Set<Character> key = map.keySet();

		for (Character cha : key) {

			if (map.get(cha) > freq) {
				freq = map.get(cha);
				ch = cha;
			} else {

			}

		}
		return ch;

	}

	public static ArrayList<Integer> gec1(int[] one, int[] two) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < one.length; i++) {
			int ch = one[i];

			if (map.containsKey(ch)) {
				// update
				int k = map.get(ch);
				++k;
				map.put(ch, k);

			} else {
				map.put(ch, 1);
			}

		}
		Set<Integer> key = map.keySet();
		ArrayList<Integer> arr = new ArrayList<>() ;
		
		for (int i =0 ; i<two.length ;i++) {
			int k = two[i];
			if(map.containsKey(k)){
				arr.add(k);
				map.remove(k);
			}
		}
		return arr;
		
	}

	public static ArrayList<Integer> gec2(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < one.length; i++) {
			int ch = one[i];

			if (map.containsKey(ch)) {
				// update
				int k = map.get(ch);
				++k;
				map.put(ch, k);

			} else {
				map.put(ch, 1);
			}

		}
		ArrayList<Integer> arr = new ArrayList<>() ;

		for (int i =0 ; i<two.length ;i++) {
			int k = two[i];
			if(map.containsKey(k)){
				int kp = map.get(k);
				if(kp>0) {
					arr.add(k);
					kp--;
					map.put(k, kp);
				}
				
				
				
			}
		}
		return arr;
	}
	
	public static ArrayList<Integer> consequitive (int[] arr){
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i =0 ; i < arr.length ; i++) {
			int k = arr[i];
			map.put(k, true);
		}
		for(int i =0 ; i < arr.length ; i++) {
			int k = arr[i];
			if(map.containsKey(k-1)) {
				map.put(k, false);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int max =0 ;
		int maxsp = 0 ;
		
		Set<Integer> key = map.keySet();
		for(Integer keys : key) {
			ArrayList<Integer> temp = new ArrayList<>() ;
			if(map.get(keys)==true) {
				int count =0;
				while(map.containsKey(count+keys)) {
					temp.add(count+keys);
					count++;
				}
				if(temp.size()>list.size()) {
					list = temp;
					
				}
				
			}
		}
		
		
		
		
		
		return list;
		
	}

}
