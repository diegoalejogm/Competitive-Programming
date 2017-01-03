package ch4;

import java.util.*;
import java.io.*;

class ANodeTooFar336 {
	
	static int visited;	
	static int[] status;
	static boolean[] cycle;
	static int[] counts;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int NC = 0;
		int nq = 1;
		
		while((NC = sc.nextInt()) != 0)
		{
			int numNodes = 0;
			ArrayList<Integer> nodes = new ArrayList<Integer>();
			HashMap<Integer, Boolean> existingNode = new HashMap<Integer, Boolean>();
			HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
			
			for (int i = 0; i < NC; i++)
			{
				int u = sc.nextInt(), v = sc.nextInt();
				if(!nodes.contains(u)) nodes.add(u);
				if(!nodes.contains(v)) nodes.add(v);
				
				if(!existingNode.containsKey(u))
				{
					existingNode.put(u, true);
					adj.put(u, new ArrayList<Integer>());
					numNodes++;
				}
				
				if(!existingNode.containsKey(v))
				{
					existingNode.put(v, true);
					adj.put(v, new ArrayList<Integer>());
					numNodes++;
				}
				
				adj.get(u).add(v);
				adj.get(v).add(u);
				
			}
			int s = sc.nextInt();
			int ttl= sc.nextInt();
			
			
			
			while(s != 0 || ttl != 0)
			{
				if(!nodes.contains(s))
				{
					pw.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.%n", nq++, numNodes, s, ttl);
					s = sc.nextInt(); ttl= sc.nextInt();
					continue;
				}
				
				visited = 0;
				HashMap<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
				for(int i = 0 ; i < nodes.size(); i++)
				{
					isVisited.put(nodes.get(i), false);
				}
				
				Queue<Integer> q = new LinkedList<Integer>();
				Queue<Integer> lvl = new LinkedList<Integer>();
				q.add(s);
				lvl.add(0);
				while(!q.isEmpty())
				{
					int x = q.remove();
					int level = lvl.remove();
					if(isVisited.get(x) || level > ttl) continue;
					isVisited.put(x,true); visited++;
					for(int i = 0; i < adj.get(x).size(); i++)
					{
						q.add(adj.get(x).get(i));
						lvl.add(level+1);
					}
				}
				pw.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.%n", nq++, numNodes-visited, s, ttl);
				s = sc.nextInt(); ttl= sc.nextInt();
			}
		}
		sc.close();
		pw.close();
	}
}