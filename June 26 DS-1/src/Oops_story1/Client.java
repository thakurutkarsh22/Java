package Oops_story1;

public class Client {

	public static void main(String[] args) {
//		Person p1 = new Person();
				
//		System.out.println(p1.age + " " + p1.name);
//		
//		p1.age = 30;
//		p1.name = "Sumeet";
////		
//		System.out.println(p1.age + " " + p1.name);
//		
//		Person p2 = p1; // p2 points same as p1 .
//		
//		p2.age = 33;
//		p2.name = "Amit";
		
//		System.out.println(p2.age + " " + p2.name);
//		System.out.println(p1.age + " " + p1.name);
//		
		
		Person p3 = new Person();
		p3.age = 10;
		p3.name = "A";
//		
		Person p4 = new Person();
		p4.age = 20;
		p4.name = "B";
		
//		System.out.println(p3.age + " " + p3.name);
//		System.out.println(p4.age + " " + p4.name);
//		Test1(p3, p4);
//		System.out.println(p3.age + " " + p3.name);
//		Test2(p3, p4);
//		System.out.println(p3.age + " " + p3.name);  // -1 A
//		System.out.println(p4.age + " " + p4.name); // 20 B 
		
		int myAge = 30;
		String myName = "C";
////		
		Test3(p3, p4.age, p4.name, myAge, myName);
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
		System.out.println(myAge + " " + myName);
////		
//		
		p3.introduceYourself();
		p4.sayHello(p3.name);
		
		
//		Person p5 = new Person("D", 40);
//		p5.introduceYourself();
//		
		Person p6 = new Person();
	
	
	}
	
	public static void Test3(Person p, int age, String name, int myAge, String myName){
		p.age = 0;
		p.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}
	
	public static void Test2(Person p1, Person p2){
		p2 = new Person();
		
		int tempa = p1.age;
		p1.age = p2.age;
		p2.age = tempa;
		
		p1 = new Person();
		
		String tempn = p1.name;
		p1.name = p2.name;
		p2.name = tempn;
	}
	
	public static void Test1(Person p1, Person p2){
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}
	
	


}