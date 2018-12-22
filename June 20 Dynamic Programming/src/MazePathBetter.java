
public class MazePathBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountMazePath(0, 0, 4, 4));
		System.out.println(CountMazePathbetter(0, 0, 3, 3, new int[4][4]));
//		System.out.println(CMPIterative(3, 3));
//		System.out.println(CMPTItrativeBetter4, 4));

//		System.out.println(CMPdiagonalIterative(3, 3));
//		System.out.println(CMPIterativeDiagonalBetter(3, 3));
	}

	public static int CountMazePath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
		
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = CountMazePath(cr, cc + 1, er, ec);// count horizontal
		int cv = CountMazePath(cr + 1, cc, er, ec); // count vertical

		int count = ch + cv;
		return count;
	}

	public static int CountMazePathbetter(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = CountMazePathbetter(cr, cc + 1, er, ec, strg);// count horizontal
		int cv = CountMazePathbetter(cr + 1, cc, er, ec, strg); // count vertical

		int count = ch + cv;
		strg[cr][cc] = count;
		return count;
	}

	public static int CMPIterative(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		strg[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {

				if (col == ec && row == er) {
					strg[row][col] = 1;
					continue;
				}
				strg[row][col] = strg[row + 1][col] + strg[row][col + 1];

			}

		}
		return strg[0][0];

	}

	public static int CMPTItrativeBetter(int er, int ec) {

		int[] strg = new int[ec + 1];

		for (int i = 0; i <= ec; i++) {

			strg[i] = 1; // initialising 1 int the new array
		}

		strg[ec] = 1;
		for (int j = strg.length - 2; j >= 0; j--) {

			// int temp = strg[ec-1];
			for (int k = ec - 1; k >= 0; k--) {

				strg[k] = strg[k] + strg[k + 1];

			}

		}
		return strg[0];
	}
	
	public static int CMPdiagonalIterative(int er , int ec) {
		
		int[][] strg = new int[er + 2][ec + 2];

		strg[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {

				if (col == ec && row == er) {
					strg[row][col] = 1;
					continue;
				}
				strg[row][col] = strg[row + 1][col] + strg[row][col + 1]+ strg[row+1][col+1];
				System.out.println(strg[row][col]);
			}

		}
		return strg[0][0];

	}

	public static int CMPIterativeDiagonalBetter (int er, int ec) {
		
		int[] strg = new int[ec + 1];

		for (int i = 0; i <= ec; i++) {

			strg[i] = 1; // initialising 1 int the new array
		}

		int diag = 0, nv = 0;
		// requires er slidings
		for(int slider = 1; slider <= er; slider++){
			for(int col = ec; col >= 0; col--){
				if(col == ec){
					strg[col] = 1;
					diag = 1;
				} else {
					nv = strg[col + 1] + diag + strg[col];
					diag = strg[col];
					strg[col] = nv;
				}
			}
		}
		
		return strg[0];
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

