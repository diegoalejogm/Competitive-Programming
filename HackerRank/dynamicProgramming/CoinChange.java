// O(NM) Time
// O(NM) Space
import java.io.*;
import java.util.*;

public class CoinChange{//Solution {

    private static long[][] ways;
    private static int[] value;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int N = sc.nextInt(), M = sc.nextInt();
        ways = new long[N+1][M+1] ; value = new int[M+1];
        for(long[] row : ways){ Arrays.fill(row,-1);}
        for(int i = 1 ; i <= M ; i++){value[i] = sc.nextInt();}

        pw.println(ways(N,M));
        pw.close();
    }

    private static long ways(int i, int j){
      if(i==0){return 1;}
      else if(i < 0 || j <= 0){ return 0;}
      else{
        if(ways[i][j] == -1){ways[i][j] = ways(i-value[j], j) + ways(i,j-1);}
        return ways[i][j];
      }
    }
}

// O(NM) Time
// O(N) Space
public class Solution {

    private static int[] ways;
    private static int[] value;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int N = sc.nextInt(), M = sc.nextInt();
        ways = new int[N+1] ; value = new int[M+1];

        for(int j = 1 ; j <= M ; j++){value[j] = sc.nextInt();}

        for(int j = 1; j <= M ; j++){
          for(int i = 0 ; i<=N ; i++){
            if(i == 0) { ways[i] = 1;}
            else{
              if(i-value[j] >= 0){ways[i]+=ways[i-value[j]];}
            }
          }
        }

        pw.println(ways[N]);
        pw.close();
    }
}
