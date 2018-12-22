
public class PrintPermutaionNewMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PP("abc", ""));
	}

	public static int PP(String ques  , String ans){
		
		if (ques.length()==0){
			System.out.println(ans);
			return 1;
		}
	
	
		int count =0 ;
		for (int i=0 ; i<ques.length() ; i++){
			
			char ch = ques.charAt(i);
			String roq = ques.substring(0,i) + ques.substring(i+1);
		
			int count1= PP(roq, ans + ch);
			count+=count1;
		}
		return count;
	
	}
	
}
