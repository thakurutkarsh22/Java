
public class ques3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(GetKPC("12", ""	));
	}
	public static String getCode(char ch) {
		if (ch == '0') {
			return ".;";
		} else if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jkl";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yz";
		} else {
			return "";
		}
	}

	public static int GetKPC(String ques ,String ans ){
		
		if (ques.length()==0){
			System.out.println(ans);
			return 1;
		}
		int count =0;
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String choices = getCode(ch);
		for (int i=0 ; i <choices.length();i++ ){
			
			int count1 = GetKPC( roq , ans+ choices.charAt(i) );
			count+=count1;
		}
		
		return count;
		
	}

}