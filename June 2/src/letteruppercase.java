import java.util.Scanner;

public final class letteruppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("To check the uppercase:");
		Scanner scn = new Scanner(System.in);

		char character = scn.nextLine().charAt(0);
		
		if (character >= 'A'   && character <= 'Z' )
		{
			System.out.println("U" + (int)character);
		}
		else 
			if ( character >= 'a' && character <= 'z')
			{
				System.out.println("L" + (int)character);
			}
			else 
			{
				System.out.println("I" +  (int)character);
			}
	}

}
