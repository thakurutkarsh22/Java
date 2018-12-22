package ExtraClassesForDs.BinarySearchTree;

import java.util.LinkedList;

import javax.xml.soap.Node;

public class BST {

	private class Node {
		Node left;
		Node right;
		int data;

	}

	int size;
	Node root;

	public BST(int[] pre, int[] in) {
		root = construct2(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	public Node construct(int[] pre, int[] in, int psi, int pei, int isi, int iei) {

		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		node.data = pre[psi];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int clse = idx - isi;
		node.left = construct(pre, in, psi + 1, psi + clse, isi, idx - 1);
		node.right = construct(pre, in, psi + clse + 1, pei, idx + 1, iei);
		return node;

	}

	public Node construct2(int[] pos, int[] in, int psi, int pei, int isi, int iei) {

		if (psi > pei || isi > iei) {
			return null;
		}
		Node node = new Node();
		node.data = pos[pei];
		this.size++;

		int idx = -1;

		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}
		int clse = idx - isi;
		node.left = construct2(pos, in, psi, psi + clse - 1, isi, idx - 1);
		node.right = construct2(pos, in, psi + clse, pei - 1, idx + 1, iei);

		return node;

	}

	public Node construct3(int[] pos, int[] pre, int psi, int pei, int presi, int preei) {

		if (psi > pei || presi > preei) {
			return null;
		}
		Node node = new Node();
		node.data = pre[psi];
		this.size++;

		int idx = -1;
		return node;

	}

	public BST(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node node = new Node();
		this.size++;
		node.data = arr[mid];

		node.left = construct(arr, lo, mid - 1);
		node.right = construct(arr, mid + 1, hi);

		return node;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += "=>" + node.data + "<=";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size2(node.right);
		int rs = size2(node.left);

		return ls + rs + 1;
	}

	public int size2() {
		return size2(this.root);
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int l = height(node.left);
		int r = height(node.right);

		return Math.max(l, r) + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(node.right);
		}
	}

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		} else {
			return min(node.left);
		}
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}

	}

	public void removeNode() {
		removenode(this.root);
	}

	private void removenode(Node node) {

		if (node.left == null && node.right == null) {

		}

	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int l = diameter(node.left);
		int r = diameter(node.right);
		int max = Math.max(l, r);

		int l1 = height(node.left);
		int l2 = height(node.right);
		int sum = l1 + l2 + 2;

		return Math.max(max, sum);

	}

	private class diaPair {
		int height;
		int diameter;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private diaPair diameter2(Node node) {
		if (node == null) {
			diaPair bp = new diaPair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}

		diaPair lp = diameter2(node.left);
		diaPair rp = diameter2(node.right);

		diaPair mp = new diaPair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));

		return mp;
	}

	private class balPair {
		boolean isBal;
		int height;
	}

	public boolean IsBalanced() {
		return IsBalanced(this.root).isBal;
	}

	private balPair IsBalanced(Node node) {
		if (node == null) {
			balPair bp = new balPair();
			bp.isBal = true;
			bp.height = -1;
			return bp;
		}

		balPair lp = IsBalanced(node.left);
		balPair rp = IsBalanced(node.right);

		balPair mp = new balPair();
		mp.height = Math.max(lp.height, rp.height) + 1;

		if (lp.isBal && rp.isBal) {
			int gap = Math.abs(lp.height - rp.height);
			if (gap <= 1) {
				mp.isBal = true;

			} else {
				mp.isBal = false;
			}
		} else {
			mp.isBal = false;
		}

		return mp;
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);

	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);

	}

	public void preOrderI() {

		LinkedList<TraversalPair> stack = new LinkedList<>();

		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.add(rp);

		while (!stack.isEmpty()) {

			TraversalPair get = stack.getFirst();

			if (get.self == false) {
				get.self = true;
				if (get.node != null) {
					System.out.println(get.node.data);
				}
			} else if (get.left == false) {

				// condition for null pointer
				if (get.node.left != null) {
					TraversalPair np = new TraversalPair();
					np.node = get.node.left;
					stack.addFirst(np);
				}
				get.left = true;

			} else if (get.right == false) {

				// condition for handling null pointer
				if (get.node.right != null) {
					TraversalPair np = new TraversalPair();
					np.node = get.node.right;
					stack.addFirst(np);
				}
				get.right = true;

			} else {
				stack.removeFirst();
			}

		}

	}

	private class TraversalPair {
		boolean self;
		boolean left;
		boolean right;
		Node node;
	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {

			Node r = queue.getFirst();
			if (r != null) {
				System.out.println(r.data);
			}
			queue.removeFirst();
			if (r != null) {

				queue.addLast(r.left);
				queue.addLast(r.right);
			}

		}

	}

	public void addLeaf(int data) {

		addLeaf(this.root, data);
	}

	private void addLeaf(Node node, int data) {

		if (data > node.data) {
			if (node.right != null) {
				addLeaf(node.right, data);
			} else {
				Node c = new Node();
				this.size++;
				c.data = data;
				node.right = c;
				return;
			}

		} else if (data < node.data) {
			if (node.left != null) {
				addLeaf(node.left, data);
			} else {
				Node c = new Node();
				this.size++;
				c.data = data;
				node.left = c;
				return;
			}

		} else {
			return;
		}
	}

	public void removeLeaf(int data) {

		removeLeaf(null, this.root, data, false);

	}

	private void removeLeaf(Node parent, Node node, int data, boolean ilc) {

		if (node == null)
		{
			return;
		}

			if (node.data == data) {

				if (node.left == null && node.right == null) {
					if (ilc) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				} else if (node.right == null && node.left != null) {
					if (ilc) {
						parent.left = node.left;
					} else {
						parent.right = node.left;
					}

				} else if (node.left == null && node.right != null) {
					if (ilc) {
						parent.left = node.right;
					} else {
						parent.right = node.right;
					}
				} else {

					int leftmax = max(node.left);
					node.data = leftmax;

					removeLeaf(node, node.left, leftmax, ilc);
					;

				}

				this.size--;
			} else {

				if (data > node.data) {
					removeLeaf(node, node.right, data, false);
				}
				if (data < node.data) {
					removeLeaf(node, node.left, data, true);
				}
			}
	}
	
	public void sumReplace() {
		replaceWSumLarger2(this.root ,0);
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
	
	private class HeapMover{
		int sum =0 ;
	}
	public void replaceWSL() {
		HeapMover mover = new HeapMover();
		replaceWSL(this.root, mover);
	}
	private void replaceWSL(Node node , HeapMover mover) {
		
		if(node==null) {
			return ;
		}
		
		replaceWSL(node.right, mover);
		
		int temp = node.data;
		node.data =mover.sum ;
		mover.sum +=temp;
		
		replaceWSL(node.left, mover);
		
		
	}
	public void printInRange(int lo , int hi ) {
		printInRange(this.root, lo, hi);
	}
	
	private void printInRange(Node node , int lo ,int hi) {
		if(node==null) {
			return;
		}
		
		
		if(node.data < lo) {
			printInRange(node.left, lo, hi);
		}else
		if(node.data > hi) {
			printInRange(node.right, lo, hi);
			
		}else if(node.data>=lo && node.data <=hi){
			System.out.println(node.data+"or");
			printInRange(node.left, lo, hi);
			printInRange(node.right, lo, hi);
		}
		
	}
	
	// Convert a given tree to its Sum Tree
	
	public void sumtree() {
		sumtree(this.root);
	}

	private int sumtree(Node node) {
		
		if(node==null) {
			return 0 ;
		}
		
		int old  = node.data ;
		
		node.data = sumtree(node.left) + sumtree(node.right); 
		
		return node.data +old ;
		
	}
	
	//LOWEST COMMON ANCESTOR 
	public int lowestcommon(int a, int b) {
		return lowestcomancestor(this.root, a, b).data;
		// 20 true 8 true 4 false false true 12 true 10 false false true 14 false false
		// true 22 false false
	}

	private Node lowestcomancestor(Node node, int a, int b) {

		if (node == null) {
			return null;
		}
		if (node.data > a && node.data > b) {
			return lowestcomancestor(node.left, a, b);
		}
		if (node.data < a && node.data < b) {
			return lowestcomancestor(node.right, a, b);
		}
		return node;

	}
}
