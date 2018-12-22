package July8;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] pre = {50,25,12,37,75,62,60,70,87,80,90};
		int [] in = {12,25,37,50,60,62,70,75,80,87,90};
		
		BST bst = new BST(in) ;
		
		bst.display();
		
		bst.printrange(37, 75);
//		bst.replaceWSumLarger();
//		bst.display();
//		System.out.println();
//		bst.replaceWSumLarger2();
//		bst.display();
		bst.addNode(93);
		bst.display();
		bst.removeNode(93);
		System.out.println();
		bst.display();
		bst.removeNode(87);
		System.out.println();
		bst.display();
		System.out.println();
		System.out.println(bst.size());
		bst.removeNode(80);
		bst.display();
		System.out.println(bst.size());
	}

}
