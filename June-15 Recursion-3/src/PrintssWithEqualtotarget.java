import java.util.ArrayList;

public class PrintssWithEqualtotarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 7, 1, 2, 3, 4, 5, 6 };
		printSSWithSumEqualToTarget(arr, 0, 7, "");
		
		
		ArrayList<Integer> al = new ArrayList<>();
	}

	public static int printSSWithSumEqualToTarget(int[] arr, int vidx, int tar, String ans) {

		if (vidx == arr.length) {
			if (tar == 0) {
				System.out.println(ans);
				return 1;
			} else {
				return 0;
			}
		}

		int cno = printSSWithSumEqualToTarget(arr, vidx + 1, tar, ans);
		int cyes = printSSWithSumEqualToTarget(arr, vidx + 1, tar - arr[vidx], ans + " " + arr[vidx]);

		return cno + cyes;
	}

	public static int printSSWithSumEqualToTargetWITHaRRAYliST(int[] arr, int vidx, int tar, boolean b) {

		if (vidx == arr.length) {
			if (tar == 0) {
				System.out.println(ans);
				return 1;
			} else {
				return 0;
			}
		}

		int cno = printSSWithSumEqualToTarget(arr, vidx + 1, tar, ans);
		int cyes = printSSWithSumEqualToTargetWITHaRRAYliST(arr, vidx + 1, tar - arr[vidx],b.add(arr[vidx]));

		return cno + cyes;
	}
}
