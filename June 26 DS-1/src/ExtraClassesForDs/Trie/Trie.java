package ExtraClassesForDs.Trie;

import java.util.ArrayList;
import java.util.HashMap;

import ExtraClassesForDs.HashMap.HashmapClient;


public class Trie {

	private class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node> table = new HashMap<>();

	}

	private Node root = new Node();
	private int numWords = 0;
	private int numNodes = 1;

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			numWords++;
			node.eow=true;
			return;
		}

		char ch = word.charAt(0);
		
		String ros = word.substring(1);

		Node c = node.table.get(ch);

		if (c != null) {
			addWord(c, ros);

		} else {
			this.numNodes++;
			Node child = new Node();
			
			child.data = ch;
			node.table.put(ch, child);
			addWord(child, ros);
		}

	}

	public boolean Search(String word) {
		return Search(root, word);
	}

	private boolean Search(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.table.get(ch);

		if (child != null) {
			return Search(child, ros);
		} else {
			return false;
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node parent, String word) {

		if (word.length() == 0) {

			parent.eow = false;
			this.numWords--;
			return;
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.table.get(ch);

		if (child == null) {
			return;
		}

		removeWord(child, ros);

		if (child.eow == false && child.table.size() == 0) {

			parent.table.remove(ch);
			numNodes--;

		}

	}
	
	public void display() {
		display(root,"");
	}

	private void display(Node node, String str) {
		if(node.eow) {
			System.out.println(str);
		}
		
		ArrayList<Character> keys=  new ArrayList<>(node.table.keySet());
		for(Character key:keys) {
			Node child = node.table.get(key);
			display(child, str+key);
		}
	}

}
