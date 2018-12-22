package ExtraClassesForDs.BinarySearchTree;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pre = {50,25,12,37,75,62,87};
		int[] pos = {12 , 37 , 25 , 62 , 87 , 75 , 50 };
		int[] in = {12,25,37,50,62,75,87};
		int[] arr = {10 , 20 , 30 , 40 ,50 ,60 ,70};
		int[]arr1 = {12,25,30,37,49,50,60,62,75,87,89};
		
//		BST b = new BST(pre, in);
//		System.out.println("abc");
		BST b = new BST(arr);
		b.display();
//		b.removeLeaf(40);
//		System.out.println();
//		b.display();
		
		b.sumReplace();
//		b.sumtree();
		System.out.println("yyoyoy");
		b.display();
//		System.out.println("ypypyyoy");
//		b.sumReplace();
//		System.out.println("------------l----");
//		b.display();
//		b.printInRange(70, 600);
	}	

}
