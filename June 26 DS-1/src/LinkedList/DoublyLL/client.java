package LinkedList.DoublyLL;

public class client {

	public static void main(String[] args) throws Exception {

		DoublyLL d= new DoublyLL();
		d.addFirst(20);
		d.addLast(30);
		System.out.println(d.size());
		d.addAT(1, 25);
		d.display();
		
	}

}
