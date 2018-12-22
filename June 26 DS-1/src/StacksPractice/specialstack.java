package StacksPractice;

import java.util.Stack;

import Stacks.stack;

public class specialstack extends Stack<Integer>{

	Stack<Integer> min = new Stack<>();
	
	public void push(int item) {
		
		if(min.size()==0) {
			super.push(item);
			min.push(item);
		}else {
			
			super.push(item);
			
			int x= min.pop();
			min.push(x);
			if(x>item) {
				min.push(item);
			}else {
				min.push(x);
			}
			
		}
		
	}
	
	public Integer pop() {
		
		int x = super.pop();
		min.pop();
		
		return x;
		
		
	}
	
	public int GetMin() {
		
		 int x = min.pop();
	        min.push(x);
	        return x;
	}

	
	
}
