import java.util.Arrays;

public class PrimeNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printPrimeSoE(100);
	}

	public static void printPrimeSoE(int n ) {
		
		boolean[] primes = new boolean [n+1];
		
		Arrays.fill(primes, true);
		
		primes[0] = false ;    // nlog(logn) complexity
		primes[1] = false;

		
		for (int i = 2 ; i*i<=n ; i++) {
			
			if(primes[i]== false) {
				continue;
			}
			for(int mult = 2 ; i*mult <= n ; mult++ ) {
				
				primes[i*mult]=false;
			}
			
			
		}
		
		for (int i = 0 ; i<=n ; i++) {
			
			if(primes[i]) {
				System.out.println(i);
			}
		}
	}
}
