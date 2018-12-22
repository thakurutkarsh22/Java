
import java.util.Arrays;

public class TosDemos {

	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	public static void main(String[] args) {
		 int[] one = {10, 20, 30, 40, 50};
		 int[] two = {5, 7, 32, 42, 55, 60};
		 int[] merged = mergeTwoSortedArrays(one, two);
		
		 for(int val: merged){
		 System.out.println(val);
		 }

		// int[] arr = { 16, 4, 19, 18, 1, 22, 55, 0 };
		// arr = mergeSort(arr, 0, arr.length - 1);
		//
		// for (int val : arr) {
		// System.out.println(val);
		// }

		// int[] arr = {2, 3, 16, 7, 8, 14};
		// int[] arr = { 10, 20 };
		// quickSort(arr, 0, arr.length - 1);
		// for (int val : arr) {
		// System.out.println(val);
		// }

		int n = 1000000;
		long duration = 0;

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}

		startWatch();
		bubbleSort(arr);
		endWatch("MS", n);

	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}

			counter++;
		}
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];

		int i = 0, j = 0, k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				result[k] = one[i];
				i++;
				k++;
			} else {
				result[k] = two[j];
				j++;
				k++;
			}
		}

		if (i == one.length) {
			while (j < two.length) {
				result[k] = two[j];
				j++;
				k++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				result[k] = one[i];
				i++;
				k++;
			}
		}

		return result;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];

			br[0] = arr[lo];

			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeTwoSortedArrays(fh, sh);
		return sorted;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;

		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) { // {10, 20}
			while (arr[left] < pivot) { // {2, 3, 16, 7, 8, 14}
				left++;
			}

			while (arr[right] > pivot) { // {2, 3, -1, 7, 8, 14}
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		quickSort(arr, lo, right); // smaller
		quickSort(arr, left, hi); // larger

	}
}