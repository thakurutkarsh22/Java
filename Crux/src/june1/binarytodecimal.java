package june1;

import java.util.Scanner;

public class binarytodecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Value enter :");
		Scanner scn = new Scanner(System.in);
		
		int bin = scn.nextInt();
		
		int dec=0; 
		int twkp =1;
		while (bin!=0){
			int rem = bin % 10;
			bin=bin / 10;
			
		dec = dec + rem * twkp;
		twkp = twkp * 2 ;
	}
	
	 System.out.println(dec);
}
}
