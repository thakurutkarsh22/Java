package July5;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
// 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false
		// 50 true 20 true 30 true 40 false false false false false 
		//bst 50 true 25 true 12 false false true 37 false false true 75 true 60 false false true 87 false false 
//20 true 8 true 4 false false true 12 true 10 false false true 14 false false true 22 false true 25 false false
//1 true 2 true 4 false false true 5 false false true 3 true 6 false true 8 false false true 7 false true 9 false false	
//8 true 3 true 1 false false true 6 true 4 false false true 7 false false true 10 false true 14 true 13 false false false 
// for stepwise 1 true 2 false false true 3 true 4 true 6 false false false true 5 true 7 false false true 8 false false
//2 true 3 true 6 false false true 7 false false true -20 true 8 false false true 9 false false 
// sum of subtree -1 true -2 true 4 false false true 5 false false true 3 true -6 false false true 2 false false
		BinaryTree bt = new BinaryTree();
		bt.display();
//		bt.stepWise();
//		System.out.println();
//		bt.display();
//		bt.decode();
//		bt.printboundary();
//		bt.printvertical();
//		System.out.println();
//		bt.display();
		bt.printDiagonal();
//		System.out.println();
////		System.out.println(bt.max());
////		System.out.println(bt.min());
////		System.out.println(bt.find(25));
//		System.out.println(bt.height() + " height");
//		System.out.println(bt.diameter()+ " Diameter");
//		System.out.println(bt.diameter2() + " Diameter 2");
//		System.out.println(bt.Isbalanced());
//		System.out.println(bt.IsBst());  //doubt
//		System.out.println(bt.isCompleteBT() + " is complete Bt ");
//		bt.Morris();
//		bt.preorderI();
//		System.out.println();
//		bt.postOrder();
//		System.out.println();
//		bt.InOrder();
		//bt.display();
//		bt.levelOrder();
//		System.out.println();
//		bt.display();
		
//		int [] pre = {50,25,12,37,75,62,60,70,87,80,90};
//		int [] pos = {12,37,25,60,70,62,80,90,87,75,50};
//		int [] in = {12,25,37,50,60,62,70,75,80,87,90};
////		
//	BinaryTree at = new BinaryTree(pos , in);
//	at.display();
//		int k =bt.sumofSubtree();
//		bt.sumofSubtree2();
//		System.out.println(k);
		// bt.multiSolver(25);
		
//		bt.printSpecificLevelOrder();
		
	}

}
