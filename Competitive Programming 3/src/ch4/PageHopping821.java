package ch4;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PageHopping821 {

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		
		int one = sc.nextInt();
		int two = sc.nextInt();
		while(one != 0 && two != 0)
		{
			int[][] dist = new int[101][101];
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for(int i = 0; i < dist.length ; i++) Arrays.fill(dist[i], 1000000000);
			while(one != 0 && two != 0)
			{
				if(!numbers.contains(one)) numbers.add(one);
				if(!numbers.contains(two)) numbers.add(two);
				dist[one][two] = 1;
				one = sc.nextInt();
				two = sc.nextInt();
			}
			
			for(int k = 1; k <= 100; k++)
			{
				for(int i = 1; i <= 100; i++)
				{
					for(int j = 1; j <= 100; j++)
					{
						if(dist[i][k] + dist[k][j] < dist[i][j])
						{
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			
			float sum = 0;
			for(Integer number : numbers)
			{
				for(Integer number2 : numbers)
				{
					if(number != number2)
					{
						sum+=dist[number][number2];
					}
				}
			}
			sum/= (numbers.size()*(numbers.size()-1));
			//pw.printf("Case %d: average length between pages = %.3f clicks%n", tc++, sum );
			DecimalFormat df = new DecimalFormat();
			df.setMinimumFractionDigits(3);
			df.setMaximumFractionDigits(3);
			pw.println("Case " + tc++ + ": average length between pages = " + df.format(sum) + " clicks");
//			pw.flush();
			
			one = sc.nextInt();
			two = sc.nextInt();
		}
		sc.close();
		pw.close();
	}
}
