package ch4;
import java.util.*;
import java.io.*;
import structures.*;

public class LiftHopping10801 {
	
	static int n;
	static boolean[][][][] adj;
	static int[] times;
	static boolean[][] floors;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String ln;
		while((ln = br.readLine()) != null)
		{
			//1
			n = Integer.parseInt(ln.split(" ")[0]);
			int k = Integer.parseInt(ln.split(" ")[1]);
			adj = new boolean[n][100][n][100];
			//2
			String[] timesS = (ln=br.readLine()).split(" ");
			times= new int[timesS.length];
			for(int i = 0; i < timesS.length ; i++)
			{
				times[i] = Integer.parseInt(timesS[i]);
			}
			// 3
			floors = new boolean[n][100];

			for(int elevator = 0; elevator < n ; elevator++)
			{
				String[] floorsS = (ln=br.readLine()).split(" ");
				for(int j = 0; j < floorsS.length ; j++)
				{
					int floor = Integer.parseInt(floorsS[j]);
					floors[elevator][floor] = true;
					if(j > 0)
					{
						int lastFloor = Integer.parseInt(floorsS[j-1]);
						adj[elevator][lastFloor][elevator][floor] = true;
						adj[elevator][floor][elevator][lastFloor] = true;
					}
					for(int i = 0; i < elevator ; i++)
					{
						if(floors[i][floor])
						{
							adj[elevator][floor][i][floor] = true;
							adj[i][floor][elevator][floor] = true;
						}
					}
				}
			}
			
			int ans = dijkstra(k);
			if(ans == 1000000000) pw.println("IMPOSSIBLE");
			else pw.println(ans);
			pw.flush();
		}
		pw.close();
	}
	
	static int dijkstra(int end)
	{
		int[][] dist = new int[n][100];
		for(int i = 0; i < dist.length ; i++)
		{
			Arrays.fill(dist[i], 1000000000);
		}
		PriorityQueue<IntegerThree> pq = new PriorityQueue<IntegerThree>();
		for(int i = 0; i < n; i++)
		{
			if(floors[i][0])
			{
				dist[i][0] = 0;
				pq.add(new IntegerThree(i, 0, 0));
				break;
			}
		}
		while(!pq.isEmpty())
		{
			IntegerThree top = pq.poll();
			int uElevator = top._x; int uFloor = top._y;
			int d = top._z;
			if(d > dist[uElevator][uFloor]) continue;
			for(int j = 0 ; j < n ; j++)
			{
				for(int l = 0; l < 100 ; l++)
				{
					if(!adj[uElevator][uFloor][j][l]) continue;
					int distance = 0;
					if(uElevator == j) distance = Math.abs((uFloor-l)*times[uElevator]);
					else if(uFloor == l && uFloor != 0) distance = 60;
					if(distance + dist[uElevator][uFloor] < dist[j][l])
					{
						dist[j][l] = distance + dist[uElevator][uFloor];
						pq.add(new IntegerThree(j, l, dist[j][l]));
					}
				} 
			}
		}
		int min = dist[0][end];
		for(int j = 1 ; j < n ; j++)
		{
			min = Math.min(min, dist[j][end]);
		}
		return min;
	}
}

