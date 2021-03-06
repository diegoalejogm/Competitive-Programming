package ch2;
import java.io.*;
import java.util.*;

public class SplittingNumbers11933
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ln;
		while( !(ln = br.readLine()).equals("0") )
		{
			long ind = 0;
			long a = 0; long b = 0;
			boolean isB = false;
			for(long i = Long.parseLong(ln); i > 0; i = i >> 1)
			{
				if(i%2 == 1)
				{
					if(!isB) a = a | 1<<ind; 
					else 	 b = b | 1<<ind; 
					isB = !isB;
				}
				ind++;
			}
			System.out.println(a+" "+ b);
		}
	}
}