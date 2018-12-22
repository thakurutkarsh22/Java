package StacksPractice;

import java.util.Arrays;
import java.util.Stack;

import Adapter.StackUsingLL.StackUsingLL;
import Stacks.stack;

public class client {

	static StackUsingLL st = new StackUsingLL();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		 Twostacks ts = new Twostacks(5);
//		 System.out.println(ts.length("()(()))))"));
		 ts.push1(5);
		 ts.push2(10);
		 ts.push2(15);
		 ts.push1(11);
		 ts.push2(7);
		 System.out.println("Popped element from" +
		 " stack1 is " + ts.pop1());
		// ts.push2(40);
		 System.out.println("Popped element from" +
		 " stack2 is " + ts.pop2());
		//
		// System.out.println(ts.balanceParanthesis("a+b*(c^d-e)^(f+g*h)-i"));
		//
		// StackUsingLL stack = new StackUsingLL();
		//// Stack<Integer> stack = new Stack<>();
		// stack.push(10);
		// stack.push(20);
		// stack.push(30);
		// stack.push(40);
		// stack.push(50);
		// stack.display();
		//// System.out.println(stack.top());
		// displayReverse(stack);
		// System.out.println("------------------");
		// stack.display();
		// System.out.println("------------------");
		//
		// StackUsingLL helper = new StackUsingLL();
		// Reverse(stack, helper);
		// stack.display();
		//// helper.display();

//		st.push(20);
//		st.push(40);
//		st.push(10);
//		st.push(30);
//		st.push(50);
//		st.display();
//		reverse();
//		st.display();
//		
//		sort();
//		st.display();
//		
////		int k =ts.length("()(()))))");
////		System.out.println(k);
//		
//		System.out.println(ts.toh("S", "D", "H", 4	));
//		int [] arr =  {11 ,13,21,3,4};
//		nextgreater();
//		System.out.println(parenthesis("{[]()}"));
//		System.out.println(countminreversals("{{{{}}"));
//		System.out.println(lengthofLongest("()(()))))"));
		 int[] arr = {10,20,30,50,10,70,30};
		 int[] k = minofmax(arr, arr.length);
		 for(int i = 1 ; i <= arr.length;i++) {
			 System.out.println(k[i]);
		 }
	}

	// display reverse

	public static void displayReverse(StackUsingLL st) throws Exception {

		if (st.isEmpty()) {
			return;
		}

		int item = st.pop();

		displayReverse(st);

		System.out.println(item);

		st.push(item);

	}

	// reverse the stack

	public static void Reverse(StackUsingLL stack, StackUsingLL helper) throws Exception {

		if (stack.isEmpty()) {

			if (helper.isEmpty()) {
				return;

			}
			int item = helper.pop();

			Reverse(stack, helper);
			stack.push(item);

			return;
		}

		int item = stack.pop();
		helper.push(item);
		Reverse(stack, helper);

	}

	static void insert_at_bottom(int x) throws Exception {

		if (st.isEmpty()) {
			st.push(x);
		} else {

			int p = st.pop();
			insert_at_bottom(x);
			st.push(p);

		}

	}

	static void reverse() throws Exception {

		if (st.isEmpty()) {

			return;
		}
		int k = st.pop();

		reverse();
		insert_at_bottom(k);

	}

	// 9.0 sort stack by recursion

	static void sort() throws Exception {
		if (st.isEmpty()) {

			return;
		}
		int k = st.pop();

		sort();
		sorting(k);
	}

	static void sorting(int x) throws Exception {

		if (st.isEmpty()) {
			st.push(x);
		} else {

			if (x > st.top()) {
				st.push(x);
			}else {
				
				int p = st.pop();
				sorting(x);
				st.push(p);				
			}

		}

	}
	
	// next greater element 7.0
	
	public static void nextgreater() {
		int [] arr =  {11 ,13,21,3,4};
		NGE(arr);
	}
	
	private static void NGE(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(arr[0]);
		int next , element ;
		for (int i =1; i < arr.length ; i++) {
			next = arr[i];
			
			if(!stack.isEmpty()) {
				element = stack.pop() ;
				
				while(element < next) {
					System.out.println(element + "  " + next);
					if (stack.isEmpty()) {
						break;
					}
					element = stack.pop();
					
				}
				if(element>next) {
					stack.add(element);
				}
				
			}
			
			stack.push(next);
		}
		
		while(!stack.isEmpty()) {
			next = stack.pop();
			element = -1 ;
			
			System.out.println(next +"  " + element);
		}
	}
	
	// check  for balanced parenthesis 6.0
	
	public static boolean parenthesis (String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i =0 ; i < str.length() ;i++) {
			char ch = str.charAt(i);
			
			if(ch=='['|| ch=='{' ||ch=='(') {
				stack.push(ch);
			}else if (ch==']' ||ch=='}'||ch==')') {
				if(stack.isEmpty()) {
					return false ;
				}
				
				else if (!ismatchingPair(stack.pop() , ch)) {
					return false;
				}
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}

	private static boolean ismatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else if (character1 == '{' && character2 == '}')
         return true;
       else if (character1 == '[' && character2 == ']')
         return true;
       else
         return false;
    }
	// min no of reverssals of parenthesis 19 
	
	public static int countminreversals(String str) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i =0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if ( ch=='}'  &&!stack.isEmpty()) {
				if(stack.peek()=='{') {
					stack.pop();
				}else {
					stack.push(ch);
				}
			}else {
				stack.push(ch);
			}
		}
		
		int len = stack.size();
		int count = 0 ;
		int count1 =0 ;
		
		while (!stack.isEmpty() && stack.peek() == '{') {
			stack.pop();
			count++;
		}
		while (!stack.isEmpty() && stack.peek() == '}') {
			stack.pop();
			count1++;
		}
		return (len/2 + count%2) ;
		
	}
	//16.0 longest substring 
	public static int lengthofLongest(String str) {
		
		Stack<Integer> stack = new Stack<>();
//		stack.push(-1);
		int count = 0;
		for (int i=0 ; i < str.length() ;i++) {
			char ch = str.charAt(i);
			if(ch=='(') {
				stack.push(i);
			}else {
				stack.pop();
				
				if(!stack.isEmpty()) {
					count = Math.max(count, i-stack.peek());
				}
				else {
					stack.push(i);
				}
			}
		}
		return count;
		
	}
	
	//17.0 Find maximum of minimum for every window size in a given array
	// refer notebook
	
	public static int[] minofmax(int[] arr , int n) throws Exception {
		Stack<Integer> stack = new Stack<>();
		
		int[] left = new int[n+1];
		int[] right = new int[n+1];
		
		for(int i =0 ; i <n ; i++) {
			left[i] = -1;
			right[i] = n;
		}
		// for left
		for(int i =0 ; i<n ;i++) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) {
				left[i] = stack.peek();
			}
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		// for t=rgiht
		for(int i =n-1 ; i>=0 ;i--) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) {
				right[i] = stack.peek();
			}
			stack.push(i);
			
		}
		
		int [] ans = new int[n+1];
		Arrays.fill(ans, 0);
		
		for(int i =0 ; i<n ;i++) {
			int len =right[i] - left[i] -1;
			ans[len] = Math.max(ans[len], arr[i] );
		}
		for(int i = n-1 ; i>=1 ;i--) {
			ans[i] = Math.max(ans[i], ans[i+1]);
		}
		return ans;
		
	}
}
