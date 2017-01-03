package ch2;
import java.util.*;
import java.io.*;
public class DemandingDIlemma11550 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while( t--> 0)
		{
			boolean ug = true;
			String[] first = br.readLine().split(" ");
			int n = Integer.parseInt(first[0]); int nn = n;
			int m = Integer.parseInt(first[1]);
			
			if(n == 0) ug = false;
			else if (m == 0)
			{
				ug = true;
				while(n -->0) br.readLine();
			} 
			else
			{
				int[] edgeVertex = new int[m];
				Arrays.fill(edgeVertex, -1);
				boolean[][] connectionExists = new boolean[n][n];
				while(n --> 0)
				{
					int currentV = nn-n-1;	String[] row = br.readLine().split(" ");
					for (int i = 0; i < m && ug; i++) 
					{
						if(row[i].charAt(0) == '1')
						{
							int existingVertex = edgeVertex[i];
							if (existingVertex == -1) edgeVertex[i] = currentV;
							else if (existingVertex == -2) ug = false;
							else
							{
								if(connectionExists[existingVertex][currentV]) ug = false;
								else
								{
									connectionExists[existingVertex][currentV] = true;
									connectionExists[currentV][existingVertex] = true;
									edgeVertex[i] = -2;
								}
							}
						}
					}
				}
				for (int i = 0; i < edgeVertex.length && ug; i++) {
					if(edgeVertex[i] != -2) ug = false;
				}
			}
			String resp = (ug)?"Yes":"No";
			System.out.println(resp);
		}
		
	}
}

