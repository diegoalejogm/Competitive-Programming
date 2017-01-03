package ch4;

import java.io.*;

public class HowDoYouAdd10943 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		String ln;
		int n = 0, k = 0;

		//long begin = System.currentTimeMillis();
		
		// Generate DP matrix
		long[][] ways = new long[101][101];
		for(int i = 0; i < 101 ; i++)
		{
			for(int j = 0; j < 101 ; j++)
			{
				if (i == 0) ways[i][j] = 1;
				else if(j == 0) ways[i][j] = 0;
				else
				{
					for(int l = 0 ; l < 101; l++)
					{
						if(i-l >= 0 && j-1 >= 0) ways[i][j] += ways[i-l][j-1]%1000000;
					}
				}
			}
		}
		
		for(int i = 0; i < 101 ; i++)
		{
			for(int j = 0; j < 101 ; j++)
			{
				ways[i][j] = ways[i][j] % 1000000; 
			}
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end-begin);
		
		// Get n and k, print answer.
		while( (ln = br.readLine()) != null && !ln.equals("")) 
		{
			n = Integer.parseInt(ln.split(" ")[0]);
			k = Integer.parseInt(ln.split(" ")[1]);
			if(n==0 && k == 0) break;
			pw.println(ways[n][k]);
		}
		br.close();
		pw.close();
	}
}
