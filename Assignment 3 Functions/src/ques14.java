import java.util.Scanner;

public class ques14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();
		double a = Math.log(x);
		double b = Math.log(n);
		
		System.out.println(a/b);
		
	}

}
