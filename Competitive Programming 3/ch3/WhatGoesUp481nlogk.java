package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class WhatGoesUp481nlogk {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> realSeq = null;
		while(sc.hasNextInt())
		{
			
			int num = sc.nextInt();
			if(seq.size() == 0 || seq.get(seq.size()-1) < num)
			{
				seq.add(num);
				realSeq = (ArrayList<Integer>) seq.clone();
			}
			else
			{
				int index = Collections.binarySearch(seq, num);
				if(index < 0) index= index*(-1)-1;
				seq.set(index, num);
				if(index == seq.size()-1) realSeq = (ArrayList<Integer>) seq.clone();
			}

		}
		pw.println(seq.size()); pw.println("-");
		for(Integer num : seq)
		{
			pw.println(num);
		}
		
		sc.close();
		pw.close();
	}
	
}
