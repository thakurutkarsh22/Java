package July13;

public class TrieClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie() ;
		trie.addWord("abc");
		trie.addWord("abd");
		trie.addWord("abl");
		trie.addWord("axc");
//		trie.display();
		trie.displayTree();
	}

	
}
