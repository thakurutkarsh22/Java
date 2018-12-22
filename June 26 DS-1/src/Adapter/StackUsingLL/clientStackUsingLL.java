package Adapter.StackUsingLL;

public class clientStackUsingLL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		StackUsingLL s = new StackUsingLL();
		
		System.out.println(s.size());
		System.out.println(s.isEmpty());
		s.push(10);
		s.push(20);
		System.out.println(s.top());
		System.out.println(s.size());
		System.out.println(s.isEmpty());
		s.push(30);
		System.out.println(s.top());
		System.out.println();
		
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		
		
		s.display();
		
		System.out.println(s.top());
	//	5001438970
		
		
	}

}
