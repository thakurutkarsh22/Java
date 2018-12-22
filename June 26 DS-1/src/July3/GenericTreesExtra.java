package July3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTreesExtra {

	private class Node {

		int data;
		ArrayList<Node> Children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTreesExtra() {
		this.root = this.takeInput(new Scanner(System.in), null, -1);

	}

	// create the i th child for parent and return that
	private Node takeInput(Scanner scn, Node parent, int i) {

		// prompt
		if (parent == null) {
			System.out.println("rootdata?");
		} else {
			System.out.println("Enter the " + i + "th child of" + parent.data);

		}
		// collect data and create node

		int cdata = scn.nextInt();
		Node child = new Node();
		child.data = cdata;
		

		// descendants - ask the count

		System.out.println("Number of child of " + cdata);
		int countchild = scn.nextInt();

		// descendants - make call

		for (int j = 0; j < countchild; j++) {

			Node des = this.takeInput(scn, child, j);
			child.Children.add(des);
		}

		return child;
	}

	// display
	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		String str = node.data + "----->";

		// work
		for (Node child : node.Children) {
			str += child.data + " ";
		}

		System.out.println(str);
		// delegate
		for (Node child : node.Children) {
			this.display(child);
		}
		this.size++;

	}

	// is empty
	public boolean isEmpty() {
		return this.size == 0;
	}
	// size

	public int size() {
		return this.size;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {

		int size = 0;
		for (Node child : node.Children) {
			int csize = this.size2(child);
			size += csize;

		}
		return 1 + size;
	}

	public boolean find(int data) {

		return find(this.root, data);

	}

	private boolean find(Node node, int data) {
		if (data == node.data) {

			return true;
		}
		boolean rv = false;
		for (Node child : node.Children) {
			boolean k = find(child, data);
			if (k) {
				rv = true;
			}
		}
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {

		int cmax = node.data;
		for (Node child : node.Children) {
			int max = this.max(child);

			cmax = Math.max(max, cmax);
		}
		return cmax;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int height = -1;
		int cheight = 0;
		for (Node child : node.Children) {
			cheight = height(child);

			height = Math.max(cheight, height);
		}
		return 1 + height;
	}

	public void linearize() {

		this.linearize(this.root);

	}

	private void linearize(Node node) {

		Node previous = null;
		for (Node child : node.Children) {
//			previous = child;
			this.linearize(child);
		}

		int count = 0;
		while (node.Children.size() > 1) {

			Node remove1 = node.Children.remove(1);
			Node tail = GetTerminalNode(node.Children.get(0));
			tail.Children.add(remove1);

		}
	}

//	public void  GetTerminalNode() {
//		GetTerminalNode(this.root);
//		
//	}
	
	private Node GetTerminalNode(Node node) {

		if (node.Children.size() == 0) {
			return node;
		} else {
			return GetTerminalNode(node.Children.get(0));
		}

		// for (int i=0 ; i < node.Children.size() ; i++) {
		//
		// return node;
		// }
	}

	private void mirror(Node node) {

		for (Node child : node.Children) {
			this.mirror(child);
		}
		int ri = node.Children.size() - 1;
		int li = 0;
		while (li < ri) {
			Node left = node.Children.get(li);
			Node right = node.Children.get(ri);
			node.Children.set(li, right);
			node.Children.set(ri, left);
			li++;
			ri--;

		}
	}

	public void mirror() {

		mirror(this.root);
	}

	public void linearizeEff() {

		this.linearizeEff(this.root);

	}

	private Node linearizeEff(Node node) {

		if (node.Children.size() == 0) {
			return node;
		}
		Node tof0 = linearizeEff(node.Children.get(0));
		
		while (node.Children.size() > 1) {

			Node tof1 = linearizeEff(node.Children.get(1));
			Node Rans = (node.Children.remove(1)); // not On
			tof0.Children.add(Rans);
			tof0 = tof1;

		}
		return tof0;
	}

	public void postOrder() {

		postOrder(this.root);
	}

	private void postOrder(Node node) {

		for (Node child : node.Children) {
			postOrder(child);
		}
		System.out.println(node.data);
	}

	public void preOrder() {

		preOrder(this.root);
	}

	private void preOrder(Node node) {

		System.out.println(node.data);

		for (Node child : node.Children) {

			preOrder(child);
		}

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			// dequeue
			Node node = queue.removeFirst();

			// print the value

			System.out.print(node.data + "  ");

			//
			for (Node child : node.Children) {

				queue.addLast(child);

			}

		}

	}

	public void levelOrderOnNextLine() {

		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		queue1.addLast(this.root);

		while (!queue1.isEmpty()) {

			Node node = queue1.removeFirst();

			// print
			System.out.print(node.data + "  ");

			for (Node child : node.Children) {
				queue2.addLast(child);
			}

			if (queue1.size() == 0) {
				queue1 = queue2;
				queue2 = new LinkedList<>();
				System.out.println();
			}

		}

	}

	// problem ask question how .... ? 
	public void Zigzac() { 

		LinkedList<Node> queue1 = new LinkedList<>(); // cl
		LinkedList<Node> stack = new LinkedList<>();// nl
		queue1.addLast(this.root);
		int count = 0;

		while (!queue1.isEmpty()) {

			Node node = queue1.removeFirst();

			// print
			System.out.print(node.data + "  ");
			if (count % 2 == 0) {
				for (int i = 0; i < node.Children.size(); i++) {
					stack.addFirst(node.Children.get(i));
				}
			} else {
				for (int i = node.Children.size() - 1; i >= 0; i--) {
					stack.addFirst(node.Children.get(i));
				}
			}

			if (queue1.size() == 0) {
				count++;
				queue1 = stack;
				stack = new LinkedList<>();
				System.out.println();
			}

		}
		// pree order iterative kro
	}

	// doubt 
	public void PreOrderPair() { // pre order by linear non recursion

		LinkedList<PreOPair> stack = new LinkedList<>();

		PreOPair pair = new PreOPair();

		pair.node = this.root;
		pair.childrenDone = 0;
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			PreOPair temp = stack.getFirst();

			if (temp.self == false) {
				System.out.println(temp.node.data + " via" + temp.ptillme);
				temp.self = true;
			} else if (temp.childrenDone < temp.node.Children.size()) {
				PreOPair cpair = new PreOPair();
				cpair.node = temp.node.Children.get(temp.childrenDone);
				cpair.ptillme = temp.ptillme + " ==> " + temp.node.data;
				stack.addFirst(cpair);
				temp.childrenDone++;

			} else {

				stack.removeFirst();
			}
		}

	}

	private class PreOPair {
		Node node;
		boolean self;
		int childrenDone = 0;
		String ptillme = "";

	}

	public void PostOrderPair() { // pre order by linear non recursion

		LinkedList<PostOPair> stack = new LinkedList<>();

		PostOPair pair = new PostOPair();

		pair.node = this.root;
		pair.childrenDone = 0;
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			PostOPair temp = stack.getFirst();

			if (temp.childrenDone < temp.node.Children.size()) {
				PostOPair cpair = new PostOPair();
				cpair.node = temp.node.Children.get(temp.childrenDone);

				stack.addFirst(cpair);
				temp.childrenDone++;

			} else if (temp.self == false) {
				System.out.println(temp.node.data);
				temp.self = true;
			} else {

				stack.removeFirst();
			}
		}

	}

	private class PostOPair {
		Node node;
		boolean self;
		int childrenDone = 0;

	}

