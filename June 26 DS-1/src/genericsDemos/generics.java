package genericsDemos;

import javax.swing.event.CaretListener;

public class generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Car[] cars = new Car[5];
		
//		cars[0] = new Car(5000, 5000, "D");
//		cars[1] = new Car(1000, 10000, "Merc");
//		cars[2] = new Car(4000, 15000, "B");
//		cars[3] = new Car(3000, 7000, "C");
//		cars[4] = new Car(2000, 9000, "Bentely");
//
//		display(cars);
//		bubbleSort(cars);
//		display(cars);
	
		GenericLinkedList<Car> carList = new GenericLinkedList<>();
		carList.addLast(new Car(1000, 10000, "Merc"));
		carList.addLast(new Car(5000, 5000, "D"));
		carList.addLast(new Car(4000, 15000, "B"));
		carList.addLast(new Car(3000, 7000, "C"));
		carList.addLast(new Car(2000, 9000, "Bentely"));
		
		carList.display();
		
	
	}

	public static <T> void display(T[] tarr) {

		for (T val : tarr) {
			System.out.println(val + "\t");
		}
		System.out.println(".");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int counter = 0;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length-1; i++) {

				if (arr[i].compareTo(arr[i + 1]) >= 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}

	private static class Car implements Comparable<Car> {

		private int speed;
		private int price;
		private String name;

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

	}
}
