package Adapter.QueuesUsingLL;

public class clientQULL {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		QueueUsingLL q = new QueueUsingLL(); 
		
		q.display();
		System.out.println(q.isempty());
		System.out.println();
		System.out.println(q.size() + "size");
		q.enqueue(10);
		System.out.println(q.front() + "front");
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println(q.front() + "front");
		q.display();
		System.out.println(q.front() + "front");
		System.out.println(q.isempty());
		System.out.println(q.size());
		
//		
		
		
		
		
	}

}