//	public void multiSolver(int data , int justlarge) {
//		// rb = bucket
//		HeapMover rb = new HeapMover();
//		multiSolver(this.root , rb , 0 , data , justlarge );
//		System.out.println();
//		System.out.println();
//
//		System.out.println("Size ==>" + rb.size);
//		System.out.println("min ==>" + rb.min);
//		System.out.println("max ==>" + rb.max);
//		System.out.println("height ==>" + rb.height);
//		System.out.println("found ==>" + rb.found);
//		System.out.println("just large ===>" + rb.justlarge);
//		System.out.println("pred===> " + rb.pred);
//		System.out.println("Succ==>"+ rb.successor);
//	}
//
//	private void multiSolver(Node node, HeapMover rb, int depth, int data  , int num) {
//
//		// work
//
//		rb.size++ ;
//		
//		if (rb.min > data) {
//			rb.min = node.data;
//		}
//		if(rb.max < node.data) {
//			rb.max =node.data;
//		}
//		
//		
//		if(rb.height < depth) {
//			rb.height =depth;
//		}
//		
//		if (node.data == data) {
//			rb.found=true;
//		}
////		if(node.data > rb.justlarge && node.data < justlarge) {
////			rb.justlarge = node.data;
////			
////		}
//		////////////////null   no null case handling 
//		if(node.data > num && rb.justlarge < num ) {
//			rb.justlarge = node.data;
//			
//		}
//		
//		// predecisor // successor 
//		
//		rb.prev = rb.curr;
//		
//		if(rb.found==true && rb.successor==null) {
//			rb.successor=node;
//		}
//		if (node.data==data) {
//			rb.pred =rb.prev;
//			rb.found =true;
//			
//		}
//		
//		rb.curr =node;
//		
//		
//		
//		
//		for (Node child : node.Children) {
//			multiSolver(child, rb, depth + 1, data , num);
//		}
//
//	}
//
//	private class HeapMover {
//		int size = 0;
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		int height = 0;
//		boolean found = false;
//		Node pred ;
//		Node curr ;
//		Node prev ;
//		Node successor ; 
//		int justlarge =0  ;
//		
//		
//	}
	
					//multisolver sirs method
	
	public void multiSolver(int data) {
		HeapMover rb = new HeapMover();
		this.multiSolver(this.root, rb, 0, data);

		System.out.println("Size = " + rb.size);
		System.out.println("Max = " + rb.max);
		System.out.println("Min = " + rb.min);
		System.out.println("Height = " + rb.height);
		System.out.println("Found = " + rb.found);
		System.out.println("Pred = " + (rb.pred == null ? "null" : rb.pred.data));
		System.out.println("Succ = " + (rb.succ == null ? "null" : rb.succ.data));
		System.out.println("JL = " + (rb.justLarger == null ? "null" : rb.justLarger.data));
	}

	private void multiSolver(Node node, HeapMover rb, int depth, int data) {
		// work
		rb.size++;
		if (node.data > rb.max) {
			rb.max = node.data;
		}

		if (node.data < rb.min) {
			rb.min = node.data;
		}

		if (depth > rb.height) {
			rb.height = depth;
		}

		rb.prev = rb.curr;

		if (rb.found == true && rb.succ == null) {
			rb.succ = node;
		}

		if (node.data == data) {
			rb.pred = rb.prev;
			rb.found = true;
		}

		rb.curr = node;

		if (node.data > data) {
			if (rb.justLarger == null) {
				rb.justLarger = node;
			} else {
				if (node.data < rb.justLarger.data) {
					rb.justLarger = node;
				}
			}
		}

		// work

		for (Node child : node.Children) {
			this.multiSolver(child, rb, depth + 1, data);
		}
	}

	private class HeapMover {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int height = 0;
		boolean found = false;

		Node curr = null;
		Node prev = null;

		Node pred = null;
		Node succ = null;

		Node justLarger = null;
	}

	
	
	
	
