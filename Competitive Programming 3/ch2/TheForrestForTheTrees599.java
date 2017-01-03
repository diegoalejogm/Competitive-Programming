package ch2;

import java.util.*;
import java.io.*;

class TheForrestForTheTrees599 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String ln;
		while(tc-->0)
		{
			int tree = 0;
			int acorn = 0;
			adjList.clear();
			dfs_num.clear();
			dfs_num.addAll(Collections.nCopies('Z'-'A'+1, false));
			for (int i = 0; i < 'Z'-'A'+1; i++) {
				ArrayList<Integer> neighbor = new ArrayList<Integer>();
				adjList.add(neighbor);
			}
			while( (ln = br.readLine()).charAt(0) != '*')
			{
				int oIndex = ln.charAt(1)-'A';
				int dIndex = ln.charAt(3)-'A';
				adjList.get(oIndex).add(dIndex);
				adjList.get(dIndex).add(oIndex);				
			}
			String[] chars = br.readLine().split(",");
			boolean[] uses = new boolean['Z'-'A'+1];
			for (int i = 0; i < chars.length; i++) {
				uses[chars[i].charAt(0) -'A'] = true;
			}
			
			for (int i = 0; i < 'Z'-'A'+1; i++) {
				if(uses[i] && adjList.get(i).size() == 0) acorn++;
				else if(uses[i] && dfs_num.get(i) == false)
				{
					dfs(i);
					tree++;
				} 
			}
			System.out.println("There are "+tree+" tree(s) and "+ acorn+" acorn(s).");
		}
	}
	
	public static void dfs(int u) { // DFS for normal usage
	    dfs_num.set(u, true); // mark as visited
	    Iterator it = adjList.get(u).iterator();
	    while (it.hasNext()) { // try all neighbors v of vertex u
	      Integer v = (Integer)it.next();
	      if (dfs_num.get(v) == false) // avoid cycle
	        dfs(v); // v is a (neighbor, weight) pair
	    }
	  }
	
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
	static ArrayList< Boolean > dfs_num = new ArrayList< Boolean > ();
}