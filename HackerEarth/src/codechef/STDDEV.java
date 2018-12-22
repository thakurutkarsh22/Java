package codechef;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.io.IOException;
import java.util.Scanner;

public class STDDEV {

	public static void main(String[] args) throws IOException
	{
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		double n,s;
		while(t-- > 0)
		{
		    n = scn.nextDouble();
		    s = scn.nextDouble();
		    if(n == 1)
		    {
		        if(s == 0)
		            System.out.println("1");
		        else
		            System.out.println("-1");
		        continue;
		    }
		    double x = s * Math.sqrt(0.5 * n);
		    System.out.print(-x + " ");
		    for(int i = 1; i <= n-2; i++)
		    {
		        System.out.print("0 ");
		    }
		    System.out.println(x);
		}
    }
}

