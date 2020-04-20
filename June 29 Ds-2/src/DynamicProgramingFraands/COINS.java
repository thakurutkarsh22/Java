package DynamicProgramingFraands;

import java.util.*;
import java.util.Iterator;
import java.util.PriorityQueue;

public class COINS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 2, 4 };
		int[][] NearlySortedAlgo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// CoinPermutation(coins, 6, "", 0);
//		System.out.println();
//		System.out.println("<------------------------------------------------------------------->");
//		CoinCombination1(coins, 6, "", 0, 0);
//		ArrayList<Integer> al = NearlySortedAlgo(NearlySortedAlgo);
//		System.out.println(al.size());
//		int trap[] = {9,8,7,6,5,4,3,2,1};
////		System.out.println(maxSlidingWindow(trap,4));
//		int getSkyline[][] = {{2 ,9 ,10}, {3 ,7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//		getSkyline(getSkyline);
	int[][] trapRainWater = {{5,8,7,7},{5,2,1,5},{7,1,7,1},{8,9,6,9},{9,8,9,9}};
	//	System.out.println(trapRainWater(trapRainWater));
	//System.out.println(LongestPrefixSufix("3[a]2[bc]"));
	System.out.println(Math.ceil( Math.log(6)/Math.log(2)));
		//System.out.println(NGEIII(534976));

	}

	public static void CoinPermutation(int[] coin, int AmtToPay, String WaysToPay, int count) {
		if (count == AmtToPay) {
			System.out.print(WaysToPay + " ::");
			count = 0;
			return;
		}
		if (count > AmtToPay) {
			return;
		}
		for (int i = 0; i < coin.length; i++) {
			int c = coin[i];
			CoinPermutation(coin, AmtToPay, WaysToPay + (coin[i]), count + c);
		}

	}

	public static void CoinCombination(int[] coin, int AmtToPay, String WaysToPay, int count, int cnt) {
		if (count == AmtToPay) {
			System.out.println(WaysToPay);
			count = 0;
			return;
		}
		if (count > AmtToPay) {
			return;
		}
		for (int i = cnt; i < coin.length; i++) {
			int c = coin[i];
			CoinCombination(coin, AmtToPay, WaysToPay + (coin[i]), count + c, i);
		}

	}

	public static void CoinCombination1(int[] coin, int AmtToPay, String WaysToPay, int count, int cnt) {
		if (count == AmtToPay) {
			System.out.println(WaysToPay);
			count = 0;
			return;
		}

		if (count > AmtToPay) {
			return;
		}
		if (cnt > 2)
			return;
		// for (int i = cnt; i < coin.length; i++) {
		// int c = coin[i];
		CoinCombination1(coin, AmtToPay, WaysToPay + (coin[cnt]), count + coin[cnt], cnt);
		cnt++;
		int c = coin[cnt];
		CoinCombination1(coin, AmtToPay, WaysToPay + c, count + c, cnt);
		// }

	}

	public static int NGEIII(int n1) {
		char digit[] = String.valueOf(n1).toCharArray();
		int n = digit.length;
		int i;
		for (i = n - 1; i > 0; i--) {
			if (digit[i] > digit[i - 1]) {
				break;
			}
		}

		if (i == 0) {
			return -1;
		} else {
			int number = digit[i - 1];

			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (digit[j] > number && digit[j] < digit[min]) {
					min = j;
				}
			}

			swap(digit, i - 1, min);

//			int start = i;
//			int end = n - 1;
//			while (start < end) {
//				swap(digit, start, end);
//				start++;
//				end--;
//			}
		}

		Arrays.sort(digit, i, n);
		String s = "";
		int m = 1;
		int ans = 0;
		for (int k = digit.length - 1; k >= 0; k--) {
			ans += m * digit[k];
			m *= 10;
		}
		return ans;
	}

	private static void swap(char ar[], int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}

	public static ArrayList<Integer> NearlySortedAlgo(int[][] arr) {
		ArrayList<Integer> al = new ArrayList<Integer>();


		Comparator<pair> c = new Comparator<COINS.pair>() {
			
			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.data-o2.data;
			}
		};
		
		PriorityQueue<pair> pq = new PriorityQueue<pair>(c);
		for (int i = 0; i < arr.length; i++) {
			pq.add(new pair(arr[i][0], i, 0));
		}

		while (!pq.isEmpty()) {
			pair pop = pq.peek();
			pq.poll();

			int i = pop.i;
			int j = pop.j;
			al.add(pop.data);

			if (j + 1 < arr[i].length)
				pq.add(new pair(arr[i][j + 1], i, j + 1));
		}

		return al;

	}

	public static class pair implements Comparator<pair> {
		int data;
		int i;
		int j;

		 pair(int data, int i, int j) {
			this.data = data;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compare(pair o1, pair o2) {
			// TODO Auto-generated method stub
			return o1.data-o2.data;
		}
	}
	
	public static int trap(int[] height) {
        int[] lefthigh = new int[height.length];
        int[] righthigh = new int[height.length];
        
        int leftMax = Integer.MIN_VALUE ;
        int rightMax = Integer.MIN_VALUE;
        
        for(int i=0 ; i<height.length; i++) {
        	leftMax = Math.max(leftMax, height[i]);
        	lefthigh[i] = leftMax;
        }
        for(int i=height.length-1 ; i>=0; i--) {
        	rightMax = Math.max(rightMax, height[i]);
        	righthigh[i] = rightMax;
        }
        int ans=0;
        for(int i=1 ;i<height.length-1;i++) {
        	int hleft = lefthigh[i-1];
        	int rhigh = righthigh[i+1];
        	int temp = (Math.min(rhigh,hleft))-height[i];
        	if(temp>0)
        	 ans += temp;
        }
        return ans;
    }
	
	 public static int[] maxSlidingWindow(int[] a, int k) {
		 if (a == null || k <= 0) {
				return new int[0];
			}
			int n = a.length;
			int[] r = new int[n-k+1];
			int ri = 0;
			// store index
			Deque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < a.length; i++) {
				// remove numbers out of range k
				while (!q.isEmpty() && q.peek() < i - k + 1) {
					q.poll();
				}
				// remove smaller numbers in k range as they are useless
				while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
					q.pollLast();
				}
				// q contains index... r contains content
				q.offer(i);
				if (i >= k - 1) {
					r[ri++] = a[q.peek()];
				}
			}
			return r;
	    }
	 
	 public static List<int[]> getSkyline(int[][] buildings) {
		    List<int[]> result = new ArrayList<>();
		    List<int[]> height = new ArrayList<>();
		    for(int[] b:buildings) {
		        // start point has negative height value
		        height.add(new int[]{b[0], -b[2]});
		        // end point has normal height value
		        height.add(new int[]{b[1], b[2]}); 
		    }

		    // sort $height, based on the first value, if necessary, use the second to
		    // break ties
		    Collections.sort(height, (a, b) -> {
		            if(a[0] != b[0]) 
		                return a[0] - b[0];
		            return a[1] - b[1];
		    });

		    // Use a maxHeap to store possible heights
		    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

		    // Provide a initial value to make it more consistent
		    pq.offer(0);

		    // Before starting, the previous max height is 0;
		    int prev = 0;

		    // visit all points in order
		    for(int[] h:height) {
		        if(h[1] < 0) { // a start point, add height
		            pq.offer(-h[1]);
		        } else {  // a end point, remove height
		            pq.remove(h[1]);
		        }
		        int cur = pq.peek(); // current max height;
		  
		        // compare current max height with previous max height, update result and 
		        // previous max height if necessary
		        if(prev != cur) {
		            result.add(new int[]{h[0], cur});
		            prev = cur;
		        }
		    }
		    return result;
		}
	 
	 public static int trapRainWater(int[][] heightMap) {
		
		 if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
	            return 0;
	        
	        Comparator<Cell> c = new Comparator<Cell>() {
				
				@Override
				public int compare(Cell a, Cell b) {
					return a.height - b.height;
				}
			};
	        PriorityQueue<Cell> queue = new PriorityQueue<>(1,c);
	        int m = heightMap.length;
	        int n = heightMap[0].length;
	        boolean[][] visited =  new boolean[m][n];
	        for(int i=0 ;i<m;i++){
	            visited[i][0] = true;
	            visited[i][n-1] = true;
	            queue.offer(new Cell(i,0,heightMap[i][0]));
	            queue.offer(new Cell(i,n-1,heightMap[i][n-1]));
	        }
	        
	        for(int i=0 ;i<n;i++){
	            visited[0][i] = true;
	            visited[m-1][i] = true;
	            queue.offer(new Cell(0,i,heightMap[0][i]));
	            queue.offer(new Cell(m-1,i,heightMap[m-1][i]));
	        }
	       int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        int result =0 ;   
	        while(!queue.isEmpty()){
	            Cell pop = queue.poll();
	            
	            for(int[] i: direction){
	                int row = i[0] + pop.row;
	                int col = i[1] + pop.col;
	                
	                if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]){
	                    visited[row][col] = true;
	                      result += Math.max(0, pop.height - heightMap[row][col]);
	                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], pop.height)));
	                }
	            }
	        }
	        
	        return result;
		 
	 }
	  public static class Cell {
	        int row;
	        int col;
	        int height;
	        public Cell(int row, int col, int height) {
	            this.row = row;
	            this.col = col;
	            this.height = height;
	        }
	    }
	  
	  public static int LongestPrefixSufix(String s) {
			
		  String[] st = s.split("\\W");
		 
		  for(int i=0 ;i<st.length;i++) {
			  int k ;
			  try 
		        { 
		           k=  Integer.parseInt(st[i]); 
		           
		        }  
		        catch (NumberFormatException e)  
		        { 
		           k=Integer.MIN_VALUE;
		        } 
			  
			  
		  }
		  
		  
		  
		  int[] lps = new int[s.length()];
			lps[0]=0;
			
			int i=1;
			int len = 0;
			while(i<s.length()) {
				
				if(s.charAt(i)==s.charAt(len)) {
					len++;
					lps[i] = len;
					i++;
				}else {
					if(len>0) {
						len =  lps[len-1]; // lps[len-1]
					}else {
						i++;
					}
				}
			}
			return lps[lps.length-1];
		}

}