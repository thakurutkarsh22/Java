package GreedyHuMai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };

		int s1[] = { 5, 3, 0, 8, 1, 5 };
		int f1[] = { 7, 4, 6, 9, 2, 9 };
		int n = s.length;

		activity[] arr = new activity[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new activity(s1[i], f1[i]);
		}

		Arrays.sort(arr, new activitycomparator());

		 printMaxActivities(s, f, n);
		MaxActivities(arr, n);
	}

	private static void MaxActivities(activity[] arr, int n) {
		int i = 0;
		int[] a = new int[2];
		a[1] = arr[i].finish;
		a[0] = arr[i].start;

		ArrayList<int[]> al = new ArrayList<>();
		al.add(a);

		for (int j = 1; j < n; j++) {
			if (arr[j].start >= arr[i].finish) {
				int[] b = new int[2];
				b[1] = arr[j].finish;
				b[0] = arr[j].start;
				al.add(b);
				i = j;
			}
		}

	}

	public static class activity {
		activity(int i, int j) {
			this.start = i;
			this.finish = j;
		}

		int start;
		int finish;

	}

	public static class activitycomparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			activity a1 = (activity) o1;
			activity a2 = (activity) o2;

			return (a1.finish >= a2.finish) ? 1 : -1;
		}

	}

	private static void printMaxActivities(int[] s, int[] f, int n) {

		int i = 0;
		System.out.println(s[i] + f[i]);

		for (int j = 1; j < n; j++) {
			if (s[j] >= f[i]) {
				System.out.println(s[j] + f[j]);
				i = j;
			}
		}

	}

}
