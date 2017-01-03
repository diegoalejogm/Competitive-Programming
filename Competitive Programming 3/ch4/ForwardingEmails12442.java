package ch4;

import java.util.*;
import java.io.*;

class ForwardingEmails12442 {
	
	static int[] status;
	static boolean[] cycle;
	static int[] counts;
	static ArrayList<Integer> adjList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ln;
		int t = Integer.parseInt(br.readLine());
		int tt = t;
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			status = new int[n+1]; Arrays.fill(status, -1);
			cycle = new boolean[n+1];
			counts = new int[n+1];		
			adjList = new ArrayList<Integer>();
			for(int i = 0; i <= n ; i++) adjList.add(null);
			while(n-->0)
			{
				ln = br.readLine().split(" ");
				int u = Integer.parseInt(ln[0]), v = Integer.parseInt(ln[1]);
				adjList.set(u, v);
			}
			
			int maxIndex = 0;
			int maxCount = 0;
			for(int i = 1; i < status.length; i++)
			{
				if(status[i] == -1)
				{
					int count = dfs(i);
					if(count > maxCount)
					{
						maxCount = count;
						maxIndex = i;
					}
				}
			}
			System.out.println("Case " + (tt-t) + ": " + maxIndex);
		}
	}
	
	static int dfs(int m)
	{
		if(status[m] == 1) return counts[m];
		status[m] = 0;
			
		int nextChilds = 0; int next = adjList.get(m);
		if(status[next] == -1)  nextChilds = dfs(next);
		else if (status[next] == 0)
		{
			nextChilds = 0;
			cycle[next] = true;
		} 
		else nextChilds = counts[next];
		
		counts[m] = 1 + nextChilds;
		if(cycle[m] == true) setCycle(counts[m], next);
		status[m] = 1;
		return counts[m];
	}
	
	static void setCycle(int c, int n)
	{
		while(counts[n] != c)
		{
			counts[n] = c;
			n = adjList.get(n);
		}
	}
}