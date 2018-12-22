import java.util.ArrayList;
public class Printtargetss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		int[] array = { 10, 20, 30, 40};//, 50, 60, 70 };
		printTargetSS(array, 120, "", 0);
		System.out.println();
		printTargetSSNoCon(array, 120, "", 0 , false);
		System.out.println();
		
		System.out.println(cnpPerms("abc", "", ""));
		
		boolean a = IsItPosibleToSplitEquiGroups(array,  "", 0 , 0 ,0);
		System.out.println(a);
		System.out.println();
		ArrayList<String> as = getSplitEquiGroups(array, "", 0, 0, 0);
		System.out.println(as);
		
//		System.out.println(cnpPerms("bcad", "", "bcad"));
	}

	public static void printTargetSS(int[] arr, int tar, String asf, int vidx) {
		if (vidx == arr.length) {
			if (tar == 0) {
				System.out.println(asf);
		}

			return;
		}

		printTargetSS(arr, tar - arr[vidx], asf + " " + arr[vidx], vidx + 1);
		printTargetSS(arr, tar, asf , vidx + 1);
	}

	public static void printTargetSSNoCon(int[] arr, int tar, String asf, int vidx, boolean lei) {
		if (vidx == arr.length) {
			if (tar == 0) {
				System.out.println(asf);
			}

			return;
		}

		if (lei) {
			printTargetSSNoCon(arr, tar, asf, vidx + 1, false);
		} else {
			printTargetSSNoCon(arr, tar - arr[vidx], asf + " " + arr[vidx], vidx + 1, true);
			printTargetSSNoCon(arr, tar, asf, vidx + 1, false);
		}
	}
	
	public static int cnpPerms(String qst, String ans, String oqst) {
		if (qst.length() == 0) {
			if (ans.compareTo(oqst) > 0) {
				System.out.println(ans);
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;

		for (int i = 0; i < qst.length(); i++) {
			char ch = qst.charAt(i);
			String ros = qst.substring(0, i) + qst.substring(i + 1);
			int counti = cnpPerms(ros, ans + ch, oqst);
			count += counti;
		}

		return count;
	}
	
	public static boolean IsItPosibleToSplitEquiGroups(int[] arr, String asf, int vidx, int sumI, int sumE) {
		if (vidx == arr.length) {
			if (sumI == sumE) {
				System.out.println(asf);
				return true;
			}
 // answer so far 
			return false;
		}

		boolean f1 = IsItPosibleToSplitEquiGroups(arr, asf + " " + arr[vidx], vidx + 1, sumI + arr[vidx], sumE);
		boolean f2 = IsItPosibleToSplitEquiGroups(arr, asf 	, vidx + 1, sumI, sumE + arr[vidx]);

		return f1 || f2;
	}

	public static ArrayList<String> getSplitEquiGroups(int[] arr, String asf, int vidx, int sumI, int sumE) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();

			if (sumI == sumE) {
				br.add(asf + "\n");
			}

			return br;
		}

		ArrayList<String> rr1 = getSplitEquiGroups(arr, asf  , vidx + 1, sumI + arr[vidx], sumE);
		ArrayList<String> rr2 = getSplitEquiGroups(arr, asf  + " " + arr[vidx], vidx + 1, sumI, sumE + arr[vidx]);

		ArrayList<String> mr = new ArrayList<>();
		mr.addAll(rr1);
		mr.addAll(rr2);

		return mr;
	}
	
	

}
