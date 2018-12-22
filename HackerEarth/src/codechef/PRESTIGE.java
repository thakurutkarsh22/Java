package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class PRESTIGE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader BF = new BufferedReader(is);
		System.out.println("y");
		int test[] = new int[2];
		String ap[] = BF.readLine().split(" ");
		for (int i = 0; i < 2; i++) {
			test[i] = Integer.parseInt(ap[i]);
		}
		int N = test[0];
		int M = test[1];

		int[] Deck1U = new int[N];
		int[] Deck1L = new int[N];

		int[] Deck2U = new int[N];
		int[] Deck2L = new int[N];

		String[] a = BF.readLine().split(" ");
		String[] b = BF.readLine().split(" ");

		Arrays.fill(Deck1U, 1);
		Arrays.fill(Deck1L, -1);

		for (int i = 0; i < N; i++) {

			Deck2U[i] = Integer.parseInt(a[i]);

		}

		for (int i = 0; i < N; i++) {

			Deck2L[i] = Integer.parseInt(b[i]);
		}

		for (int i = 0; i < M; i++) {

			String s[] = BF.readLine().split(" ");
			int temparr[] = new int[s.length];

			for (int j = 0; j < temparr.length; j++) {
				temparr[j] = Integer.parseInt(s[j]);
			}

			if (temparr[0] == 3) {
				fun1(temparr, Deck1U, Deck2U);
			} else if (temparr[0] == 2) {
				fun2(temparr[1], Deck1U, Deck1L);
			} else if (temparr[0] == 1) {
				fun3(temparr[1] - 1, temparr[2] - 1, Deck2U, Deck2L);
			}

		}

//		fun(Deck1L,Deck1U);
		System.out.println("yo");
		// operations

	}

	private static void fun3(int a, int b, int[] deck2u, int[] deck2l) {
		// TODO Auto-generated method stub

		int temarr[] = deck2u;

		for (int i = a; i < b; i++) {
			deck2u[i] = deck2l[b + 1 - i];
		}

		for (int i = a; i < b; i++) {
			deck2l[i] = temarr[b + 1 - i];
		}

	}

	private static void fun2(int k, int[] deck1u, int[] deck1l) {
		// TODO Auto-generated method stub

		int temarr[] = deck1u;

		for (int i = 0; i < k; i++) {
			deck1u[i] = deck1l[k - 1 - i];
		}

		for (int i = 0; i < k; i++) {
			deck1l[i] = temarr[k - 1 - i];
		}

	}

	public static void fun1(int[] temparr, int[] first, int[] second) {
		int A = temparr[1] - 1;
		int B = temparr[2] - 1;
		int C = temparr[3] - 1;
		int D = temparr[4] - 1;

		int result = 0;
		while ((C != D) && (A != B)) {
			result += first[C] * second[A];
			C++;
			A++;
		}

		System.out.println(result);

	}

}
