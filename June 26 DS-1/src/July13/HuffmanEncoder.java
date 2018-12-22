package July13;

import java.util.ArrayList;
import java.util.HashMap;

import july11.GenericHeap;

public class HuffmanEncoder {

	private class Node implements Comparable<Node> {

		Character ch;
		Integer cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {

			return o.cost - this.cost;
		}

	}

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public HuffmanEncoder(String feeder) {

		// 1. frequency map

		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			Character ch = feeder.charAt(i);
			if (fmap.containsKey(feeder.charAt(i))) {

				fmap.put(ch, fmap.get(ch) + 1);

			} else {
				fmap.put(ch, 1);
			}
		}

		// 2 create node for all keys
		
		GenericHeap<Node> heap = new GenericHeap<>(null);
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for (Character key : keys) {

			Node node = new Node();
			node.ch = key;
			node.cost = fmap.get(key);
			heap.add(node);

		}

		// 3 . while heap is not equ
		while (heap.size() != 1) {

			Node one = heap.remove();
			Node two = heap.remove();

			Node merged = new Node();
			merged.cost = one.cost + two.cost;
			merged.left = one;
			merged.right = two;

			heap.add(merged);
		}

		Node finalnode = heap.remove();
		fillENcoderDecoder(finalnode, "");
		System.out.println(encoder);
		System.out.println(decoder);

	}

	private void fillENcoderDecoder(Node node, String wsf) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			encoder.put(node.ch, wsf);
			decoder.put(wsf, node.ch);

		}

		fillENcoderDecoder(node.left, wsf + "0");
		fillENcoderDecoder(node.right, wsf + "1");

	}

	public String encode(String str) {

		String rv = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ro = encoder.get(ch);
			rv += ro;
		}

		return rv;

	}

	public String decode(String str) {

		String rv = "";
		String p = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// String ro = encoder.get(ch);
			p += ch;
			if (decoder.containsKey(p)) {
				rv += decoder.get(p);
				p = "";
			}
		}

		return rv;

	}

}
