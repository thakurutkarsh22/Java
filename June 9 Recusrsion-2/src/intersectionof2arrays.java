import java.util.ArrayList;

public class intersectionof2arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {1,1,2,2,2,3,5};
		int [] array2 = {1,1,1,2,2,4,5};
		ArrayList<Integer> list = getIntersection(array1, array2);
		System.out.println(list);
	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two){
		ArrayList<Integer> rv = new ArrayList<>();
								// only for sorted arrays 
		int i = 0, j = 0;
		while(i < one.length && j < two.length){
			if(one[i] < two[j]){
				i++;
			} else if (one[i] > two[j]){
				j++;
			} else {
				rv.add(one[i]);
				i++;
				j++;
			}
		}
			
		return rv;
	}
}
