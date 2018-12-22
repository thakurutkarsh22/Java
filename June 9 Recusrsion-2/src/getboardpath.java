//import java.lang.reflect.Array;
import java.util.ArrayList;

public class getboardpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getboardpaths(0 , 10);
		System.out.println( getboardpaths(0, 5));
	}
	
	public static ArrayList<String> getboardpaths(int curr , int end){
		
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			if (curr == 0) {
				if (dice == 1 || dice == 6) {
					ArrayList<String> rr = getboardpaths(curr + dice, end);
					for (int i = 0; i < rr.size(); i++) {
						mr.add(dice + rr.get(i));
					}
				}
			} else {
				ArrayList<String> rr = getboardpaths(curr + dice, end);
				for (int i = 0; i < rr.size(); i++) {
					mr.add(dice + rr.get(i));
				}
			}
		}

		return mr;
	}
	
}