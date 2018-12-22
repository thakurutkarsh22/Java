package Queue.Deque;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Deque d = new Deque(5);
		
		d.insertRear(10);
		
		d.insertFront(20);
		d.insertRear(20);
		
		d.insertRear(30);
		d.insertRear(40);
//		d.insertRear(50);
//		System.out.println(d.isEmpty());
		System.out.println(d.getFront()+ " Front");
		System.out.println(d.getRear()+ " rear");
//		d.deleteRear();
		System.out.println(d.getRear()+ " rear");
		
		
		d.display();
		d.deleteFront();
		d.display();
		System.out.println("---");
		System.out.println(d.getFront());
		System.out.println(d.getRear());
		
	}

}
 