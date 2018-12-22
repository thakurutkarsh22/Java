import java.lang.reflect.Array;
import java.util.ArrayList;

public class Getpermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(permutationNewMethod("abcd" , ""));
	}
	
	
	public static ArrayList<String> permutationNewMethod(String str , String ssf ){
		
		if (str.length()==0){
			
			ArrayList<String> br = new ArrayList<>();
			br.add(ssf);
			return br ;
		}
		
		ArrayList<String> mr = new ArrayList<>();
		boolean [] dupli = new boolean [256];
		
		
		
		for (int i =0 ; i< str.length() ;i++)
			
		{
			
			char ch = str.charAt(i);
			if (dupli[ch]==true){
				continue;
			}
			String ros = str.substring(0, i) + str.substring(i+1);
		
//			
//			
			ArrayList<String>  rrpos = permutationNewMethod(ros, ssf + ch);
			mr.addAll(rrpos);
			dupli[ch] =true;
		}
		
		
		return mr;
		
		
	}

}
