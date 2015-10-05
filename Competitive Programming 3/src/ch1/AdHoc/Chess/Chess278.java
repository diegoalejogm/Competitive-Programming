import java.io.*;

class Chess278 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int num = Integer.parseInt(br.readLine());
		while(num-->0)
		{
			String[] ln = br.readLine().split(" ");
			char piece = ln[0].charAt(0);
			int m = Integer.parseInt(ln[1]), n = Integer.parseInt(ln[2]);

			int ans = 0;
			if(piece == 'r' || piece == 'Q') ans = Math.min(m,n);
			else if(piece == 'k') ans = (m/2+m%2)*(n/2+n%2) + (m/2)*(n/2);
			else if(piece == 'K') ans = (m/2+m%2)*(n/2+n%2);
			pw.println(ans);
		}
		br.close();
		pw.close();
	}
}
