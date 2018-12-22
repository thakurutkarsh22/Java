import java.util.ArrayList;

public class ques1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsequence("abcd", ""));
		System.out.println(subsequence2("abcd", ""));
		subsequence3("abcd", "");
	}
	
	public static int subsequence(String str , String ans){
		
		if(str.length()==0){
			
			System.out.println(ans);
			return 1;
		}
		
		
		char ch = str.charAt(0);
		String roq = str.substring(1);
		
		int count1 = subsequence(roq, ans);
		int count2 = subsequence(roq, ans +ch);
		
		return count1+count2;
		
		
		
	}
	
public static int subsequence2(String str , String ans){
		
		if(str.length()==0){
			ArrayList<String> rr = new ArrayList<>();
			rr.add(ans);
			System.out.println(rr);
			return 1;
		}
		
		//ArrayList<String> rr = new ArrayList<>();
		char ch = str.charAt(0);
		String roq = str.substring(1);
		
		int count1 = subsequence2(roq, ans);
		int count2 = subsequence2(roq, ans +ch);
		
		return count1+count2;
		
		
		
	}

public static void subsequence3(String str , String ans){
	
	if(str.length()==0){
		ArrayList<String> rr = new ArrayList<>();
		rr.add(ans);
		System.out.println(rr);
		return;
	}
	
	//ArrayList<String> rr = new ArrayList<>();
	char ch = str.charAt(0);
	String roq = str.substring(1);
	
	 subsequence3(roq, ans);
	 subsequence3(roq, ans +ch);
	
	
	return;
	
	
}
}
