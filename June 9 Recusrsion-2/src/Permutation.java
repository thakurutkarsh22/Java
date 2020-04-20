import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		
		
		ArrayList<String> a =permutation("123");
		System.out.println(a.size() );
	}

	public static ArrayList<String> permutation(String str)
	{
		if (str.length()==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br ;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = permutation(ros); //recursion result
		ArrayList<String> mr = new ArrayList<>();
		
		for(int i =0 ; i<rr.size() ; i++){
			String str1 =rr.get(i);
					
			for (int j = 0 ; j<=str1.length() ; j++){
				
				StringBuilder sb = new StringBuilder(str1) ; 
				
				sb.insert(j, ch);
				mr.add(sb.toString());
			}
		}
	return mr;
	}
}
