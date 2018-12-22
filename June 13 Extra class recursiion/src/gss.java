import java.util.ArrayList;

public class gss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getss("abc"));
//		System.out.println(getequisum("abyz" , "", "" , 0 ,0  ));
		System.out.println(getssanothermethod("abc", ""));
//		System.out.println(PrintSS("abc", ""));
	}
	
	public static ArrayList<String> getss(String str){ //  substring 
		
		if (str.length()==0){
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rr = getss(ros); 
		ArrayList<String> mr = new ArrayList<>();
		
		for (int i=0 ; i<rr.size() ; i++){
			
		
			mr.add(rr.get(i));
			mr.add(ch + rr.get(i));
		
//			for (int j =0 ; j < mr.size() ; j++){
//				
//				ArrayList<String> mr1 = new ArrayList<>(mr);
//				
//				if (mr.get(j) == )
			//}
		}
		
		
		return mr;
		
//		ArrayList<String> same = new ArrayList<>();
		
		
		
		
	}
	
	public static ArrayList<String> getssanothermethod(String str , String ssf)
	{
		if (str.length()==0){
			ArrayList<String> br =new ArrayList<>();
			br.add(ssf);
			return br;
		} // ssf = solution so far 
		
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> mr = new ArrayList<>();
		
		ArrayList<String> rrpos = getssanothermethod(ros, ssf +ch );
		mr.addAll(rrpos);
		ArrayList<String>  rrneg = getssanothermethod(ros, ssf );
		mr.addAll(rrneg); // rr negitive 
		
		// rr positive

		return mr;
	}
	
	public static ArrayList<String> getequisum(String str , String g1 , String g2 , int sg1 , int sg2){
		
		//sg1 = sum of g1 
		if (str.length()==0){
			ArrayList<String> br = new ArrayList<>();
			if (sg1==sg2){
			
				br.add(g1 + "and"  + g2);
				
			}
			return br ;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		
		ArrayList<String> rrneg = getequisum(ros, g1 + ch, g2 , (sg1 + ch), sg2);
		mr.addAll(rrneg);
		
		ArrayList<String> rrpos =getequisum(ros, g1, g2+ch, sg1, (sg2 +ch) );
		mr.addAll(rrpos);
		
		return mr ;
	}

	public static int PrintSS(String quest , String ans ){
		
		// print sub squence by tree method ie. form top to bottom
		if (quest.length()==0){
			System.out.println(ans);
			return 1;
		}
		
		char ch = quest.charAt(0);
		String roq = quest.substring(1); // rest of question 
		
		int cno = PrintSS(roq, ans); // no 
		int cyo = PrintSS(roq, ans +ch); // yes 
		
		return cno+cyo ;
	}
}

