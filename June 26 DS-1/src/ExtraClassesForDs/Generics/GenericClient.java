package ExtraClassesForDs.Generics;

import java.util.Comparator;

public class GenericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		car[] cars = new car[5];
		
		cars[0] = new car("Audi", 100, 1000);
		cars[1] = new car("BMW", 200, 1500);
		cars[2] = new car("porsche", 150, 800);
		cars[3] = new car("Merc", 140, 900);
		cars[4] = new car("Lembor", 160, 1400);

//		bubblesort(cars);
//		display(cars);
		
		bubblesort(cars, car.pricector);
//		bubblesort(cars);
		display(cars);
		
		
		}

	public static <T> void display(T[] arr) {
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

		for (T ar : arr) {
			System.out.println(ar);
		}
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		int counter = 0;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - 1; i++) {
				// comparator.compare(arr[i+1], arr[i]) >=0
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}
	
	public static <T> void bubblesort(T[] arr , Comparator<T> comparator) {
		int counter = 0;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (comparator.compare(arr[i], arr[i+1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}

}
