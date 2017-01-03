package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * This solution to UVA's problem 481 runs in nums^2. It uses a DP approach and runs correctly, but gives TLE in UVA
 * @author Diego
 */
public class WhatGoesUp481n2 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> maxInSeq = new ArrayList<Integer>();
		
		int maxIndex = -1;
		int maxVal = Integer.MIN_VALUE;
		while(sc.hasNextInt())
		{
			int num = sc.nextInt();
			nums.add(num);
			
			int newSeq = -1;
			int newMaxInSeq = 1;
			
			for(int j = 0; j < nums.size()-1; j++)
			{
				int prevNum = nums.get(j);
				if(num > prevNum)
				{
					newMaxInSeq = Math.max(newMaxInSeq, maxInSeq.get(j)+1);
					newSeq =  newMaxInSeq == maxInSeq.get(j)+1? j : newSeq;
				}
			}
			seq.add(newSeq);
			maxInSeq.add(newMaxInSeq);
			if(newMaxInSeq >= maxVal)
			{
				maxIndex = nums.size()-1;
				maxVal = newMaxInSeq;
			}
		}
		
		int nextIndex = maxIndex;
		// Printing
		pw.println(maxVal); pw.println("-");
		
		StringBuffer result = new StringBuffer();
		while(nextIndex != -1)
		{
			result.insert(0, nums.get(nextIndex) + System.lineSeparator());
			nextIndex = seq.get(nextIndex);
		}
		
		pw.print(result.toString());

		sc.close();
		pw.close();
	}
	
}
