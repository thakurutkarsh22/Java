package SegmentedTree.squarerootdecomposition;
import java.util.*;
public class code
{
	static class Pair
	{
		int first;
		int second;
		Pair(int a,int b)
		{
			first=a;
			second=b;
		}
	}
	static class Comp implements Comparator<Integer>
	{
		public int compare(Integer a, Integer b)
		{
			return dist[a]-dist[b];
		}
	}
	static int dist[];
	static ArrayList<ArrayList<Pair>> list;
	static void dijsktra(int src,int n)
	{
		//Comparator<Integer> comp=(a,b)->{return dist[a]-dist[b];};
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comp());
		Arrays.fill(dist,Integer.MAX_VALUE);
		pq.add(src);
		dist[src]=0;
		while(!pq.isEmpty())
		{
			int u=pq.poll();
			for(Pair p:list.get(u))
			{
				int v=p.first;
				int w=p.second;
				if(dist[v]>dist[u]+w)
				{
				//	pq.remove(v);
					dist[v]=dist[u]+w;
					pq.add(v);
				}
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		list=new ArrayList<ArrayList<Pair>>();
		for(int i=0;i<=n;i++)
			list.add(new ArrayList<Pair>());
		for(int i=0;i<m;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			list.get(u).add(new Pair(v,0));
			list.get(v).add(new Pair(u,1));
		}
		dist=new int[n+1];
		dijsktra(1,n);
		System.out.println((dist[n]==Integer.MAX_VALUE)?-1:dist[n]);
	}
	
//	7 7
//	1 2 
//	3 2
//	3 4
//	7 4
//	6 2
//	5 6
//	7 5
}