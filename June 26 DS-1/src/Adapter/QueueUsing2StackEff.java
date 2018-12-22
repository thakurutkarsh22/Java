package Adapter;

import Adapter.StackUsingLL.StackUsingLL;

public class QueueUsing2StackEff {

	private StackUsingLL primary;

	public QueueUsing2StackEff() {
		this.primary = new StackUsingLL();

	}

	// Dequqeu Efficinet

	public void enqueue(int item) throws Exception {

		StackUsingLL helper = new StackUsingLL();
		
		while(this.primary.size()!=0) {
			helper.push(this.primary.pop());
		}
		this.primary.push(item);
		
		while(helper.size()!=0) {
			
			this.primary.push(helper.pop());
		}
		
		
		
	}
	
	public int dequeue() throws Exception {
		try {
			return this.primary.pop();
		}catch (Exception ex) {
			
			throw new Exception("Queue IS EMpty");
		}
		
	}
	public int front() throws Exception {
		return this.primary.top();
		
	}

	public boolean isEmpty() throws Exception {

		return this.size() == 0;
	}

	public int size() throws Exception {

		return this.primary.size();
	}

	public void display() throws Exception{
		
		this.primary.display();
		System.out.println();
	}
}
