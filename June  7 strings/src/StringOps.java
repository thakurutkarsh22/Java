import java.util.Arrays;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String s1 = "Hello";
//		String s2 = "Hell";
//		System.out.println(s1 == s2);
//		printChars("abcdefgh");
//		substr("abcdefg");
//		boolean n = ispali("nitin");
//		System.out.println(n);
		System.out.println(countpalli("abc"));
//		int b = isanagram("acdb", "acfb");
//		System.out.println(b);
	}

	public static void printChars(String s) {
		int i;
		for (i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));

		}

	}

	public static void substr(String s) // SUBSTRINGS
	{
		int i;

		for (int counter = 0; counter < s.length(); counter++) {
			for (i = counter; i < s.length() - 1; i++) {
				System.out.println(s.substring(counter, i + 1));
			}

		}

	}

	public static boolean ispali(String s) // IS PALINTROME
	{
		boolean rv = true;
		int i;
		for (i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				rv= false;
			}

		}

		return rv;

	}

	public static int countpalli(String s) {
		int rv = 0;

		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				String sub = s.substring(si, ei);
				if (ispali(sub)) {
					rv++;
				}
			}
		}

		return rv;
	}

	public static int isanagram(String s1, String s2) {
		
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]-'a');
		}
		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] -'a');
		}
		System.out.println();
		int i =0 , j= 0 , res=0;
		while(i<a.length&& j<b.length) {
			if(a[i]==b[i]) {
				i++;
				j++;
			}else if(a[i]>b[i]) {
				j++;
				res++;
				
			}else {
				i++;
				res++;
			}
		}
		if(i<a.length) {
			res+=(a.length -i);
		}
		if(j<b.length) {
			res+=(b.length -j);
		}
		
		
		return res ;

	}

}
