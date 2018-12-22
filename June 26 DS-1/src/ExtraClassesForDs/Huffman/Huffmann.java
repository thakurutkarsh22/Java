package ExtraClassesForDs.Huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import july11.GenericHeap;


public class Huffmann {
	public static class Node  {
		Character data ;
		Integer freq ;
		Node left;
		Node right;
		
		
	}
	
	private java.util.HashMap<String, Character> decoder = new java.util.HashMap<>();
	private java.util.HashMap<Character, String> encoder = new java.util.HashMap<>();
	
	public static final constructor ctors = new constructor();
	public static class constructor implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o2.freq-o1.freq;
		}
		
	}
	
	public  Huffmann (String feeder) {
		// freq map 
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(int i =0 ; i < feeder.length() ; i++) {
			Character ch = feeder.charAt(i);
			if(fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch)+1);
			}else {
				fmap.put(ch, 1);
			}
		}
		
		//// 2. create nodes for all keys and fill in the heap
		GenericHeap<Node> heap = new GenericHeap<>();
		Set<Character> key = fmap.keySet();
		for(Character keys : key) {
			Character ch = keys;
			Node nm = new Node();
			nm.data = keys;
			nm.freq = fmap.get(ch);
		}
		// 3. till heap size is 1 -> remove two, merge and put it back
		
		while(heap.size()!=1) {
			Node one = heap.remove();
			Node two = heap.remove();
			
			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one ;
			merged.right = two ;
			
			heap.add(merged);
		}
		
		
		// 4. Get the final node out
		
		Node rm = heap.remove();
		traverse(rm ,"");
		
		
	}

	private void traverse(Node node, String wsf) {
		if(node == null){
			return;
		}
		
		if(node.left == null && node.right == null){
			encoder.put(node.data, wsf);
			decoder.put(wsf, node.data);
		}
		
		traverse(node.left, wsf + "0");
		traverse(node.right, wsf + "1");
	}

	public String encode(String str){
		String rv = "";
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			String code = encoder.get(ch);
			rv += code;
		}
		
		return rv;
	}
	
	public String decode(String str){
		String rv = "";
		String key = "";
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			key += ch;
			
			if(decoder.containsKey(key)){
				rv += decoder.get(key);
				key = "";
			}
		}
		
		return rv;
	}
}