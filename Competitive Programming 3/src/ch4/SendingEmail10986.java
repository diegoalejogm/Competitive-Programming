package ch4;

import java.io.*;
import java.util.*;


class SendingEmail10986 {

	static ArrayList<ArrayList<IntegerPair>> adj;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int cn = 1;
		int N = Integer.parseInt(br.readLine());
		while(N --> 0 )
		{
			String[] ln = br.readLine().split(" ");
			int n = Integer.parseInt(ln[0]);
			int m = Integer.parseInt(ln[1]);
			int S = Integer.parseInt(ln[2]);
			int T = Integer.parseInt(ln[3]);
			
			dist = new int[n];
			Arrays.fill(dist, 1000000000);
			adj = new ArrayList<>();
			for(int i = 0; i < n; i++)
			{
				adj.add(new ArrayList<IntegerPair>());
			}
			while(m-->0)
			{
				ln = br.readLine().split(" ");
				int u = Integer.parseInt(ln[0]);
				int v = Integer.parseInt(ln[1]);
				int w = Integer.parseInt(ln[2]);
				
				adj.get(u).add(new IntegerPair(v, w));
				adj.get(v).add(new IntegerPair(u, w));
			}
			
			dijkstra(S,T);
			pw.println("Case #"+ cn++ + ": " + ( (dist[T] == 1000000000)? "unreachable" : dist[T]));
		}
		pw.close();
	}
	
	static void dijkstra(int s, int f)
	{
		dist[s] = 0;
		PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>();
		pq.offer(new IntegerPair(s, 0));
		while(!pq.isEmpty())
		{
			IntegerPair top = pq.poll();
			int u = top.getX(); int d = top.getY();
			if(d > dist[u]) continue;
			for(IntegerPair p : adj.get(u))
			{
				int v = p.getX();
				int weightUV = p.getY();
				if(dist[u] + weightUV < dist[v])
				{
					dist[v] = dist[u] + weightUV;
					pq.offer(new IntegerPair(v, dist[v]));
				}
			}
		}
	}
}

class IntegerPair implements Comparable
{
	private int _x, _y;
	
	public IntegerPair(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	@Override
	public int compareTo(Object o) {
		return this._y - ((IntegerPair)o)._y;
	}
}




