import java.io.*;
import java.math.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int testSet = 1;

		String ln;

		while( (ln = br.readLine()) != null)
		{
			int[][] adj = new int[21][21];

			for(int i = 1 ; i < adj.length ; i++)
			{
				for(int j = 1 ; j < adj.length ; j++) adj[i][j] = 1000000000;

				adj[i][i] = 0;
			}

			for(int i = 1; i < 20 ; i++)
			{
				String[] ln1 = ln.split(" ");

				for(int j = 1 ; j < ln1.length ; j++)
				{
					int u = i; 
					int v = Integer.parseInt(ln1[j]);
					adj[u][v] = 1;
					adj[v][u] = 1;
				}
				ln = br.readLine();
			}

			adj = fw(adj);

			int N = Integer.parseInt(ln);

			// Print Answer
			String msg = "Test Set #"+testSet++;
			pw.println(msg);
			while(N-->0)
			{
				String[] ln1 = br.readLine().split(" ");
				int u = Integer.parseInt(ln1[0]); 
				int v = Integer.parseInt(ln1[1]);
				
				msg = ( (u > 9) ? u: " "+u ) + " to " + ( (v > 9) ? v : " " + v ) + ": " + adj[u][v];
				pw.println(msg);
			}
			pw.println();
			// pw.flush();
		}

		br.close();
		pw.close();
	}

	static int[][] fw(int[][] adj)
	{
		for(int k = 1 ; k < adj.length ; k++)
		{
			for(int i = 1 ; i < adj.length ; i++)
			{
				for(int j = 1 ; j < adj.length ; j++)
				{

					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
		return adj;
	}
}