package Oops_story1;

public class Person {
	 String name = "default";
	int age = -1;
	
	public void introduceYourself(){
		System.out.println(this.name  + " is (" + this.age + ") years old");
	}
	
	public void sayHello(String name){
		System.out.println(this.name + " says hi to " + name);
	}
	
	// default ctor
	public Person(){
	}
	
//	parametrized ctor
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}
