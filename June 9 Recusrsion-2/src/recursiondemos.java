import java.lang.reflect.Array;
import java.util.ArrayList;
public class recursiondemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
	//	ArrayList<String> list ; 
//		System.out.println(getss("abc"));
		
//		System.out.println(printwithascii("ab"));
//		
		System.out.println(getKPC("18"));
	}
	
	public static ArrayList<String> getss(String str)
	{
		//get sub string
		if (str.length()==0)
		{
			ArrayList<String> br =new ArrayList<>();
			br.add("");
			return br;
		}  
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getss(ros); //recursion result
		ArrayList<String> mr = new ArrayList<>();
		for (int i = 0 ; i< rr.size() ; i++)
		{
			mr.add(rr.get(i));
			
			mr.add(ch + rr.get(i));
		}
		return mr;
	}
	public static ArrayList<String> printwithascii(String str){
		
		
		if (str.length()==0)
		{
			ArrayList<String> br =new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = printwithascii(ros);
		
		ArrayList<String> mr = new ArrayList<>();
		
		for (int i = 0 ; i< rr.size() ; i++)
		{
			mr.add(rr.get(i));
			mr.add(ch + rr.get(i)); 
			mr.add(ch + 0 + rr.get(i));
		}
		return mr;
		
		
	}
	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rr = getKPC(ros); // recursion result
		ArrayList<String> mr = new ArrayList<>(); // my result 
		
		String choices = getCode(ch);
		for(int i = 0; i < rr.size(); i++){
			for(int j = 0; j < choices.length(); j++){
				mr.add(choices.charAt(j) + rr.get(i));
			}
		}
		
		return mr;
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
}
// practice 
//	public static ArrayList<String> subsetofastring(String str){
//		
//		char ch = str.charAt(0);
//		String ros = str.substring(1);
//		ArrayList<String> rr = subsetofastring(ros);
//		ArrayList<String> mr = subsetofastring(ros);
//		
//		for (int i=0 ; i<rr.size() ; i++){
//			
//			mr.add(rr.get(i));
//			mr.add(ch+rr.get(i));
//		}
//		
//	}
//}
