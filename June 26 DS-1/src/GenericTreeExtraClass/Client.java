package GenericTreeExtraClass;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 3 20 2 50 0 160 0 30 3 70 0 80 0 90 0 40 1 100 0

		GenericTree t = new GenericTree();
		t.display();
//		System.out.println(t.isEmpty());
//		System.out.println(t.size2());
//		System.out.println(t.max());
//		System.out.println(t.height());
//		System.out.println(t.find(160));
		
////		t.mirror();
//		System.out.println("--------");
////		t.display();
//		t.preOrder();
//		System.out.println();
//		t.postOrder();
//		t.levelOrderLineWise();
//		t.ziczac();
		System.out.println("-----------");
		t.printAtDepth(2);
		
	}

}
