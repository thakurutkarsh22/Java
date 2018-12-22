package Adapter;

public class ClientqueueusingStacks {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		QueueUsing2Stacks q = new QueueUsing2Stacks() ;
		
		System.out.println(q.isEmpty());
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		q.dequeue();
		q.display();
		q.display();
//		
//		System.out.println(q.front() + "front");
//	//	q.dequeue();
//		q.display();
//		q.dequeue();
//		q.display();
//	//	q.front();
//		System.out.println(q.isEmpty() + " is empty");
//		System.out.println(q.size() + " size");
//		System.out.println(q.front());
	
		
		
		
		
		
		
//		QueueUsing2StackEff k = new QueueUsing2StackEff();
//		System.out.println(k.isEmpty());
//		System.out.println(k.size());
//		k.enqueue(10);
//	System.out.println(k.front() + "fro");
//		
//		k.enqueue(20);
//		System.out.println(k.front() + "fro");
//		k.enqueue(30);
//		k.dequeue();
//		System.out.println(k.front() + "for");
//		k.enqueue(40);
//////		System.out.println(k.front());
//		k.enqueue(50);
//		k.enqueue(60);// sameer gulati 
////		System.out.println(k.front());
//		k.dequeue();
//		k.display();
//		k.dequeue();
//		k.display();
//		System.out.println(k.isEmpty());
//		System.out.println(k.size());
//		System.out.println(k.front());
//	
	}

}
