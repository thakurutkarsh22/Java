package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ROBOGAME {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		HashMap<Integer, String> hm = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			hm.put(i, s.charAt(i)+"");
		}
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '0' || s.charAt(j) == '1'||  s.charAt(j) == '2'||  s.charAt(j) == '3'
					 ||s.charAt(j) == '4' || s.charAt(j) == '5'  ||s.charAt(j) == '6' || s.charAt(j) == '7'
					 ||s.charAt(j) == '8'||  s.charAt(j) == '9') {
				int range1 = j - Integer.parseInt(hm.get(j));
				int range2 = j + Integer.parseInt(hm.get(j));

				if (range2 > s.length()  || s.charAt(range1) != '.' ||  s.charAt(range2) != '.') {
					System.out.println("unsafe");
					return;
				}

				else {
					System.out.println("safe");
				}
			} else {
				continue;
			}

		}}
}