package July13;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws Exception {

//		System.out.println(highestfreqchar("alskasd"));
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%55");
//System.out.println(highestfreqchar("qwertyuioplkjhgffff"));
	
		
		HuffmanEncoder k = new HuffmanEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbccd");
		System.out.println(k.encode("ababcdcd"));
		System.out.println(k.decode("101101001000001000"));
		
	
	
	
	
	}

	public static Character highestfreqchar(String word) throws Exception {

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
		hcf.dispaly();
		Character maxc = ' ';
		int maxF = 0;

		ArrayList<Character> keys = hcf.keySet();
		for (Character key : keys) {
			int freq = hcf.get(key);
			if (freq > maxF) {
				maxF = freq;
				maxc = key;
			}

		}

		return maxc;

	}

}
