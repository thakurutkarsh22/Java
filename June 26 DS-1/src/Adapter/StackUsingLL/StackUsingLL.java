package Adapter.StackUsingLL;

import LinkedList.LinkedList;

public class StackUsingLL {
	
	private LinkedList data ; 
	
	public StackUsingLL() {
		this.data = new LinkedList() ; 
		
	}
	
	public void push(int item) {
		this.data.addFirst(item);
	}

	public int pop() throws Exception {
		try {
			return this.data.removeFirst();
		} catch (Exception ex) {
			System.out.println("Internal error => " + ex.getMessage());
			throw new Exception("Stack is empty");
		}
	}

	public int top() throws Exception {
		try {
			return this.data.getFirst();
		} catch (Exception ex) {
			//System.out.println("Internal error => " + ex.getMessage());
			throw new Exception("Stack is empty");
		}
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	public void display() {
		this.data.display();
		
	}
}