
package Adapter.StackUsingQueues;

import Adapter.QueuesUsingLL.QueueUsingLL;

public class StacksUsing2Queues {

	private QueueUsingLL primary;
	// private QueueUsingLLs helper ;

	public StacksUsing2Queues() {
		this.primary = new QueueUsingLL();
		// this.helper = new QueueUsingLLs();

	}

	public void push(int item) throws Exception {

		this.primary.enqueue(item);

	}

	public int pop() throws Exception {
		int rv = 0;

		try {
			QueueUsingLL helper = new QueueUsingLL();
			while (this.primary.size() != 1) {
				helper.enqueue(this.primary.dequeue());
			}

			rv = this.primary.dequeue();
			this.primary = helper;
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}

		return rv;
	}


	public int top() throws Exception {

		if (this.size() == 0) {
			throw new Exception("Stack is Empty");
		}
		QueueUsingLL helper = new QueueUsingLL();

		while (this.primary.size() != 1) {
			helper.enqueue(this.primary.dequeue());
		}
		int rv = this.primary.dequeue();
		helper.enqueue(rv);
		// swap

		this.primary = helper;
		return rv;
	}

	public boolean isempty() {

		return this.size() == 0;
	}

	public int size() {

		return this.primary.size();
	}

	public void display() throws Exception {
		this.display(0);
	}

	private void display(int count) throws Exception {

		if (count == this.primary.size())
			return;
		int rv = this.primary.dequeue();
		this.primary.enqueue(rv);

		display(count + 1);

		System.out.println(rv );

	}

}
