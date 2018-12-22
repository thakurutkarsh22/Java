package StacksPractice;

import Stacks.stack;

public class SpecialStackCLient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		specialstack stack = new specialstack();
		
//		stack.push(10);

		stack.push(10);

		stack.push(20);

		stack.push(30);

		stack.push(40);

		stack.push(5);
		
//		stack.display();
		
		
		
		System.out.println(stack.GetMin());
		stack.pop();
//		stack.pop();
//		stack.pop();
	System.out.println(stack.size());
		System.out.println(stack.peek()+ " peek");
	
		System.out.println(stack.GetMin());
	}

}
