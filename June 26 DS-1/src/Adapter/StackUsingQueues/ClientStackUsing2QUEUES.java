package Adapter.StackUsingQueues;

public class ClientStackUsing2QUEUES {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//
//	StacksUsing2Queues stk = new StacksUsing2Queues() ;
//		stk.push(1);
//		stk.push(2);
//		stk.push(3);
//		stk.push(4);
//		stk.push(5);
//		stk.push(6);
		
//		stk.display();
//		System.out.println();
//		stk.display();
//		System.out.println(stk.top() + " top");
//		System.out.println(stk.isempty());
//		System.out.println(stk.size());
//		
//		System.out.println("*****");
//		
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println("table");
//		stk.display();
//		
//		System.out.println("end");
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//	//	System.out.println(stk.pop());
//		System.out.println("*****");
//		stk.display();
		
		
		StacksUsing2QueuesONPush stk = new StacksUsing2QueuesONPush() ;
		System.out.println(stk.isempty());
		stk.push(1);
		stk.push(2);
		System.out.println(stk.isempty());
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		
		stk.display();
stk.display();
		
		System.out.println("*****");
		System.out.println(stk.top());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
	//	System.out.println(stk.pop());
		System.out.println("*****");
		stk.display();
		stk.display();
		
		
	}

}
