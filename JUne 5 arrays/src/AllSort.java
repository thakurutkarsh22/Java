import java.util.Scanner;

public class AllSort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = takeinput();
		display(arr);

		 bubblesort(arr);
		 display(arr);
		

		selectionsort(arr);
		display(arr);

		 insertionsort(arr);
		 display(arr);
		
	}

	public static int[] takeinput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Size of array");
		int n = scn.nextInt();
		int i;
		int[] rv = new int[n];
		for (i = 0; i < rv.length; i++) {
			System.out.println("Enter the valur of" + i + "th element");
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + "  ");
		}

	}

	public static int swap(int maxval, int arrayval) {
		int temp = arrayval;
		arrayval = maxval;
		maxval = temp;

		return maxval;

	}

	public static void bubblesort(int[] array) {
		int i;
		int counter = 1;
		while (counter <= array.length - 1) {
			for (i = 0; i < array.length - counter; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}

			}

			counter++;

		}
		System.out.println(" BS: ");
	}

	public static void selectionsort(int[] array) {
		int i;
		int counter = 1;
		while (counter <= array.length - 1) {
			for (i = counter; i < array.length; i++) {
				if (array[counter - 1] > array[i]) {
					int temp = array[counter - 1];

					array[counter - 1] = array[i];
					array[i] = temp;

				}
			}

			counter++;

		}
		System.out.println(" sS: ");

	}

	public static void insertionsort(int[] array) {
		int i;
		int counter = 1;
		while (counter <= array.length - 1) {
			for (i = counter; i > 0; i--) {
				if (array[i - 1] > array[i]) {
					int temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
				} else {
					break;
				}

			}

			counter++;

		}
		System.out.println(" IS: ");

	}

}
