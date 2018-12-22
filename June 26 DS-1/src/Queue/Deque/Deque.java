package Queue.Deque;

public class Deque {

	protected int[] data;
	protected int size;
	protected int front;
	protected int rear;
	protected int s;

	public Deque(int cap) {
		this.size = cap;
		this.front = -1;
		this.s=0;
		this.rear = 0;
		this.data = new int[cap];
	}

	/*
	 * // Operations on Deque: void insertfront(int key); void insertrear(int key);
	 * void deletefront(); void deleterear(); bool isFull(); bool isEmpty(); int
	 * getFront(); int getRear();
	 */

	public boolean isEmpty() {
		 return (front == -1);
	}

	public boolean isFull() {
		if (((this.front == 0) && (this.rear == this.data.length - 1)) || this.rear == this.front - 1) {
			return true;
		} else {
			return false;
		}
	}

	public void insertFront(int item) throws Exception {

		if (this.isFull()) {
			throw new Exception("Full");
		}
		
		if(this.front==-1) {
			front = 0 ;
			rear = 0 ;
		}else if(this.front==0) {
			front = size-1 ;
			
		}else {
			this.front= front-1;
		}
		this.data[this.front]=item;
		s++;
	}

	public void insertRear(int item) throws Exception {
		
		if (this.isFull()) {
			throw new Exception("Full");
		}
		
		if (this.front==-1) {
			rear = 0;
			front =0 ;
		}else if (rear==size-1) {
			rear = 0 ;
		}else {
			rear=rear+1;
		}
		
		this.data[this.rear]=item;
		s++;
	}
	
	public int deleteFront() throws  Exception {
		
		if (this.isEmpty()) {
			throw new Exception("dEQUE IS EMPTY");
		}
		
		int rv = this.data[this.front];
		this.data[this.front]=(0); // doubt full linle 
		if (this.front==rear) {
			this.front=-1;
			this.rear=-1;
		}else if (front==size-1) {
			this.front=0;
		}else {
			front=front+1;
		}
		
		
		s--;
		return rv;
	}
	
	
	public int deleteRear() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("dEQUE IS EMPTY");
		}
		
		int rv = this.data[this.rear];
		this.data[this.rear]=0; // doubt full linle 
		if (this.front==rear) {
			this.front=-1;
			this.rear=-1;
		}else if(rear == 0) {
			rear=size-1;
		}else {
			rear=rear-1;
		}
		s--;
		return rv;
	}

	public int getFront() {
		return this.data[this.front];
	}
	public int getRear() {
		return this.data[this.rear];
	}
	
	public void display() {
		System.out.println("****************");
		for (int i =0 ; i < this.s ; i ++) {
			System.out.print((this.data[(this.front + i) % this.size]) + " ");
		}
		System.out.println(".");
		System.out.println("*******************");
	}
}
