
public class Dictonary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lexico(1, 100);
		fn("cbda" , "");
		
		
	}

	public static void lexico(int curr , int max){
		
		if (curr >max) {
			return; 
		}
		
		
		if (curr <= max){
			
			System.out.println(curr);
		}
		
		 for (int i =0 ; i <= 9 ; i++){
			 
			 lexico (curr*10 + i , max);
		 }
		 
		 if (curr <9){
			 lexico(curr+1 , max);
			}
	
	}
	
	public static void fn(String str , String ans  ) {
		if(str.length()== 0) {
			
			System.out.println(ans);
		}
		
		//char pri = str.charAt(0);
		
		for (int i =0 ; i<str.length()-1 ; i++ ) {
		
			
		char ch =str.charAt(i);
		if(str.charAt(0) > str.charAt(i+1)) {
			continue;
		}
		
		for (int j=0 ; i<str.length() ; i++){
			
			char ch1 = str.charAt(0);
			String roq = str.substring(0,j) + str.substring(j+1);
		
			 fn(roq, ans + ch1);
			
		}
		
		
		
//		String roq = str.substring(0, i) + str.substring(i+1 , str.length());
//			fn(roq ,ans+ch);
			
		}
	}
	
	public static void q9(String str , String ans ) {
		if(str.length()== 0) {
			
			System.out.println(ans);
		}
		
	for(int i = 0 ; i<str.length()-1 ; i++) {
		
		for(int itr =i ; itr < str.length() ;i++) {
			
		
		
			if (str.charAt(i) < str.charAt(i+1)) {
				
			
			char ch = str.charAt(i);
			String roq = str.substring(0, i) + str.substring(i+1 , str.length());
			q9(roq ,ans+ch );
			
		}else {
			continue;
		}
		
		
			
	}
	}			
				
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
