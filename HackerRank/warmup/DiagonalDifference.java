import java.io.*;
import java.util.*;

public class DiagonalDifference{//Solution {

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
      int N = sc.nextInt();
      long left = 0, right = 0;

      for(int i = 0; i < N; i++){
        for(int j = 0; j<N;j++){
          int num = sc.nextInt();
          if(i==j){left+=num;}
          if(i+j==N-1){right+=num;}
        }
      }
      pw.println(Math.abs(left-right));
      pw.close();
    }
}
