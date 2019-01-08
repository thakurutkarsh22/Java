package Oops_story2;

public class Client {

	public static void main(String[] args) {
		C obj = new C();
		
		System.out.println(obj.d);
		System.out.println(obj.d1);
		
		obj.Fun();
		obj.Fun1();
		///////////////////////////////////////
		
		// Case 1
		System.out.println("-----------------Case 1----------------------");
		P o1 = new P();
		
		System.out.println(o1.d);
		System.out.println(o1.d1);
//		System.out.println(o1.d2); // non - sensical, compiler says no
		
		o1.Fun();
		o1.Fun1();
//		o1.Fun2(); // non - sensical, compiler says no
		
		// Case 2
		System.out.println("----------------Case 2----------------------");
		P o2 = new C();
		
		System.out.println(o2.d);
		System.out.println(o2.d1);
//		System.out.println(o2.d2);  Compiler says no but the conceept makes sense
		System.out.println(((C)o2).d2); // Compiler has been forced to accept
		
		o2.Fun();
		o2.Fun1();
//		o2.Fun2(); Compiler says no but the conceept makes sense
		((C)o2).Fun2(); // Compiler has been forced to accept
		
		// Case 3
//		C o3 = new P(); // If comipler allowed, JVM would have received runtime errors
		
//		System.out.println(o3.d2);
		
		// Case 4
		System.out.println("----------------Case 4----------------------");
		C o4 = new C();
		
		System.out.println(o4.d);
		System.out.println(((P)o4).d);
		System.out.println(o4.d1);
		System.out.println(o4.d2);
		
		o4.Fun();
		((P)o4).Fun();
		o4.Fun1();
		o4.Fun2();
	}

}