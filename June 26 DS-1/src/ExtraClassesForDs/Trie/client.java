package ExtraClassesForDs.Trie;

public class client {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		t.addWord("abc");
		t.addWord("ant");
		t.addWord("and");
		System.out.println(t.Search("and"));
		t.removeWord("and");
		System.out.println(t.Search("and"));
		
		t.display();
	}

}
