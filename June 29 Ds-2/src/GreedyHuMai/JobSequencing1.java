package GreedyHuMai;

import java.util.Arrays;
import java.util.Comparator;

import GreedyHuMai.JobSequencing.job;
import GreedyHuMai.JobSequencing.jobcomparator;

public class JobSequencing1 {
	
	public static void main(String[] args) {
		
		int [] dead = {2,1,2,1,3};
		int [] profit = {100,19,27,25,15};
		int n = dead.length;
		
		job[] j = new job[n];
		
		for(int i=0 ; i<n ; i++) {
			j[i] = new job((char)('a'+i),dead[i],profit[i]);
		}
		
		Arrays.sort(j, new jobcomparator());
		printJobSCheduling(j);
		
		
		
	}
	
	public static class job {
		public job(char a,int i, int j) {
			this.id = a;
			this.dead = i;
			this.profit =j;
		}
		char id ;
		int dead ;
		int profit;
	}
	
	public static class jobcomparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			job a1 = (job) o1;
			job a2 = (job) o2;

			return (a1.profit >= a2.profit) ? -1: 1;
		}

	}
	
	public static void printJobSCheduling(job[] j) {
		
		// finding maximum deadline 
		int max = findmaxdeadline(j);
		
		int parent[] = new int[max+1];
		for(int i=0 ;i<=max ;i++) {
			parent[i]=i;
		}
		
		for(job temp : j) {
			int avaiableslot = find(temp.dead , parent);
			
			if(avaiableslot >0) {
				int f = find(avaiableslot-1,parent);
				merge(f,avaiableslot, parent);
				System.out.println(temp.id);
				for(int i=0 ;i<=max ;i++) {
					System.out.print(parent[i]+ " ");
				}
			}
		}
		
		
		
		
	}

	private static void merge(int u, int v , int[] parent) {
			
		parent[v]=u;
		return;
	}

	private static int find(int s , int [] parent) {
		
		if(s==parent[s]) {
			return s;
		}
		
		 return parent[s] = find(parent[s] , parent);
	}

	private static int findmaxdeadline(job[] j) {
		
		int max = Integer.MIN_VALUE;
		for(job kl :j) {
			if(kl.dead>max) {
				max=kl.dead;
			}
		}
		
		return max;
	}
	
	
	
}
