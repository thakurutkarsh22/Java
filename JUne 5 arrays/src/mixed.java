import java.util.Scanner;

public class mixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		boolean ans = true;
		int a =k;
		int i=0;
		while(k!=0) {
			k=k/10;
			i++;
		}
//		System.out.println(i);
		
		int arr[] = new int[i];
		int j=0;
		while(a!=0) {
			arr[arr.length-1-j] = a%10;
			a=a/10;
			j++;
		}
		
		
		int [] newarr = new int[arr.length];
		
		for(int l=0 ; l<arr.length;l++) {
			int temp = arr[l];
			newarr[temp-1] = arr.length-l;
			
		}
		int temparr[] = new int[arr.length];
		for(int l =0 ;l<arr.length ; l++) {
			temparr[l] = newarr[arr.length-1-l];
		}
		newarr=temparr;
		
		for(int l=0 ; l<arr.length;l++) {
			if(arr[l]!=newarr[l]) {
				ans=false;
				break;
			}
		}
		System.out.println(ans);
		
		for(int l=0 ; l<arr.length;l++) {
			System.out.println(arr[l]);
		}
		System.out.println();
		for(int l=0 ; l<arr.length;l++) {
			System.out.println(newarr[l]);
		}
		
		
	}

}
