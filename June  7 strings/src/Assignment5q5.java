
public class Assignment5q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// string builder

		substr("hello");
		max("bcaaabbcb");
		String a = removesconsecutiveduplicates("jaaaaaaavvvvvvvvvvuuuuul");
		System.out.println(a);
		String a1 = compress("jaaaaaaavvvvvvvvvvuuuuulllll");
		System.out.println(a1);

	}

	public static void substr(String s) // SUBSTRINGS
	{
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		for (int counter = 0; counter < sb.length(); counter++) {
			for (i = counter + 1; i < sb.length(); i++) {
				System.out.println(sb.subSequence(counter, i));
			}
		}

	}

	public static void max(String s) {
		StringBuilder sb = new StringBuilder(s);
		// char[] array = s.toCharArray();
		int count = 1;
		int max = 0;
		char maxChar = 0;
		for (int i = 1; i < sb.length(); i++) { // Start from 1 since we want to
												// compare it with the char in
												// index 0
			if (sb.charAt(i) == sb.charAt(i - 1)) {
				count++;
			} else {
				if (count > max) { // Record current run length, is it the
									// maximum?
					max = count;
					maxChar = sb.charAt(i - 1);
				}
				count = 1; // Reset the count
			}
		}
		if (count > max) {
			max = count; // This is to account for the last run
			maxChar = sb.charAt(sb.length() - 1);
		}
		System.out.println("Longest run: " + max + ", for the character " + maxChar);

	}

	public static String removesconsecutiveduplicates(String s) {
		StringBuilder sb = new StringBuilder(s);
		String ans = "";
		int i;

		for (i = 1; i < sb.length(); i++) {

			if (sb.charAt(i - 1) != sb.charAt(i)) {
				ans = ans + s.charAt(i - 1);

			}
		}
		return ans + s.charAt(sb.length() - 1);

	}

	public static String compress(String s) {
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		int count = 0;
		StringBuilder ans = new StringBuilder();

		for (i = 1; i < sb.length(); i++) {

			if (sb.charAt(i) == sb.charAt(i - 1)) {
				count++;
			} else {
				ans.append(sb.charAt(i - 1));

				if (count == 0) {
					continue;
				} else {
					ans.append(count + 1);
					count = 0;
				}
			}

		}

		ans.append(sb.charAt(sb.length() - 1));

		if (count > 0) {
			ans.append(count + 1);
		}
		return ans.toString();

	}
}
