package ch3;
import java.io.*;
import java.util.*;

class Password01262 {
	
	static char[][] matrix1;
	static char[][] matrix2;
	static int counter, K; 
	static String ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		matrix1 = new char [5][6];
		matrix2 = new char [5][6];
	
		
		int T = Integer.parseInt(br.readLine());
		while (T --> 0){
			
			K = Integer.parseInt(br.readLine());			
			for (int i = 0; i<6; i++){
				String line = br.readLine();
				for (int j = 0; j<5; j++){
					matrix1[j][i] = line.charAt(j);
				}
			}

			for (int i = 0; i<6; i++){
				String line = br.readLine();
				for (int j = 0; j<5; j++){
					matrix2[j][i] = line.charAt(j);
				}	
			}
			for (int j = 0; j<5; j++) {
				Arrays.sort(matrix1[j]);
				Arrays.sort(matrix2[j]);
			}
			
			for (int j = 0; j<5; j++) {
				for (int i = 0; i<5; i++){
					if(matrix1[j][i] == matrix1[j][i+1]) matrix1[j][i] = '?';
					if(matrix2[j][i] == matrix2[j][i+1]) matrix2[j][i] = '?';
				}
			}
//-------------------------------------------------------------------------
			counter = 0; ans = "";
			findNext("", 0);
			System.out.println(ans.equals("")? "NO" : ans);
		}
	}
	public static void findNext(String possible, int column)
	{
		if(column == 5){
			counter++;
			if(counter == K) ans = possible;
			return;
		} 
		int leftRow = 0; int rightRow = 0;
		char leftChar; char rightChar;
			
		while(counter < K && leftRow < 6 && rightRow <6)
		{
			leftChar = matrix1[column][leftRow];
			rightChar = matrix2[column][rightRow];
			
			if(leftChar == '?' || leftChar < rightChar) leftRow++;
			else if( rightChar == '?'|| leftChar > rightChar) rightRow++;
			else
			{
				findNext(possible + leftChar, column+1);
				if(leftRow > rightRow) rightRow++;
				else leftRow++;
			} 
		}
		return;
	}
}