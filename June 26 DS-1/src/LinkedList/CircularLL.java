package LinkedList;

public class CircularLL {

	private class Node {
		Node next ;
		int data ;
	}
	
	private int size ;
	private Node head ;
	private Node tail ;
	
	
	public void addLast(int data) {
		
		Node node = new Node();
		node.next =null;
		node.data= data;
		
		if(this.size>0) {
			this.tail.next = node ;
		}
		
		if(this.size==0) {
			this.head = node;
			this.tail = node ;
			this.size++;
			
		}else {
			this.tail =node ;
		}
		
		
		
		
		
		
	}
}
