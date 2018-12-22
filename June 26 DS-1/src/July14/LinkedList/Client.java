package LinkedList;
public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LinkedList k = new LinkedList() ; 
		
		k.addLast(10);
		k.addLast(20);
		k.addLast(30);
		k.addLast(40);
		k.addLast(50);
		k.addLast(60);
//		k.addLast(70);
//		
		k.display();
//		System.out.println();
//		System.out.println(k.getAt(4));
//		
//		System.out.println(k.getFirst());
//		System.out.println(k.getLast());
//		
//		System.out.println(k.size());
//		System.out.println(k.isEmpty());
//		
//		k.removeLast();
//		k.removeFirst();
//		k.display();
////		k.addFirst(10);
////		k.addLast(50);
////		k.display();
////		k.addAt(100, 1);
////		k.display();
//		k.removeAt(1); 
//		k.removeFirst();
//		k.display();
//		k.removeFirst();
//		k.display();
//		System.out.println(k.isEmpty());
		
		k.reverseDr();
		k.display();
//		k.fold();
//		k.display();
		System.out.println(k.mid());
		System.out.println(k.kthElementFromLast(6));
		
	}

}
