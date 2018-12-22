
package Adapter.QueuesUsingLL;

import LinkedList.LinkedList;

public class QueueUsingLL {

	private LinkedList data;

	// constructor
	public QueueUsingLL() {
		data = new LinkedList();

	}

	public void enqueue(int item) {
		this.data.addLast(item);

	}

	public int dequeue() throws Exception {

		try {
			return this.data.removeFirst();

		} catch (Exception ex) {
			System.out.println("Internal Error" + ex.getMessage());

			throw new Exception("Queue is Empty");
		}

	}

	public int front() throws Exception {

		
		try {
			return this.data.getFirst();

		} catch (Exception ex) {
			throw new Exception("Queue is Empty");
		}

		
	}

	public int size() {

		return this.data.size();
	}

	public boolean isempty() {
		return this.data.isEmpty();
	}

	public void display() {

		this.data.display();
		System.out.println();
	}
}
