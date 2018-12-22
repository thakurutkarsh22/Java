package July8;

import java.util.Scanner;

import java.util.LinkedList;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] pre, int[] in) {
		this.root = this.construct2(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi) {
			return null;
		}
		// create and attach the node
		Node node = new Node();
		node.data = pre[plo];
		this.size++;

		// search
		int searchIndex = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				searchIndex = i;
				break;
			}
		}
		int nelOnls = searchIndex - ilo;

		// for left
		node.left = this.construct(pre, plo + 1, plo + nelOnls, in, ilo, searchIndex - 1);

		// for right
		node.right = this.construct(pre, plo + nelOnls + 1, phi, in, searchIndex + 1, ihi);

		return node;

	}

	private Node construct2(int[] pos, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node node = new Node();

		node.data = pos[phi];
		this.size++;

		// search
		int searchIndex = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pos[phi]) {
				searchIndex = i;
				break;
			}
		}

		int nelOnls = searchIndex - ilo;

		// for left

		node.left = this.construct2(pos, plo, plo + nelOnls - 1, in, ilo, searchIndex - 1);

		// for right

		node.right = this.construct2(pos, plo + nelOnls, phi - 1, in, searchIndex + 1, ihi);

		return node;
	}

	// making a balanced tree
	public BST(int[] sa) {

		this.root = this.constrct(sa, 0, sa.length - 1);
	}

	private Node constrct(int[] sa, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		// making new node and adding data
		int mid = (lo + hi) / 2;
		this.size++;
		Node node = new Node();
		node.data = sa[mid];

		// right call
		node.left = this.constrct(sa, lo, mid - 1);

		// for right
		node.right = this.constrct(sa, mid + 1, hi);

		return node;
	}

	// Binary tree

	public void display() {

		display(this.root);
	}

	private void display(Node node) {

		String str = "";

		if (node == null) {
			return;
		}

		if (node.left != null) {
			str += node.left.data;
			// System.out.println(node.left.data + "===>");
		} else {

			str += ".";
			// System.out.println(str + "===>");
		}

		// System.out.println( " " + node.data + " ");
		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
			// System.out.println(node.right.data);
		} else {

			str += ".";
		}

		System.out.println(str);
		this.display(node.left);
		this.display(node.right);

	}

	public int size() {
		return this.size;
	}

	public boolean Isempty() {
		return this.size() == 0;

	}

	// Size 2

	public int size2() {

		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {

			return 0;
		}

		int ls = this.size2(node.left);
		int rs = this.size2(node.right);

		return ls + rs + 1;
	}

	// MAX

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	// HEIGHT

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	// MINIMUM

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {

		if (node == null) {

			return Integer.MAX_VALUE;
		}

		// if (root.left == null || root.right == null) {
		//
		// return root.data;
		// }

		int l = min(node.left);
		int r = min(node.right);

		return Math.min(Math.min(l, r), root.data);

	}

	// FIND

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {

		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else if (data > node.data) {
			return find(node.right, data);
		} else {
			return find(node.left, data);
		}

	}

	// DIAMETER

	public int diameter() {

		return diameter(this.root);

	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int l = this.height(node.left);
		int r = this.height(node.right);
		int sum = 2 + l + r;

		int a = this.diameter(node.left);
		int b = this.diameter(node.right);
		int max2 = Math.max(a, b);
		return Math.max(sum, max2);
	}

	// DIAMETER 2

	public int diameter2() {
		return this.diameter2(this.root).diameter;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair rv = new DiaPair();

			rv.height = -1;
			rv.diameter = 0;
			return rv;
		}

		DiaPair l = this.diameter2(node.left);
		DiaPair r = this.diameter2(node.right);

		DiaPair dp = new DiaPair();

		dp.height = Math.max(l.height, r.height) + 1;
		dp.diameter = Math.max(l.height + r.height + 2, Math.max(l.diameter, r.diameter));

		return dp;

	}

	private class DiaPair {
		int diameter;
		int height;

	}

	public boolean Isbalanced() {
		return Isbalanced(this.root).Isbal;
	}

	private balPair Isbalanced(Node node) {
		if (node == null) {

			balPair rv = new balPair();
			rv.height = -1;
			rv.Isbal = true;
			return rv;
		}

		balPair lp = this.Isbalanced(node.left);
		balPair rp = this.Isbalanced(node.right);

		balPair bt = new balPair();
		bt.height = Math.max(lp.height, rp.height) + 1;
		if (lp.Isbal && rp.Isbal && Math.abs(lp.height - rp.height) <= 1) {

			bt.Isbal = true;
		} else {

			bt.Isbal = false;
		}

		return bt;

	}

	private class balPair {

		int height;
		boolean Isbal;

	}

	// is binary search tree
	public boolean IsBst() {
		BstPair bspt = IsBst(this.root);

		System.out.println(bspt.largestBSTRoot.data);
		System.out.println(bspt.size);

		return bspt.IsBST;
	}

	private BstPair IsBst(Node node) {
		if (node == null) {
			BstPair rv = new BstPair();
			rv.IsBST = true;
			rv.max = Integer.MIN_VALUE;
			rv.min = Integer.MAX_VALUE;
			rv.largestBSTRoot = null;
			rv.size = 0;
			return rv;
		}

		BstPair l = IsBst(node.left);
		BstPair r = IsBst(node.right);

		BstPair bs = new BstPair();
		bs.min = Math.min(l.min, Math.min(r.min, node.data));
		bs.max = Math.max(l.max, Math.max(r.max, node.data));
		bs.size = l.size + r.size + 1;
		bs.largestBSTRoot = node;
		if (node.data < bs.min && node.data > bs.max && l.IsBST && r.IsBST) {

			bs.IsBST = true;
		} else {
			bs.IsBST = false;
		}

		return bs;

	}

	private class BstPair {

		int max;
		int min;
		boolean IsBST;
		int size;
		Node largestBSTRoot;

	}

	// PostOrder

	public void postOrder() {

		postOrder(this.root);
	}

	private void postOrder(Node node) {

		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data + " ");

	}

	// Preorder

	public void preOrder() {
		PreOrder(this.root);
	}

	private void PreOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.println(node.data + " ");
		PreOrder(node.left);
		PreOrder(node.right);

	}

	// Inorder

	public void InOrder() {
		InOrder(this.root);
	}

	private void InOrder(Node node) {
		if (node == null) {
			return;
		}

		InOrder(node.left);
		System.out.println(node.data + " ");
		InOrder(node.right);

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		Node temp = new Node();
		temp = this.root;
		queue.addLast(temp);

	}

	public void preorderI() {
		LinkedList<orderPair> stack = new LinkedList<>();

		stack.addFirst(new orderPair(this.root));
		while (!stack.isEmpty()) {
			orderPair temp = stack.getFirst();

			if (temp.selfDone == false) {
				System.out.println(temp.node.data);
				temp.selfDone = true;
			} else if (temp.leftDone == false) {
				orderPair lp = new orderPair(temp.node.left);
				if (temp.node.left != null) {
					stack.addFirst(lp);
				}
				temp.leftDone = true;

			} else if (temp.rightDone == false) {
				orderPair np = new orderPair(temp.node.right);

				if (temp.node.right != null) {
					stack.addFirst(np);
				}
				temp.rightDone = true;

			} else {
				stack.removeFirst();
			}

		}
	}

	public void postorderI() {
		LinkedList<orderPair> stack = new LinkedList<>();

		stack.addFirst(new orderPair(this.root));
		while (!stack.isEmpty()) {
			orderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				orderPair lp = new orderPair(temp.node.left);
				if (temp.node.left != null) {
					stack.addFirst(lp);
				}
				temp.leftDone = true;

			} else if (temp.rightDone == false) {
				orderPair np = new orderPair(temp.node.right);

				if (temp.node.right != null) {
					stack.addFirst(np);
				}
				temp.rightDone = true;

			} else if (temp.selfDone == false) {
				System.out.println(temp.node.data);
				temp.selfDone = true;
			} else {
				stack.removeFirst();
			}

		}
	}

	public void inorderI() {
		LinkedList<orderPair> stack = new LinkedList<>();

		stack.addFirst(new orderPair(this.root));
		while (!stack.isEmpty()) {
			orderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				orderPair lp = new orderPair(temp.node.left);
				if (temp.node.left != null) {
					stack.addFirst(lp);
				}
				temp.leftDone = true;

			} else if (temp.selfDone == false) {
				System.out.println(temp.node.data);
				temp.selfDone = true;
			} else if (temp.rightDone == false) {
				orderPair np = new orderPair(temp.node.right);

				if (temp.node.right != null) {
					stack.addFirst(np);
				}
				temp.rightDone = true;

			} else {
				stack.removeFirst();
			}

		}
	}

	private class orderPair {
		Node node;
		boolean selfDone;
		boolean rightDone;
		boolean leftDone;

		orderPair(Node node) {
			this.node = node;
		}

	}

	public void printrange(int lo, int hi) {

		printrange(this.root, lo, hi);

	}

	private void printrange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printrange(node.right, lo, hi);
		} else if (node.data > hi) {
			printrange(node.left, lo, hi);
		} else {
			printrange(node.left, lo, hi);
			System.out.println(node.data + " \t");
			printrange(node.right, lo, hi);
		}
	}

	// replace with larger

	public void replaceWSumLarger() {
		HeapMover mover = new HeapMover();
		replaceWSumLarger(this.root, mover);
	}

	private void replaceWSumLarger(Node node, HeapMover mover) {

		if (node == null) {
			return;
		}

		replaceWSumLarger(node.right, mover); // right call

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		replaceWSumLarger(node.left, mover); // left call

	}

	private class HeapMover {
		int sum = 0;
		// int max = Integer.MIN_VALUE;
		// int min = Integer.MAX_VALUE;
		// int height = 0;
		// boolean found = false;
		//
		// Node curr = null;
		// Node prev = null;
		//
		// Node pred = null;
		// Node succ = null;
		//
		// Node justLarger = null;
	}

	public int replaceWSumLarger2() {

		return replaceWSumLarger2(this.root, 0);

	}

	private int replaceWSumLarger2(Node node, int sum) {

		if (node == null) {
			return sum;
		}
		sum = replaceWSumLarger2(node.right, sum);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		sum = replaceWSumLarger2(node.left, sum);

		return sum;

	}

	public void addNode(int data) {

		addNode(this.root, data);
	}

	private void addNode(Node node, int data) {

		if (this.size == 0) {
			Node node1 = new Node();
			node.data = data;
			this.root = node1;
			this.size++;
			return;
		}
		if (node.data == data) {
			return;
		}
		if (data > node.data) {
			if (node.right != null) {
				addNode(node.right, data);
			} else {
				Node kk = new Node();
				this.size++;
				kk.data = data;
				node.right = kk;
				return;
			}

		} else if (data < node.data) {
			if (node.left != null) {
				addNode(node.left, data);
			} else {
				Node kk = new Node();
				this.size++;
				kk.data = data;
				node.left = kk;
				return;
			}

		}

	}

	public void removeNode(int data) {
		removeNode(null, this.root, data, false);
	}

	private void removeNode (Node parent , Node child, int data ,boolean ilc) {
		
		if (child.data == data) {
			if(child.left == null && child.right == null) {
				if(ilc) {
					parent.left =null;
				}else {
					parent.right =null;
					
					
				}
			}
			
		
		
			else	if (child.left==null && child.right!=null) {
			if(ilc) {
				parent.left = child.right;
			}else {
				parent.right = child.right;
			}
		}
		
			else if (child.right==null && child.left!=null) {
			if(ilc) {
				parent.right = child.left;
			}else {
				parent.left = child.left;
			}
		}
		
			else if(child.right !=null && child.left != null) {
			
			int max = this.max(child.left) ;
			child.data =max; 
			this.removeNode(child, child.left, max, true);
			
			}
		this.size--;
		return ;
		}else 
		if(data > child.data) {
			removeNode(child, child.right, data, false);
			
		}else {
			removeNode(child, child.left, data, true);
		}
	}
}
