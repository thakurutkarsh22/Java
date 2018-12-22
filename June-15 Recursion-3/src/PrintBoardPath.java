
public class PrintBoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PrintMPWD(0, 10, ""));
	}
	
public static int PrintMPWD(int curr , int end , String ans){
		
	if (curr == end) {
		System.out.println(ans);
		return 1;
	}

	if (curr > end) {
		return 0;
	}

	int count = 0;

	for (int dice = 1; dice <= 6; dice++) {
		int cd = PrintMPWD(curr + dice, end, ans + dice);
		count += cd;
	}

	return count;
}

}
