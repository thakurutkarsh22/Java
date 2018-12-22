package Adapter.StackUsingQueues;

import Adapter.QueuesUsingLL.QueueUsingLL;

public class StacksUsing2QueuesONPush {

	private QueueUsingLL primary ; //= new QueueUsingLL() ;
//	private QueueUsingLL helper;

	public StacksUsing2QueuesONPush() {
		this.primary = new QueueUsingLL();

	}

	public void push(int item) throws Exception {

		QueueUsingLL helper = new QueueUsingLL();

		helper.enqueue(item);
		
		while(this.primary.size() != 0) {
			
			int k =(this.primary.dequeue());
			helper.enqueue(k);
		//	helper.display();
			
		}
		this.primary = helper ; 
		helper = new QueueUsingLL();
		

	}

	public int pop() throws Exception {

		return this.primary.dequeue();

	}

	public int top() throws Exception {

		return this.primary.front();
	}

	public boolean isempty() {

		return this.size() == 0;
	}

	public int size() {

		return this.primary.size();
	}

	public void display() {

		this.primary.display();

	}

}
