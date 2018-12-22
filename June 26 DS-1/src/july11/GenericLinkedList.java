package july11;


//import LinkedList.LinkedList.Node;

public class GenericLinkedList <T>{

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public GenericLinkedList() {

	}

	public int size() {

		return this.size;
	}

	public boolean isEmpty() {

		return this.size() == 0;
	}

	public void display() {

		Node temp = this.head;
		System.out.println();
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;	
		}
		System.out.println();
	}

	public T getFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		return this.head.data;

	}

	public T getLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		return this.tail.data;
	}

	public T getAt(int idx) throws Exception {

		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		if (idx < 0 || idx >= this.size) {

			throw new Exception("Bhai Index out of bound");
		}

		Node temp = this.head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;

	}

	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("SIze is zero");
		}

		if (idx < 0 || idx >= this.size) {

			throw new Exception("Index out of bound");
		}

		Node temp = this.head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;

	}
	
	public void addLast(T data) {

		// create new node
		Node nn = new Node();

		// setting values in new node
		nn.data = data;
		nn.next = null;

		// attaching to the train
		if (this.size() > 0) {

			this.tail.next = nn;
		}

		// updating values of summary
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {

			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst (T data) {
		// create new node
		Node nn = new Node() ; 
		
		// set values
		nn.data = data ; 
		nn.next =null ;
		
		// attach
		nn.next = this.head ;
		
		//update summary
		if(this.size>0) {
			this.head = nn ; 
			this.size++ ;
		}
		
		else {
			this.head = nn ;
			this.tail =nn ; 
			this.size++ ;
			
		}
		
	}

	public void addAt(T data , int idx) throws Exception{
		
		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		if (idx < 0 || idx >= this.size) {

			throw new Exception("Index out of bound");
		}
		
	 // create new node
			Node nn = new Node();
		// values in new node 	
			nn.data = data;
			nn.next = null ; 
	//	attaching to train 
			 
			if(idx==0 ) {
			
				this.addFirst(data);
			}else if
			 (idx == this.size) {
				this.addLast(data);
			}else  {
				Node nm1 = this.getNodeAt(idx-1); 
				Node np1 = nm1.next;
				
				nm1.next = nn ; 
				nn.next = np1 ; 
				
			}
			// update the values 
			
			if (this.size== 0) {
				this.head = nn ;
				this.tail = nn ; 
				this.size++ ;
				
			}else {
				
				this.size++ ;
			}
			
			
			
			
			
	
	}

	public T removeFirst() throws Exception{
		if (this.size==0) {
			throw new Exception("Empty");
		}
		
		
		T rv = this.head.data ;
		
	//	Node temp = this.head.next; 
	//	this.head = temp ; 
		
		// update summary 
		if (this.size==1) {
			this.head = null; 
			this.tail = null ;
		}else {
			
			this.head = this.head.next ; 
		}
		
		
		this.size--;
		return rv; 
		
	}
	
	public T removeLast() throws Exception{
		if(this.size==0) {
			throw new Exception("Empty");
		}
		
		T rv = this.tail.data;
		
		
		
		
		
		// update summary 
		
		if (this.size == 1 ) {
			this.head = null;
			this.tail = null ; 
		}else {
			Node sm2 = this.getNodeAt(this.size-2) ;
			sm2.next = null ;
			this.tail = sm2 ; 
		}
		
		this.size-- ;
		
		
		
		
		
		return rv ;
		
		
	}
	
	public T removeAt(int idx) throws Exception{
		
		if(this.size==0) {
		throw new Exception("Empty");
		}
		if (idx < 0 || idx >= this.size) { // check this 

			throw new Exception("Index out of bound");
		}
		
		
		T rv = this.getNodeAt(idx).data ; 
		
		if(idx==0) {
			
			return this.removeFirst();
		}
		else if (idx == this.size-1) {
			
			return this.removeLast();
		}else {
			Node nm1 = this.getNodeAt(idx -1) ; 
			Node n = this.getNodeAt(idx);
			Node np1 = n.next ; 
			
			nm1.next = np1 ; 
		}
		
		// update the summary 
		
		if (this.size== 1) {
			this.head = null ;
			this.tail = null ;
			this.size -- ;
		}else
		{
			
			this.size--;
		}
		
		
		return rv ; 
	}
	}