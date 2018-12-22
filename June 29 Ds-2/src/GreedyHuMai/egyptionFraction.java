package GreedyHuMai;

public class egyptionFraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			fraction(3+3, 14);
		
	}
	
	public static void  fraction (int nr ,int dr ) {
		
		if(nr==0 || dr ==0) {
			return ;
		}
		
		// if nr divides the dr
		
		if(dr>nr) {
			if(dr%nr==0) {
				int a = dr/nr;
				System.out.print("1/" + a );
				return ;
			}
		}
		
		// IF dr divides the Nr 
		
		if(nr%dr==0) {
			return ;
		}
		
		if(nr>dr) {
			int a = nr/dr ; 
			System.out.println(a +"+");
			fraction(nr%dr, dr);
		}
		
		else {
			
			int ciel = dr/nr+1;
			System.out.print("1/"+ ciel + "+");
			 nr = nr*ciel-dr;
			 dr = dr*ciel;
			 fraction(nr, dr);
			
		}
		
		
		
	}

}
