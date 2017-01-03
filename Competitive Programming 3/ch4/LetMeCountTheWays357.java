package ch4;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LetMeCountTheWays357 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int num;
		
		int[] coins = {1, 5, 10, 25, 50};
		int amount = 30000;
		long[] ways = new long[amount+1];
		ways[0] = 1;
		for(int i = 0 ; i < coins.length ; i++ )
		{
			for(int j = 1; j < amount+1; j++)
			{
				if(j-coins[i] >= 0) ways[j]+=ways[j-coins[i]];
			}
		}
		while(sc.hasNextInt())
		{
			num = sc.nextInt();
			if(ways[num]==1) pw.printf("There is only 1 way to produce %d cents change.%n", num);
			else pw.printf("There are %d ways to produce %d cents change.%n", ways[num], num);
		}
		sc.close();
		pw.close();
	}

}
