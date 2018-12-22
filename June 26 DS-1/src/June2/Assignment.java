package June2;
import Adapter.StackUsingLL;
import Stacks.stack;
public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "((a + b) + ((c+d)))";
		
		
	}
	
	public boolean checkduplicateparaanthesis(String str) {
		
		StackUsingLL stack = new StackUsingLL();
		
		
		for (int i = 0 ; i < str.length() ;i++) {
		
			if (str.charAt(i) == '(') {
				
				stack.push(i);
			}
			if (str.charAt(i) >= 'a' && str.charAt(i)<= 'z' || str.charAt(i)=='+') {
				
				stack.push(i);
			}
			
			if (str.charAt(i) == ')') {
				
				
					
					
				}
				
			}
			
			
		}
		
		
		return false;
	}
	

}
