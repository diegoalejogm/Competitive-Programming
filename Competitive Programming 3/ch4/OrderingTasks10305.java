package ch4;

import java.io.*;
import java.util.*;

class OrderingTasks10305 {

	static ArrayList<ArrayList<Integer>> adj;
	static String ln;
	static boolean[] visited; 
	static String ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


		while( ( ln = br.readLine()) != null)
		{
			int n = Integer.parseInt(ln.split(" ")[0]);
			int m = Integer.parseInt(ln.split(" ")[1]);

			if(n == m && m == 0) break;

			adj = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[n+1];
			ans = "";
			for (int i = 0; i <= n; i++) adj.add(new ArrayList());
			for (int i = 0; i < m; i++)
			{
				ln = br.readLine();
				int u = Integer.parseInt(ln.split(" ")[0]);
				int v = Integer.parseInt(ln.split(" ")[1]);
				adj.get(u).add(v);

			}				
			for (int i = 1; i <= n; i++) 
			{
				if(!visited[i]) dfs(i, pw);
			}
			pw.println(ans);
		}
		pw.close();
		br.close();
	}

	public static void dfs(int i, PrintWriter pw)
	{

		visited[i] = true;

		for (int j = 0; j < adj.get(i).size() ; j++ ) 
		{
			int v = adj.get(i).get(j);
			if(!visited[v]) dfs(v, pw);
		}

		ans = i + " " + ans;
		return ;
	}
}