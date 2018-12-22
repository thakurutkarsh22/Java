package Adapter;

import Adapter.StackUsingLL.StackUsingLL;

public class QueueUsing2Stacks {

	private StackUsingLL primary;
	// private StackUsingLL helper;
//	private int[] data;

	public QueueUsing2Stacks() {
		this.primary = new StackUsingLL();

	}

	// Enqueue eff
	
	public void enqueue(int item) {

		primary.push(item);

	}

	public int dequeue() throws Exception { 

		if (this.primary.size() == 0) {
			throw new Exception("Queue is EMpty");
		}

		StackUsingLL helper = new StackUsingLL();

		while (this.primary.size() != 0) {

			int p = this.primary.pop();
			helper.push(p);

		}

		this.primary = helper;

		helper = new StackUsingLL();

		int rv = primary.pop();
		// primary=helper;

		while (this.primary.size() != 0) {

			int p = this.primary.pop();
			helper.push(p);

		}
		this.primary = helper;

		return rv;

	}

	public int front() throws Exception {

		if (this.primary.size() == 0) {

			throw new Exception("The Queue is empty ");
		}

		if (this.primary.size() == 0) {
			throw new Exception("Queue is EMpty");
		}

		StackUsingLL helper = new StackUsingLL();

		while (this.primary.size() != 0) {

			int p = this.primary.pop();
			helper.push(p);

		}

		
		this.primary = helper;
		this.primary.top();

		helper = new StackUsingLL();

		int rv = primary.pop();
		// primary=helper;

		while (this.primary.size() != 0) {

			int p = this.primary.pop();
			helper.push(p);

		}
		this.primary = helper;

		return rv;

	}

	public boolean isEmpty() throws Exception {

		return this.size() == 0;
	}

	public int size() throws Exception {

		return this.primary.size();
	}

	public void display() throws Exception {
		if (this.primary.size() == 0) {
			throw new Exception("Queue is EMpty");
		}
		StackUsingLL helper = new StackUsingLL();

		while (this.primary.size() != 0) {

			int k = primary.pop();
			helper.push(k);
			// helper.display();

		}
		 helper.display();
		this.primary = helper;
		helper = new StackUsingLL();
		
		while(this.primary.size()!=0) {
			helper.push(this.primary.pop());
		}
		this.primary = helper ; 
		
	
	//display(0);
	}

	private void display(int count) throws Exception {

		if (count == this.primary.size())
			return;
		int rv = this.primary.pop();
		this.primary.push(rv);

		display(count + 1);

		System.out.print(rv );

	}
}
