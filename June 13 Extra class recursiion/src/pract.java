import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class pract {
//	static StringBuilder str=new StringBuilder();
	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	        int N = scn.nextInt();
//	        System.out.println("1");
//	        System.out.println("2"+"    " + "2");
	        for(int i=0; i <N; i++){
//	           int counter=0;
	        	for(int j=0 ; j<=i;j++){
	              if(j==0||j==i) {
	            	  System.out.print(i+1+"    "); 
//	            	  counter++;
	              }else {
	            	  System.out.print("0" + "    ");
//	            	  counter++;
	              }
	            	
	            }
	            System.out.println();
	        }
	    }
}