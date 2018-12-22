package Queue;

public class Queue {

	protected int[] data;
	protected int size;
	protected int front;
//	protected int rear;

	public Queue(int cap) {
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
// linear queue only not implementing circular queue
	}

	public void enqueue(int item) throws Exception {

		if (this.data.length == this.size) {

			throw new Exception("This queue is full");
		}
//		this.rear = (this.front + this.size) % this.data.length;
		int tail = (this.front + this.size) % this.data.length;
		this.data[tail] = item;

		this.size++;

	}

	public int dequeue() throws Exception {

		if (this.size == 0) {
			throw new Exception("No more Dequeue  can happen");
		}

		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;

		return rv;

	}

	public int front() throws Exception {

		if (this.size == 0) {

			throw new Exception("The Queue is empty ");
		}
		int rv = this.data[this.front];

		return rv;

	}

	public int size() {

		int rv = this.size;
		return rv;
	}

	public boolean isempty() {

		return this.size == 0;

	}

	public void display() {

		System.out.println("*************************");
		for (int i = 0; i < this.size; i++) {

			System.out.print((this.data[(this.front + i) % this.data.length]) + " ");

		}
		System.out.println(".");
		System.out.println("**************************");
	}

//	public int rear() throws Exception {
//
//		if (this.size == 0) {
//
//			throw new Exception("The Queue is empty ");
//		}
//		
//		return data[this.rear];
//
//	}
}
