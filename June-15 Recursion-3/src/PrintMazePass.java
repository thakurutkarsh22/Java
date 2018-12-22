
public class PrintMazePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PrintMPWD(0,0,2,2, ""));
		System.out.println(PrintMMPWD(0,0,2,2, ""));
		
		
	}
	
	public static int PrintMPWD(int cr , int cc , int er , int ec , String ans){
		
		// print maze path
		if (cr==er && cc==ec){
			System.out.println(ans);
			return 1;
		}
		
		if(cr>er || cc>ec){
			
			return 0;
		}
		
		int count = 0;
		
		int ch = PrintMPWD(cr, cc + 1, er, ec, ans +'H');
		int cv = PrintMPWD(cr+1, cc , er, ec, ans +'V');
		int cd = PrintMPWD(cr+1, cc + 1, er, ec, ans +'D');
		
		count = ch + cv +cd ; 
		return count ;
		
	}

public static int PrintMMPWD(int cr , int cc , int er , int ec , String ans){
		
		// print multiple maze path
		if (cr==er && cc==ec){
			System.out.println(ans);
			return 1;
		}
		
		if(cr>er || cc>ec){
			
			return 0;
		}
		
		int count = 0;
		for (int i=1 ; i<=ec-cc ; i++){
		int ch = PrintMMPWD(cr, cc + i, er, ec, ans +'H' + i);
		count+=ch;
		}
		
		for (int i=1 ; i<=er-cr ; i++){
		int cv = PrintMMPWD(cr+i, cc , er, ec, ans +'V' + i);
		count+=cv;
		}
		for (int i=1 ; i<=ec-cc && i<=er-cr ; i++){
		int cd = PrintMMPWD(cr+i, cc + i, er, ec, ans +'D' + i);
		count+=cd;
		}
		
		//count = ch + cv +cd ; 
		return count ;
		
	}

}
