package ExtraClassesForDs.Huffman;

import java.util.ArrayList;
import java.util.HashMap;

import ExtraClassesForDs.Generics.*;

public class Hman {

	private class Node implements Comparable<Node> {
		Character ch;
		int cost;
		Node left;
		Node right;
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();
	
	public Hman(String feeder){
		// 1. freq map
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(int i = 0; i < feeder.length(); i++){
			char ch = feeder.charAt(i);
			
			if(fmap.containsKey(feeder.charAt(i))){
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}
		
		// 2. create nodes for all keys and fill in the heap
		GenericHeap<Node> heap = new GenericHeap<>(null);
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for(Character key: keys){
			Node node = new Node();
			node.ch = key;
			node.cost = fmap.get(key);
			heap.add(node);
		}
		
		// 3. till heap size is 1 -> remove two, merge and put it back
		while(heap.size() != 1){
			Node one = heap.remove();
			Node two = heap.remove();
			
			Node merged = new Node();
			merged.cost = one.cost + two.cost;
			merged.left = one;
			merged.right = two;
			
			heap.add(merged);
		}
		
		// 4. Get the final node out
		Node finalNode = heap.remove();
		fillEncoderDecoder(finalNode, "");
	}
	
	private void fillEncoderDecoder(Node node, String wsf){
		if(node == null){
			return;
		}
		
		if(node.left == null && node.right == null){
			encoder.put(node.ch, wsf);
			decoder.put(wsf, node.ch);
		}
		
		fillEncoderDecoder(node.left, wsf + "0");
		fillEncoderDecoder(node.right, wsf + "1");
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