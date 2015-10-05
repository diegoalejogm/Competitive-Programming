// Not Finished Yet
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = br.readLine(); int N = n;
		int[][] blocks = new int[n][3];

		while(n > 0)
		{
			String[] line = br.readLine().split(" ");
			int[] dimensions = new int[line.length];
			for(int i = 0; i < line.length ;  i++) dimensions[i] = Integer.parseInt(line[i]);
			blocks[N-n] = dimensions;
			n--;
		}
	}
}