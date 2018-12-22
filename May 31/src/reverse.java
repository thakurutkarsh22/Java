import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// System.out.println("Enter number");
		//
		// int n = scn.nextInt();
		//
		/// * int rev = 0;
		// while(n != 0){
		// int rem = n % 10;
		// rev = 10 * rev + rem;
		// n = n / 10;
		// }
		//
		// System.out.println(rev);
		// */
		//
		// while (n !=0)
		// {
		// int rem = n % 10;
		// System.out.print(rem);
		// n = n / 10;
		// }
		System.out.println(ques5("hello"));

	}

	public static String ques5(String s) {

		if (s.length() == 1) {
			return s;
		}

		char ch1 = s.charAt(0);
		char ch2 = s.charAt(1);
		String ros = s.substring(1);
		String rr = ques5(ros);
		String mr = "";
		if (ch1 == ch2) {
			StringBuilder sb = new StringBuilder();
			sb.append(ch1);
			sb.append('*');
			sb.append(rr);
			mr = sb.toString();

		} else {
			mr = ch1 + rr;

		}

		return mr;

	}

}