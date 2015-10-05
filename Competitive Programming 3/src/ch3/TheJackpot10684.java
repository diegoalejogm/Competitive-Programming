import java.io.*;
import java.math.*;
import java.util.*;

class  TheJackpot10684{
	public static void main(String[] args) throws Exception{

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n != 0)
		{
			int ans= 0;  int sum = 0;
			int counter = n;
			while(counter-->0)
			{
				int currentInt = sc.nextInt();
				sum += currentInt;
				ans = Math.max(ans, sum);
				if(sum < 0) sum = 0;
			}
			String s = (ans > 0)? "The maximum winning streak is " + ans + "." : "Losing streak.";
			pw.println(s);

			n = sc.nextInt();
		}
		pw.close();
	}
}