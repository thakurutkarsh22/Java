package july11;

import java.util.ArrayList;
import java.util.Comparator;





//import genericsDemos.generics.Car;

public class GenericClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Car[] cars = new Car[5];
		cars[0] = new Car(50, 30000, "A") ;
		cars[2] = new Car(100, 60000, "B") ;
		cars[4] = new Car(150, 90000, "C") ;
		cars[1] = new Car(125, 92000, "D") ;
		cars[3] = new Car(250, 100000, "E") ;
		display(cars);
		//bubbleSort(cars, new Car.CarSpeedComparator() );
		bubbleSort(cars, new Car.CarNameComparator());
		display(cars);
//		bubbleSort(cars, new Car.CarSpeedComparator());
//		display(cars);
//		bubbleSort(cars, new Car.CarPriceComparator());
//		display(cars);
//		
		GenericLinkedList<Integer> kk  = new GenericLinkedList<>() ;
		kk.addFirst(20);
		kk.addFirst(20);
		kk.addAt(25, 0);
		kk.display();
//		
//		GenericLinkedList<ArrayList<String>> pk = new GenericLinkedList<>() ;
//		pk.addLast(new ArrayList<String>());
//		pk.addLast(new ArrayList<String>());
//		pk.addLast(new ArrayList<String>());
//		
//		pk.display();
		
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int counter = 0;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length-1; i++) {

				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}
	
	public static <T> void bubbleSort(T[] arr , Comparator<T> comparator) {

		int counter = 0;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length-1; i++) {

				if (comparator.compare(arr[i+1], arr[i]) >=0  ) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}
	
	private static <T> void display(T[] darr) {
		
		for(T val:darr) {
			
			System.out.println(val);
		}
		System.out.println(".");
	}
	
	
	private static class Car implements Comparable<Car> {
		
		 int speed;
		 int price;
		 String name;

		Car(int speed, int price, String name) {

			this.price = price;
			this.name = name;
			this.speed = speed;

		}
		

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return this.speed - o.speed;
		}

		@Override
		public String toString() {
			return "[S=" + this.speed + ",P =" + this.price + " ,N =" + this.name + "]";
		}
		
		public static class CarSpeedComparator implements Comparator<Car>{

			@Override
			public int compare(Car o, Car t) {
				// TODO Auto-generated method stub
				return o.speed - t.speed;
			}
			
		}

		public static class CarPriceComparator implements Comparator<Car>{

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o2.price - o1.price;
			}
			
		}

		public static class CarNameComparator implements Comparator<Car>{

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
			
		}
		
	}


}
