package StacksPractice;

import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class asd
{
	public static void main (String[] args) throws java.lang.Exception
	{Scanner ds= new Scanner(System.in);
    int q=ds.nextInt();
    int ring;
    for (int i = 1; i < q+1; i++) 
    {ring=0;
    if(ds.hasNext())
    {
    String[] string=new String[5];
    String[] string2=new String[5];
    for (int j = 0; j < 4; j++) {
    string[j]=ds.next();
    }
    for (int j = 0; j < 4; j++) 
    {
    string2[j]=ds.next();
    }
    for (int k = 0; k < 4; k++) 
    {
    for (int j = 0; j < 4; j++) 
    {
    if(string[k].compareTo(string2[j]) == 0)
    ring=ring+1;
    }
    }
    if(ring>=2)
    System.out.println("similar");
    else
    System.out.println("dissimilar");
    }
    }
    }
    } 