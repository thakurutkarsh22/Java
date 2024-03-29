package Stacks;

import java.util.Stack;

import javax.print.attribute.IntegerSyntax;

import Adapter.QueuesUsingLL.QueueUsingLL;
import LinkedList.LinkedList;
import Queue.Queue;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// stack st = new stack(5);
		stack st = new DynamicStack(5);
		//
		//
		// System.out.println(st.tos);//st.tos;
		// for (int i =0 ; i <= st.size() ; i++) {
		// System.out.println(st.data[i] + " .");
		// }
		st.push(10);
		st.push(20);
		st.push(30);
		// st.display();
		st.push(40);
		st.push(50);
		// st.push(60);

		// st.data[7] = 9 ;

		// st.display();
		// System.out.println();
		// System.out.println(st.top());
		// st.top();
		// st.pop();
		// System.out.println();
		// st.isEmpty();
		// System.out.println(st.isEmpty());

		// st.display();
		// System.out.println(st.top());st.top();

//		System.out.println();
//		displayReverse(st);
//		System.out.println();
		// st.display();

		// reverse(st, new stack(10));
		// st.display();

		// stock span prices
		 int[] k = { 10, 4, 5, 90, 120, 80 }; // 1,2,3,1,5,6,1,2,9,1
		 int[] p = stockspan(k);
		 for (int i = 0; i < p.length; i++) {
		 System.out.println(p[i]);
		 }
		// st.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");

		 System.out.println(st.infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
		 System.out.println(st.InfixToPostfix("231*+9-"));
		// System.out.println(st.reverseAString("noobs"));
		// boolean k = hasduplicatePrenthesis("((a+b)+(c+d))");
		// System.out.println(k);

		// queueus
		LinkedList queue = new LinkedList();
		queue.addLast(10);
		queue.addLast(20);
		queue.addLast(30);
		queue.addLast(40);
		queue.addLast(50);
		queue.addLast(60);
		queue.addLast(70);
		queue.addLast(80);
		queue.addLast(90);
		queue.addLast(100);
//		queue.display();
////		revKelements(5, queue);
//		queue.display();
		
		
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);
		System.out.println("a");
		Stack<Integer> tmpstack = sortastackUsingtmp(stack);
		
		while(!tmpstack.isEmpty()) {
			System.out.println(tmpstack.peek());
			tmpstack.pop();
		}
		
		

	}

	public static void displayReverse(stack st) throws Exception {
		if (st.isEmpty()) {
			return;
		}

		int item = st.pop();
		displayReverse(st);
		System.out.println(item + "     ");
		st.push(item);

	}

	public static void reverse(stack st, stack helper) throws Exception {
		if (st.isEmpty()) {
			if (helper.isEmpty()) {

				return;
			}
			int item = helper.pop();
			reverse(st, helper);
			st.push(item);
			return;

		}

		// System.out.println(item + " ");
		int item2 = st.pop();
		helper.push(item2);
		reverse(st, helper);
		// st.push(item2);

	}

	public static int[] stockspan(int[] prices) throws Exception {
		stack st = new stack(10);
		int[] rv = new int[prices.length];

		rv[0] = 1; // 10, 4, 5, 90, 120, 80
		st.push(0);

		for (int i = 1; i < prices.length; i++) {
			while ((!st.isEmpty()) && prices[i] >= prices[st.top()]) {

				st.pop();

			}
			if (st.isEmpty()) {
				rv[i] = i + 1;

			} else {
				rv[i] = i - st.top();

			}
			st.push(i);

		}

		return rv;
	}

	public static boolean hasduplicatePrenthesis(String k) throws Exception {

		DynamicStack stack = new DynamicStack(20);
		int count = 0;
		for (int i = 0; i < k.length(); i++) {

			if (k.charAt(i) != ')') {

				stack.push(k.charAt(i));
			} else {
				count = 0;
				while (stack.top() != '(') {

					stack.pop();
					count++;

				}
				if (count > 0) {
					stack.pop();
				} else {
					return false;
				}
			}

		}

		return true;

	}

	// reverrsing first k emepement of queue

	public static void revKelements(int k, LinkedList queue) throws Exception {
		Stack<Integer> stack = new Stack<>();
		// queue = new QueueUsingLL();

		for (int i = 0; i < k; i++) {
			stack.push(queue.removeFirst());

		}

		while (!stack.isEmpty()) {
			queue.addLast(stack.pop());
		}

		for (int i = 0; i < queue.size() - k; i++) {
			queue.addLast(queue.removeFirst());
		}

	}

	// sort a stack using temp stack

	public static Stack<Integer> sortastackUsingtmp(Stack<Integer> stack) {
		
		Stack<Integer> helper = new Stack<>();
		
		while(!stack.isEmpty()) {
				
			while(!helper.isEmpty() && helper.peek() > stack.peek()) {
				stack.push(helper.pop());
			}
			
			
			helper.push(stack.pop());
		}
		return helper;
		
	}
}
