package LinkedList.DoublyLL;


public class DoublyLL {

	private Node head ;
	private Node tail ;
	private int size ;
	
	private static class Node{
		Node next;
		Node prev;
		int data ;
	}
	
	// add first // add at // add last // 
	
	public int size() {
		return this.size;
	}
	public boolean isEMpty() {
		return this.size==0;
	}
	public void addFirst(int data) {
		
		Node node = new Node();
		node.data = data ;
		node.prev =null ;
		
		if(this.size>0) {
			node.next = this.head;
			this.head.prev =node ;
			
		}
		
		// updating summary
		if(this.size==0) {
			this.head = node ;
			this.tail = node ;
			this.size++;
		}else {
			this.head =node ;
			this.size++;
		}
		
		
		
		
	}
	
	public void addAT(int idx , int data) throws Exception {
		
		if(idx < 0 || idx > this.size) {
			throw new Exception("Not possible");
		}
		
		Node node = new Node();
		node.data=data;
		
		if(idx==0) {
			this.addFirst(data);
		}else if (idx == this.size) {
			this.addLast(data);
		}else {
			Node temp = getNodeAT(idx-1);
			node.next = temp.next;
			node.prev = temp;
			temp.next =node ;
			node.next.prev = node ;
		}
		
		// updating vaues 
		if(this.size==0) {
			this.head =node;
			this.tail =node ;
			this.size++;
		}else {
			this.size++;
		}
		
		
	}
	private Node getNodeAT(int idx) throws Exception {
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
	
	public void addLast(int data) {
		Node node = new Node();
		node.data=data;
		node.next=null;
		
		if(this.size>0) {
			this.tail.next = node ;
			node.prev = this.tail;
		}
		
		// updating summary
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
			this.size++;
		} else {

			this.tail = node;
			this.size++;
		}
	}
	
	
	public void display() {
		//System.out.println("***************");
				Node temp = this.head;
				System.out.println();
				while (temp != null) {
					System.out.print(temp.data + " ");
					temp = temp.next;	
				}
				System.out.println();
			}
}
