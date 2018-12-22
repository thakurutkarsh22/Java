package LinkedList;
public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {

	}

	public int size() {

		return this.size;
	}

	public boolean isEmpty() {

		return this.size() == 0;
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

	public int getFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		return this.head.data;

	}

	public int getLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("SIze is zero");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {

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
	
	public void addLast(int data) {

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

	public void addFirst (int data) {
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

	public void addAt(int data , int idx) throws Exception{
		
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

	public int removeFirst() throws Exception{
		if (this.size == 0) {
			throw new Exception("List is empty");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return rv;
		
	}
	
	public int removeLast() throws Exception{
		if(this.size==0) {
			throw new Exception("Empty");
		}
		
		int rv = this.tail.data;
		
		
		
		
		
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
	
	public int removeAt(int idx) throws Exception{
		
		if(this.size==0) {
		throw new Exception("Empty");
		}
		if (idx < 0 || idx >= this.size) { // check this 

			throw new Exception("Index out of bound");
		}
		
		
		int rv = this.getNodeAt(idx).data ; 
		
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

	// 30th june 
	
	//(o n square )
	public void reverseDI() throws Exception{ // DI = data index
		int left = 0 , right = this.size - 1 ;
		
		while(left<right) {
			Node leftnode = this.getNodeAt(left);
			Node rightnode = this.getNodeAt(right);
			
			int temp = leftnode.data;
			leftnode.data = rightnode.data;
			rightnode.data = temp ;
			
			left++;
			right--; 
		}
	}
	
	// (O n )
	
	public void reversePI () { // NI = pointer index
		
		Node previous = this.head; // why this here ..........? 
		Node current = this.head.next ;
		Node Next ;
		
		
		while(current!=null) {
			Next= current.next;
			current.next = previous;
			previous = current;
			current=Next ; 
		}
		
		Node temp = this.head;
		this.head = this.tail;
		this.tail =temp;
		
		this.tail.next = null;
		
	}
	
	// O(n)
		public void reversePR() {
			this.reversePR_RH(this.head, this.head.next);
			
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
			
			this.tail.next = null;
		}

		private void reversePR_RH(Node prev, Node curr) {
			if(curr == null){
				return;
			}
			
			this.reversePR_RH(curr, curr.next);
			curr.next = prev;
		}
	
		//O(n)
	public void reverseDr() {
		
	//	this.reverseDr(this.head , this.head , 0);
		
		
		HeapMover left = new HeapMover();
		left.node = this.head;
		this.reverseDr(left, this.head, 0);
		
	}
	private Node reverseDr(Node left , Node right , int c) {
		
		if(right==null) {
			return left; 
		}
		
		left = reverseDr(left , right.next,c+1);
		
		if(c>this.size/2) {
			
			int temp = right.data;
			right.data=left.data;
			left.data = temp;
		}
		
		return left.next;
		
			
		}

	private void reverseDr(HeapMover left , Node right , int c)
	{
		if(right==null) {
			return ; 
		}
		
		reverseDr(left , right.next,c+1);
		if(c>=this.size() /2) {
			int temp = left.node.data ;
			left.node.data = right.data;
			right.data = temp ;
			
		}
		left.node = left.node.next ; 
		
	}
	
	private class HeapMover{
		Node node;
	}
	
	// 1st july 
	
	
	public void fold () {
		
		HeapMover left = new HeapMover();
		left.node = this.head;
		this.fold(left, this.head, 0);
	}
	
	private void fold(HeapMover left , Node right , int floor ) {
		if(right==null) {
			return ; 
		}
	
		fold(left , right.next , floor +1 );
		
		if (floor> this.size / 2) {
			Node temo = left.node.next; 
			left.node.next = right;
			right.next=temo;
			left.node = temo;
		}else if (floor== this.size / 2) {
			this.tail = right;
			this.tail.next = null ;
		}
	}
	

	public int mid () {
		return this.midNode(this.head , this.head).data;
	}
	
	private Node midNode(Node slow , Node fast) {
		
		while (fast.next !=null && fast.next.next !=null) {
		
			
			slow = slow.next;
			fast = fast.next.next;
		
			
		}
		
		
		
		
		return slow ;
		
	}
	
	public int kthElementFromLast (int k) {
	
		return kthElementFromLast(this.head, this.head, k).data;
		
	}
	
	private Node kthElementFromLast(Node slow , Node fast , int k) {
		
		while (k!=1 ) {
			
			fast = fast.next;
			k--;
			
			
		}
		
		while (fast.next !=null) {
			slow = slow.next;
			fast=fast.next;
			
		}
		
		return slow ; 
	}
	
	public LinkedList mergeTwoSortedLinkedLists(LinkedList other) {
		LinkedList rv = new LinkedList();

		Node ttemp = this.head, otemp = other.head;

		while (ttemp != null && otemp != null) {
			if (ttemp.data < otemp.data) {
				rv.addLast(ttemp.data);
				ttemp = ttemp.next;
			} else {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			}
		}

		while (ttemp != null) {
			rv.addLast(ttemp.data);
			ttemp = ttemp.next;
		}

		while (otemp != null) {
			rv.addLast(otemp.data);
			otemp = otemp.next;
		}

		return rv;
	}
	
	public void MergeSort() {
		
		if(this.size <= 1) {
			return ;
		}
		
		Node mid = this.midNode(this.head, this.head);
		Node midnext  = mid.next ; 
		
		LinkedList fh = new LinkedList() ;
		fh.head = this.head;
		fh.tail = mid; 
		fh.tail.next = null ;
		fh.size = (this.size() + 1) /2 ;
		
		LinkedList sh = new LinkedList() ;
		sh.head = midnext ; 
		sh.tail = this.tail;
		sh.tail.next = null ;
		sh.size = (this.size() ) /2 ;
		
		LinkedList p = mergeTwoSortedLinkedLists(fh);
		LinkedList k = mergeTwoSortedLinkedLists(sh);

		

	}
	
	public void RemoveDubpicate() {
		
		Node outer = this.head ;
		Node inner =this.head ;
		while (outer != null) {
			inner = outer.next;
			while(inner!=null&&inner.data==outer.data) {
				inner=inner.next;
				this.size--;
			}
			this.tail=outer;
			outer.next =inner ;
			outer=inner;
		}
		
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
