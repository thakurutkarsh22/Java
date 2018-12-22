import java.lang.reflect.Array;
import java.util.ArrayList;

public class getmazepath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getMazePath(0, 0, 2, 2));
		//System.out.println( getMazePath1(0,0,2,2).size());
	}
	
	public static ArrayList<String> getMazePath(int cr , int cc , int er , int ec){
		// current column // end column 
		

		if (cr==er && cc==ec){
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr>er || cc>ec){
			ArrayList<String> ar = new ArrayList<>();
			return ar;
		}
		ArrayList<String> mr = new ArrayList<>();
		
		ArrayList<String> rrh = getMazePath(cr, cc+1, er, ec);
		for (int i =0 ; i<rrh.size() ; i++){
			
			mr.add("H" + rrh.get(i));
		}
		
		ArrayList<String> rrv = getMazePath(cr+1, cc, er, ec);
		for (int i =0 ; i<rrv.size() ; i++){
			
			mr.add("V" + rrv.get(i));
		}
		ArrayList<String> rrd = getMazePath(cr+1, cc+1, er, ec);
		
		for (int i =0 ; i<rrd.size() ; i++){
			
			mr.add("D" + rrd.get(i));
			
		}
				
		return mr ;
	}
	
	public static ArrayList<String> getMazePath1(int cr , int cc , int er , int ec){
		
		// multi-steps 
		if (cr==er && cc==ec){
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr>er || cc>ec){
			ArrayList<String> ar = new ArrayList<>();
			return ar;
			
		}
			
		ArrayList<String> mr = new ArrayList<>();
	
		// for horizontal 
		
		for (int i=1 ; i<=ec-cc ; i++){
			ArrayList<String> rrh = getMazePath1(cr, cc+i, er, ec);
			for (int l =0 ; l<rrh.size() ; l++){
				
				mr.add("H" + i + rrh.get(l));
			}
			
		}
		// for vertical 
		
		for (int j=1 ; j<=er-cr ; j++){
			ArrayList<String> rrv = getMazePath1(cr+j, cc, er, ec);
			for (int l =0 ; l<rrv.size() ; l++){
				
				mr.add("V" + j + rrv.get(l));
				}
		
			}
		
		for (int k=1 ; k<=er-cr && k<=ec-cc ; k++){
				ArrayList<String> rrd = getMazePath1(cr+k, cc+k, er, ec);
				for (int l =0 ; l<rrd.size() ; l++){
					
					mr.add("D" + k + rrd.get(l));
					}
				
			}
		
		return mr;	
	}
}