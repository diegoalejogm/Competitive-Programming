package ch4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class MaximiumSubSequenceProduct787 {

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		ArrayList<BigInteger> nums = new ArrayList<>();
		ArrayList<BigInteger> maximums = new ArrayList<>();
		while(sc.hasNextInt())
		{
			int num = sc.nextInt();
			if(num==-999999)
			{
				BigInteger act = nums.get(0);
				BigInteger max = act;
				
				for(int i = 1; i<maximums.size(); i++)
				{
					act = maximums.get(i);
					if(act.compareTo(max) > 0) max = act;
				}
				
				pw.println(max);
				nums = new ArrayList<>();
				maximums = new ArrayList<>();
			}
			else
			{
				BigInteger next = new BigInteger(num+"");
				nums.add(next);
				
				BigInteger max = next;
				BigInteger act = next;
				
				for(int i = nums.size()-2; i>=0; i--)
				{
					act = act.multiply(nums.get(i));
					if(act.compareTo(max) > 0) max = act;
				}
				maximums.add(max);
			}
		}
		sc.close();
		pw.close();
	}
}
