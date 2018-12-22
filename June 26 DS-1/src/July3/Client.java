package July3;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//10  3 20 2 50 0 60 0 30 0 40 2 70 0 80 1 90 0 && rb.justlarge > node.data
		//

		GenericTreesExtra gt = new GenericTreesExtra();
		gt.display();
		
		System.out.println(gt.size());
		System.out.println(gt.find(300));
		System.out.println(gt.max());
		gt.linearize();
		gt.display();
//		System.out.println(gt.height());
//		gt.mirror();
//		gt.display();
//		gt.linearizeEff();
//		gt.display();
//		System.out.println(gt.isEmpty());
		
//		gt.preOrder();
//		System.out.println();
//		gt.postOrder();
//		System.out.println();
		gt.levelOrder();
//		gt.levelOrderOnNextLine();
//		gt.Zigzac();
//		gt.PreOrderPair();
//		gt.PostOrderPair();
//		System.out.println("****************");
//		gt.multiSolver(30);
//		int kth =gt.KthSmallest(3);
//		System.out.println(kth + " kth");
//		gt.removeLeaves();
//		gt.display();
//		System.out.println(gt.IsMirrorImage());
	}

	// is bst of not 
//	public class CompleteBTree {
//		
//		private class Node {
//			Node right;
//			Node left ;
//			int data;
//			
//			public Node() {
//				this.left=null;
//				this.right=null;
//			}
//		}
//		
//		private int size;
//		private Node root;
//		
//		public CompleteBTree() {
//			this.size=0;
//			this.root=
//		}
//		
//	}
//	
	
	
}
