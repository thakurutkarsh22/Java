package DynamicProgramingFraands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {

		int arr[] = { 6, 2, 6, 4, 5, 1 }; // 3
		int k = PrintLISWithVaues(arr);
		System.out.println(k);
		System.out.println();

	}

	public static int PrintLIS(int[] arr) {

		int[] nearr = new int[arr.length];
		Arrays.fill(nearr, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j]) {
					nearr[i] = Math.max(nearr[j] + 1, nearr[i]);
				}
			}
		}

		Arrays.sort(nearr);
		return nearr[nearr.length - 1];

	}

	public static int PrintLISWithVaues(int[] arr) {

		int[] nearr = new int[arr.length];
		Arrays.fill(nearr, 1);
		ArrayList<Integer> al = new ArrayList<>();

		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && nearr[i] < (nearr[j] + 1)) {
					nearr[i] = nearr[j] + 1;
					// nearr[i] = Math.max(nearr[j] + 1, nearr[i]);
					if (!al.contains(arr[j])) {
						al.add(arr[j]);
					}
				}

				if (nearr[i] > nearr[maxIndex]) {
					maxIndex = i;
				}
			}

		}
		al.add(arr[maxIndex]);

		System.out.println(al);
		return nearr[maxIndex];

	}

}
