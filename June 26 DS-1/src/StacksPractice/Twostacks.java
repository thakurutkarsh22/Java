package StacksPractice;

import java.util.ArrayList;
import java.util.Stack;

import javax.print.attribute.IntegerSyntax;

import Stacks.stack;

public class Twostacks {

	protected int size;
	protected int[] arr;
	protected int tos1;
	protected int tos2;

	public Twostacks(int n) {
		// TODO Auto-generated constructor stub
		this.size = n;
		this.tos1 = -1;
		this.tos2 = size;
		this.arr = new int[n];
	}

	public void push1(int data) throws Exception {

		if (tos1 < tos2) {
			tos1++;
			arr[tos1] = data;

		} else {
			throw new Exception("Error occured");
		}

	}

	public void push2(int data) throws Exception {

		if (tos1 < tos2) {
			tos2--;
			arr[tos2] = data;

		} else {
			throw new Exception("Error Occoured");
		}

	}

	public int pop1() {
		int rv = 0;
		if (tos1 >= 0) {
			rv = arr[tos1];
			tos1--;

		} else {
			System.out.println("Sack underflow");
			System.exit(1);
		}

		return rv;

	}

	public int pop2() {
		int rv = 0;

		if (tos2 <= size) {
			rv = arr[tos2];
			tos2++;

		} else {
			System.out.println("Sack underflow");
			System.exit(1);
		}

		return rv;

	}

	// 6. check for balanced parenthesis

	public boolean balanceParanthesis(String str) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}

			if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty()) {
					return false;
				} else if (!isMatchingpair(stack.pop(), ch)) {
					return false;
				}

			}

		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	static boolean isMatchingpair(char ch1, char ch2) {

		if (ch1 == '(' && ch2 == ')') {
			return true;
		} else if (ch1 == '{' && ch2 == '}') {
			return true;
		} else if (ch1 == '[' && ch2 == ']') {
			return true;
		}
		return false;
	}

	// 7 Next greater element

	// 8 reverse stack using recursion

	public void reverseStackUsingRec(char ch) {
		Stack stack = new Stack<>();

		if (stack.isEmpty() == true) {
			stack.push(ch);
		}

	}

	//16 length of valid xsubstring // problem 

	public int length(String str) {

		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(ch);
			}else {
				
				if (stack.peek()=='(') {
					stack.pop();
					count++;
				}else if (stack.peek()==')' || stack.size()==0) {
					
					stack.push(ch);
				}
			}
		}
		return count;

	}
	// toh recursion 
	public static int toh(String src, String dest, String helper, int n){
		if(n == 0){
			return 0;
		}
		
		int c1 = toh(src, helper, dest, n - 1);
		System.out.println("Move " + n + "th disc from " + src + " to " + dest);
		int c2 = toh(helper, dest, src, n - 1);
		
		return c1 + c2 + 1;
	}
	public static int tohI(String src , String dest , String helper , int n) {
		
	}
	
	// q17 
	public static ArrayList<Integer> maxOfmin(int[] arr){
		
		
		
	}
}