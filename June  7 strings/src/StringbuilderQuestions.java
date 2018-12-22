import java.util.Scanner;

public class StringbuilderQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");String string =scn.nextLine();
		
		String r=toggle(string);
		System.out.println(r);
//		String p=replace(str);
//		System.out.println(p);
//		String k =quest5(str);
//		System.out.println(k);
//		substr(str);
//		 char[] q8  = ques8(str);
//		System.out.println(q8);
	}
	
	public static String toggle(String str){ 
		StringBuilder sb = new StringBuilder (str);
		int i=0;
//		System.out.println((char)(sb.charAt(0) - 97 +'A'));
//		System.out.println('a');
//		System.out.println(str);
//		sb.setCharAt(0, 'a');
//		System.out.println(sb);
		for (i=0 ; i < str.length() ; i++)
		{
			if ( sb.charAt(i)>='a' && sb.charAt(i) <= 'z')
			{
				sb.setCharAt(i, (char)(sb.charAt(i) - 97 + 'A'));
//				System.out.println(sb.charAt(i + '0' ));
				
			}else if ( sb.charAt(i)>='A' && sb.charAt(i) <= 'Z'){
				
				sb.setCharAt(i,(char) (sb.charAt(i) - 'A' + 'a'));
			}else {
				System.out.println("Invalid ");
			}
			
			
		}
		return sb.toString(); //string builder to string 

		
		
	}
	public static String replace(String str)
	{	StringBuilder sb = new StringBuilder (str);
		int i=0;
		for (i=0 ; i<str.length();i++ )
		{
			char ch=sb.charAt(i);
			if (i%2==0)
			{
//				ch = (char)(ch-1);
				sb.setCharAt(i, (char)(ch-1));
				
			}else 
			{
	//			ch = (char)(ch+1);
				sb.setCharAt(i, (char)(ch+1));
				
			}
			
		}
		return sb.toString();
	}
	public static String difference(String str)
	{
		StringBuilder sb = new StringBuilder (str);
		
		sb.append(str.charAt(0));
		for (int i= 1; i < str.length() ;i++){
			int d =str.charAt(i) - str.charAt(i-1);
			sb.append(d);
			sb.append(str.charAt(i));
			
		}
		return sb.toString();
		
	}
	public static void substr(String s) // SUBSTRINGS
	{
		StringBuilder sb = new StringBuilder (s);		
		int i;
		 
		for (int counter = 0;counter < sb.length() ; counter++) {
			for (i = counter ; i < sb.length()-1; i++) {
				System.out.println(sb.substring(counter, i+1));
			}

			
		}

	}
	public static char[]  ques8(String str){
		
		 int temp = 0;
	        int count = 0;
	        int current = 0;

	        char[] maxchar = new char[str.length()];

	        for (int i = 0; i < str.length(); i++) 
	        {
	            char ch = str.charAt(i);

	            for (int j = i + 1; j < str.length(); j++) 
	            {
	                char ch1 = str.charAt(j);

	                if (ch != ch1) 
	                {
	                    count++;
	                }
	            }

	            if (count > temp) 
	            {
	                temp = count;
	                maxchar[current] = ch;
	                current++;
	            }
	        }
	        return maxchar;
	    }
	}



