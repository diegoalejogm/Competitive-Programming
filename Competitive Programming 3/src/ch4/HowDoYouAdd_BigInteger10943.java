package ch4;

import java.io.*;
import java.math.BigInteger;

public class HowDoYouAdd_BigInteger10943 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		String ln;
		int n = 0, k = 0;
		
		//long begin = System.currentTimeMillis();
		// Generate DP matrix
		BigInteger[][] ways = new BigInteger[101][101];
		for(int i = 0; i < 101 ; i++)
		{
			for(int j = 0; j < 101 ; j++)
			{
				ways[i][j] = new BigInteger("0");
			}
		}
		for(int i = 0; i < 101 ; i++)
		{
			for(int j = 0; j < 101 ; j++)
			{
				if (i == 0) ways[i][j] = new BigInteger("1");
				else if(j == 0) ways[i][j] = new BigInteger("0");
				else
				{
					for(int l = 0 ; l < 101; l++)
					{
						if(i-l >= 0 && j-1 >= 0) ways[i][j] = ways[i][j].add(ways[i-l][j-1]);
					}
				}
			}
		}
		BigInteger mod = new BigInteger("1000000");
		for(int i = 0; i < 101 ; i++)
		{
			for(int j = 0; j < 101 ; j++)
			{
				ways[i][j] = ways[i][j].mod(mod);
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
			pw.println(ways[n][k].toString());
		}
		br.close();
		pw.close();
	}
}
