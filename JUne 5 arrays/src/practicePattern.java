import java.util.Scanner;

public class practicePattern {
	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	        int N = scn.nextInt();
	        System.out.println("1");
	        System.out.println("2"+"    " + "2");
	        for(int i=2; i <N; i++){
	           int counter=0;
	        	for(int j=0 ; j<=i;j++){
	              if(counter==0||counter==i) {
	            	  System.out.print(i+1+"    "); 
	            	  counter++;
	              }else {
	            	  System.out.print("0" + "    ");
	            	  counter++;
	              }
	            	
	            }
	            System.out.println();
	        }
	    }
	}