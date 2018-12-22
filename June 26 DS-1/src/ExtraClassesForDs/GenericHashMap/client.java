package ExtraClassesForDs.GenericHashMap;

import java.util.ArrayList;

public class client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm = new HashMap<>(20);
		
		hm.put("India", 20);
		hm.put("China",	 55);
		hm.put("ini", 78);
		hm.display();
		ArrayList<String> yo = hm.keyset() ;
		System.out.println(yo);
	}

}
