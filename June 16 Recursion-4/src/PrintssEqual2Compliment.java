import java.util.ArrayList;

public class PrintssEqual2Compliment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println(printSSEqualToComplement1(arr, 0, "", "", "", 0,0));
//		System.out.println();
//		int [] array = {10,20,30,40,50,60,70};
//		int p = printTargetSSNoCon(array ,0, "","" ,"" ,0 , 0 ,true);
//		System.out.println(p);
	}
	
	public static int printSSEqualToComplement1(int [] arr, int vidx ,  String ans , String group , String cgroup , int sge , int scge){
		
		if (vidx == arr.length) {
			if (sge==scge){
			System.out.println(group + " and "  + cgroup);
			return 1;
			}else {
				return 0;
			}
			
		}

		
		
		 int yes = printSSEqualToComplement1(arr, vidx + 1 ,ans +  arr[vidx] , group + " " +arr[vidx], cgroup, sge+ arr[vidx], scge);
		 int no = printSSEqualToComplement1(arr,  vidx + 1 , ans + "", group, cgroup + " " + arr[vidx] , sge , scge +  arr[vidx]);

		return yes+no;
		
	}
	public static ArrayList<String> printSSEqualToComplement(int[] arr, String asf, int vidx, int sumI, int sumE) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();

			if (sumI == sumE) {
				br.add(asf + "\n");
			}

			return br;
		}

		ArrayList<String> rr1 = printSSEqualToComplement(arr, asf  , vidx + 1, sumI + arr[vidx], sumE);
		ArrayList<String> rr2 = printSSEqualToComplement(arr, asf  + " " + arr[vidx], vidx + 1, sumI, sumE + arr[vidx]);

		ArrayList<String> mr = new ArrayList<>();
		mr.addAll(rr1);
		mr.addAll(rr2);

		return mr;
	}
	
	public static int printTargetSSNoCon(int [] arr, int vidx ,  String ans , String group , 
											String cgroup , int sge , int scge ,
		
											boolean	wasLastElementIncluded) {
		if (vidx == arr.length) {
			if (sge == scge) {
				System.out.println(ans); //refer codes 
			}

			return 0;
		}

		int a=0 , b=0;
		if (wasLastElementIncluded) {
			b =printTargetSSNoCon(arr, vidx+1, ans , group +" " + arr[vidx],cgroup , sge , scge +arr[vidx]  , false);
		} else {
			a=printTargetSSNoCon(arr,vidx+1 , ans + " "+ arr[vidx], group + " " + arr[vidx],cgroup, sge + arr[vidx] , scge, true);
			b=printTargetSSNoCon(arr,vidx+1 , ans , group + " " + arr[vidx] , cgroup , sge , scge + arr[vidx], false);
		}
		return a+b;
	}

}

	