//heapmover
	// predecisor // successor  // just larger 
	
	public int KthSmallest(int k) {
//		int ks = Integer.MIN_VALUE;
//		
//		for (int i = 0 ; i< k ; i++) {
//			HeapMover rb = new HeapMover();
//			this.multiSolver();(this.root, rb, 0, ks, 0);
//			ks=rb.justlarge;
//			
//		}
//	
////		return ks;
		ArrayList<Integer> list = new ArrayList<>();
		this.KthSmallest(this.root, list);

		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		

		Arrays.sort(arr);
		return arr[k];
	}
	private void KthSmallest(Node node, ArrayList<Integer> list) {
		list.add(node.data);
		for (Node child : node.Children) {
			this.KthSmallest(child, list);
		}
	}

	public void removeLeaves() {
		this.removeLeaves(this.root);
	}

	private void removeLeaves(Node node) {
//		System.out.print(node.data + "\t");

		// hi node

		for (int i = 0; i < node.Children.size(); i++) {
			// before moving to the child
			Node child = node.Children.get(i);
			if (child.Children.size() == 0) {
				node.Children.remove(i);
				i--;
			} else {
				this.removeLeaves(child);
			}
			// back from the child
			
		}

		// bye node
	}
	
	// problem doubt 
	public boolean IsMirrorImage() {
		return IsMirrorImage(this.root, this.root);
	}
	
	private boolean IsMirrorImage(Node lnode , Node rnode) {
		
		if(lnode.Children.size() != rnode.Children.size()) {
			return false;
		}
		
		for (int i = 0; i <=lnode.Children.size()/2; i++) {
			
			Node lchild = lnode.Children.get(i);
			Node rchild = rnode.Children.get(rnode.Children.size() -1-i);
			if(this.IsMirrorImage(lchild, rchild)==false) {
				return false ;
			}
		}
		return true ;
	}
	
	public boolean IsIsoMorphic(Node o) {
		return IsIsoMorphic(this.root, o);
	}
	
	private boolean IsIsoMorphic(Node tnode , Node onode) {
		
		if(tnode.Children.size() != onode.Children.size() ) {
			return false ;
		}
		

		for (int i = 0; i <tnode.Children.size(); i++) {
			
			Node lchild = tnode.Children.get(i);
			Node rchild = onode.Children.get(onode.Children.size() -1-i);
			if(this.IsMirrorImage(lchild, rchild)==false) {
				return false ;
			}
		}
		return true ;
	
	}	
	
	public void removeleaf() {
		removeleaf(this.root);
	}
	private void removeleaf(Node node) {
		for(int i = 0 ; i <node.Children.size() ; i++) {
			Node child = node.Children.get(i);
			if(child.Children.size() == 0 )
			{
				node.Children.remove(i);
				i--;
			}else {
				
				
			}
			
		}
	}
}
// tamashia // corman